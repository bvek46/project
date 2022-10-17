package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ocem.getwheels.adapter.BookingAdapter;
import com.ocem.getwheels.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {
    private TextView etlocation;
    private TextView placeview, dateview;


    RecyclerView rcvCar;
    BookingAdapter myAdapter;
    List<Booking> bookingList;
    Booking booking;
    String showPlaceFor;
    String showDateFor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dateview=findViewById(R.id.dateview);
        placeview=findViewById(R.id.placeview);






        rcvCar = findViewById(R.id.rcvCar);

        bookingList = new ArrayList<>();
        // inserted data for booking list
        bookingList.add(new Booking(R.drawable.carlist,"Porsche 911 Turbo","COD","Paid",5000));
        bookingList.add(new Booking(R.drawable.bmw,"BMW 3 series Gran 2015","COD","Paid",4500));
        bookingList.add(new Booking(R.drawable.bookings,"Toyota Hilux 2021","COD","Unpaid",5000));
        bookingList.add(new Booking(R.drawable.carlist,"Porsche 915 Turbo","COD","Paid",5000));
        bookingList.add(new Booking(R.drawable.carlist,"Porsche 916 Turbo","COD","Unpaid",6000));

        // show the passed data here
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String showPlace = bundle.getString("selectedPlace");
            String showDate = bundle.getString("selectedDate");
            placeview.setText(showPlace);
            dateview.setText(showDate);

            showPlaceFor = showPlace;
            showDateFor = showDate;

            Log.i(TAG, "onCreate: value received from dateActivity to List activity" +showPlace+ " " +showDate);
        }

        rcvCar.setLayoutManager(new LinearLayoutManager(this));
        rcvCar.setHasFixedSize(true);
        myAdapter = new BookingAdapter(bookingList,this,showPlaceFor,showDateFor);
        rcvCar.setAdapter(myAdapter);

//        // value to be send
//        bundle.putString("selectedPlace", showPlace);
//        bundle.putString("selectedDate", showPlace);
//        Intent intent = new Intent(dateActivity.this, list.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
//
//        Log.i(TAG, "onCreate: value is passed: " +selectedPlace+ " "+selectedDate );


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(list.this,dateActivity.class));
    }
}