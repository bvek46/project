package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ApprovedActivity extends AppCompatActivity {

    private Button ok2;
    String selectedPlace;
    String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved);


        // show the passed data here
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String showPlace = bundle.getString("selectedPlace");
            String showDate = bundle.getString("selectedDate");
            selectedPlace = showPlace;
            selectedDate = showDate;
            Log.i(TAG, "onCreate: value received in approved from description" +showPlace+ " " +showDate);
        }

        ok2=findViewById(R.id.ok2);
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApprovedActivity.this, IdentificationActivity.class);
                startActivity(intent);

                /*// value to be send
                Bundle bundle = new Bundle();
                bundle.putString("selectedPlace", selectedPlace);
                bundle.putString("selectedDate", selectedDate);
                Intent intent = new Intent(ApprovedActivity.this, IdentificationActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);*/
//                Log.i(TAG, "onCreate: value is passed from description to identification activity" +selectedPlace+ " "+selectedDate );

            }
        });
    }
}