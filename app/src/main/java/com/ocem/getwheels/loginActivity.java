package com.ocem.getwheels;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ocem.getwheels.Modelresponse.LoginResponse;
import com.ocem.getwheels.Modelresponse.User;
import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView signup1;
    Button tvbutton;
    EditText email, password;
    TextView textView;
    SharedPrefsHelper sharedPrefsHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);
        
        // check if previous login is saved
        checkPreviousLogin();
        
        signup1 = findViewById(R.id.signup1);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);
        tvbutton= (Button) findViewById(R.id.tvbutton);


        tvbutton.setOnClickListener(this);
    }

    private void checkPreviousLogin() {
        if (sharedPrefsHelper.getValue(Constant.TOKEN,"").length() > 10){
            startActivity(new Intent(loginActivity.this, welcome_pageActivity1.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvbutton:
                userLogin();
                break;
            case R.id.signup1:
                switchonLogin();
                break;
        }

}
    private void switchonLogin() {
        Intent intent=new Intent(loginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


    private void userLogin() {

        String UserEmail=email.getText().toString();
        String UserPassword=password.getText().toString();



        if (UserEmail.isEmpty()){
            email.requestFocus();
            email.setError("Please enter your email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(UserEmail).matches()){
            email.requestFocus();
            email.setError("Please enter correct email");
            return;
        }

        if (UserPassword.isEmpty()) {
            password.requestFocus();
            password.setError("Please enter your password");
            return;
        }



        Call<LoginResponse> call=RetrofitClient.getInstance().getapi().login(UserEmail,UserPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                User userObj = response.body().getUser();

                if(response.isSuccessful()){
                    sharedPrefsHelper.saveValue(Constant.TOKEN,response.body().getToken());
                    sharedPrefsHelper.saveValue(Constant.USER_ID,userObj.getId());
                    Intent intent=new Intent(loginActivity.this, welcome_pageActivity1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    Toast.makeText(loginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(loginActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(loginActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();

            }

        });

    }
    }