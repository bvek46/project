package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ocem.getwheels.Modelresponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText etusername, etpassword, etaddress, phone, etemail, etpassword1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        phone = (EditText) findViewById(R.id.phone);
        etemail = (EditText) findViewById(R.id.etemail);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etpassword1 = (EditText) findViewById(R.id.etpassword1);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn:
                registeruser();
                break;
            case R.id.tvLogin:
                switchonLogin();
                break;
        }

    }

    private void switchonLogin() {
        Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
        startActivity(intent);
    }

    private void registeruser() {

        String UserName = etusername.getText().toString();
        String UserEmail = etemail.getText().toString();
        String UserPhone = phone.getText().toString();
        String UserAddress = etaddress.getText().toString();
        String UserPassword = etpassword.getText().toString();
        String UserPassword1 = etpassword1.getText().toString();


        if (UserName.isEmpty()) {
            etusername.requestFocus();
            etusername.setError("Please enter your name");
            return;
        }

        if (UserEmail.isEmpty()) {
            etemail.requestFocus();
            etemail.setError("Please enter your email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(UserEmail).matches()) {
            etemail.requestFocus();
            etemail.setError("Please enter correct email");
            return;
        }

        if (UserPhone.isEmpty()) {
            phone.requestFocus();
            phone.setError("Please enter your phone number");
            return;
        }

        if (UserAddress.isEmpty()) {
            etaddress.requestFocus();
            etaddress.setError("Please enter your address");
            return;
        }

        if (UserPassword.isEmpty()) {
            etpassword.requestFocus();
            etpassword.setError("Please enter your password");
            return;
        }


        if (UserPassword1.isEmpty()) {
            etpassword1.requestFocus();
            etpassword1.setError("Please enter your confirm password");
            return;
        }

        Call<RegisterResponse> call = RetrofitClient
                .getInstance()
                .getapi()
                .register(UserName, UserEmail, UserPhone, UserAddress, UserPassword, UserPassword1);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: Register message " + response.body().getMessage());
                    Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });


    }
}

        