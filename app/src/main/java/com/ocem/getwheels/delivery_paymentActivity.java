package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ocem.getwheels.Modelresponse.BookingResponse;
import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class delivery_paymentActivity extends AppCompatActivity {
    private Button ok4;
    private TextView change;
    private TextView phoneview, mailview;
    private TextView payment;
    TextView pulchowk, time1;
    ImageView car;
    TextView car1, price1;

    String showPlaceFor;
    String showDateFor;
    String phonenum;
    String emailadd;
    SharedPrefsHelper sharedPrefsHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_payment);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);

        phoneview = findViewById(R.id.phoneview);
        mailview = findViewById(R.id.mailview);
        ok4 = findViewById(R.id.ok4);
        payment = findViewById(R.id.payment);
        pulchowk = findViewById(R.id.pulchowk);
        time1 = findViewById(R.id.time1);
        car = findViewById(R.id.car);
        car1 = findViewById(R.id.car1);
        price1 = findViewById(R.id.price1);

//        String phonenum = getIntent().getStringExtra("keynum");
//        String emailadd = getIntent().getStringExtra("keymail");
//
//        phoneview.setText(phonenum);
//        mailview.setText(emailadd);

        // replace with share preference
        /*// show the passed data here
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String showPlace = bundle.getString("selectedPlace");
            String showDate = bundle.getString("selectedDate");
            String keynum = bundle.getString("keynum");
            String keymail = bundle.getString("keymail");
            showPlaceFor = showPlace;
            showDateFor = showDate;
            phonenum = keynum;
            emailadd = keymail;
            Log.i(TAG, "onCreate: received data from identification to delivery payment: " + showPlace + " " + showDate);
        }
        // finally show the received data in textView
        pulchowk.setText(showPlaceFor);
        time1.setText(showDateFor);
        phoneview.setText(phonenum);
        mailview.setText(emailadd);*/

        pulchowk.setText(sharedPrefsHelper.getValue(Constant.SELECTED_PLACE,""));
        time1.setText(sharedPrefsHelper.getValue(Constant.SELECTED_DATE,""));
        phoneview.setText(sharedPrefsHelper.getValue(Constant.PHONE_NUM,""));
        mailview.setText(sharedPrefsHelper.getValue(Constant.EMAIL,""));

        // show selected car image, car name, car price per day
        car.setImageResource(R.drawable.bmw);
        car1.setText(sharedPrefsHelper.getValue(Constant.SELECTED_CAR_NAME, ""));
        price1.setText("Rs. " + sharedPrefsHelper.getValue(Constant.SELECTED_CAR_PRICE, "") + "");

        ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(delivery_paymentActivity.this, Bookingconfirmed.class);
                startActivity(intent);


                String token = "Bearer " +sharedPrefsHelper.getValue(Constant.TOKEN,"");
                String userId = String.valueOf(sharedPrefsHelper.getValue(Constant.USER_ID,0));
                String address = sharedPrefsHelper.getValue(Constant.SELECTED_PLACE,"");
                String fullName = sharedPrefsHelper.getValue(Constant.FULL_NAME,"");
                String phoneNum = sharedPrefsHelper.getValue(Constant.PHONE_NUM,"");
                String email = sharedPrefsHelper.getValue(Constant.EMAIL,"");
                String dob = sharedPrefsHelper.getValue(Constant.DATE_OF_BIRTH,"");
                String citizenship = sharedPrefsHelper.getValue(Constant.CITIZENSHIP,"");
                String license = sharedPrefsHelper.getValue(Constant.LICENSE,"");

                Log.i(TAG, "onClick: " +token+ " userid" +userId+ " address" +address+ " fullname" +fullName+ " phone" +phoneNum+ " email" +email+ " dob" +dob+" citizenship" +citizenship+ " license" +license);


                String accept = "application/json";
                String date1= "2022-02-16", date2= "2022-02-20",total= "5000", status= "1";


                Call<BookingResponse> call = RetrofitClient
                        .getInstance()
                        .getapi()
                        .requestForBooking(token, date1,date2,address,fullName,phoneNum,email,dob,citizenship,license,total,status,userId);

                call.enqueue(new Callback<BookingResponse>() {
                    @Override
                    public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                        Log.i(TAG, "onResponse: response code: " +response.code());
                        if (response.code()==200){
                            Toast.makeText(delivery_paymentActivity.this, "Booking is successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Log.i(TAG, "onResponse: booking failed" +response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<BookingResponse> call, Throwable t) {
                        Log.i(TAG, "onResponse: Failure: " +t.getMessage());
                    }
                });

                // value to be send
                // from_date,to_date,address,full_name,phone,email,date_of_birth,citizenship_number,license_number,total,status,user_id
            }
        });

    }
}

