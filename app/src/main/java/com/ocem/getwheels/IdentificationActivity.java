package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

public class IdentificationActivity extends AppCompatActivity {

    private Button ok3;
    private EditText etphonenum, etemailadd;
    EditText etFullName,etDOB,etCitizenship,etLicense;
    String selectedPlace;
    String selectedDate;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);

        etphonenum=findViewById(R.id.etphonenum);
        etemailadd=findViewById(R.id.etemailadd);
        etFullName=findViewById(R.id.etFullName);
        etDOB=findViewById(R.id.etDOB);
        etCitizenship=findViewById(R.id.etCitizenship);
        etLicense=findViewById(R.id.etLicense);


        /*// show the passed data here
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String showPlace = bundle.getString("selectedPlace");
            String showDate = bundle.getString("selectedDate");
            selectedPlace = showPlace;
            selectedDate = showDate;
            Log.i(TAG, "onCreate: value received from approved to identification" +showPlace+ " " +showDate);
        }*/

        ok3=findViewById(R.id.ok3);
        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etFullName.getText().toString().length()<4){
                    Toast.makeText(IdentificationActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }
                else if (etphonenum.getText().toString().isEmpty()){
                    Toast.makeText(IdentificationActivity.this, "Enter your phone number", Toast.LENGTH_SHORT).show();
                }
                else if (etphonenum.getText().toString().length()<10){
                    Toast.makeText(IdentificationActivity.this, "Phone number must be 10 digits", Toast.LENGTH_SHORT).show();
                }
                else if (etemailadd.getText().toString().length()<4){
                    Toast.makeText(IdentificationActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();
                }
                else if (etDOB.getText().toString().isEmpty()){
                    Toast.makeText(IdentificationActivity.this, "Enter you date of birth", Toast.LENGTH_SHORT).show();
                }
                else if(etCitizenship.getText().toString().isEmpty()){
                    Toast.makeText(IdentificationActivity.this, "Enter your citizenship number", Toast.LENGTH_SHORT).show();
                }
                else if(etLicense.getText().toString().isEmpty()){
                    Toast.makeText(IdentificationActivity.this, "Enter your license number", Toast.LENGTH_SHORT).show();
                }
                else{
                    String phonenum = etphonenum.getText().toString();
                    String emailadd = etemailadd.getText().toString();

                /*// value to be send
                Bundle bundle = new Bundle();
                bundle.putString("selectedPlace", selectedPlace);
                bundle.putString("selectedDate", selectedDate);
                bundle.putString("keynum", phonenum);
                bundle.putString("keymail", emailadd);
                Intent intent = new Intent(IdentificationActivity.this, delivery_paymentActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);*/

                    // save value to shared preferences
                    sharedPrefsHelper.saveValue(Constant.FULL_NAME,etFullName.getText().toString());
                    sharedPrefsHelper.saveValue(Constant.PHONE_NUM,etphonenum.getText().toString());
                    sharedPrefsHelper.saveValue(Constant.EMAIL,etemailadd.getText().toString());
                    sharedPrefsHelper.saveValue(Constant.DATE_OF_BIRTH,etDOB.getText().toString());
                    sharedPrefsHelper.saveValue(Constant.CITIZENSHIP,etCitizenship.getText().toString());
                    sharedPrefsHelper.saveValue(Constant.LICENSE,etLicense.getText().toString());
                    startActivity(new Intent(IdentificationActivity.this,delivery_paymentActivity.class));
                }

//                Log.i(TAG, "onCreate: value is passed from description to identification activity" +selectedPlace+ " "+selectedDate );

//
//                Intent intent1=new Intent(IdentificationActivity.this, delivery_paymentActivity.class);
//                intent1.putExtra("keynum",);
//                intent1.putExtra("keymail",emailadd);
//                startActivity(intent);
            }
        });
    }
}