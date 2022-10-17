package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

public class DescriptionActivity extends AppCompatActivity {

    private Button ok1;
    TextView edit_text,edit_text1,edit_text2;
    String selectedPlace;
    String selectedDate;
    SharedPrefsHelper sharedPrefsHelper;
    TextView tvcar,price,porsche;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);

        edit_text = findViewById(R.id.edit_text);
        edit_text1 = findViewById(R.id.edit_text1);
        tvcar = findViewById(R.id.tvcar);
        price = findViewById(R.id.price);
        porsche = findViewById(R.id.porsche);
        image = findViewById(R.id.image);


        // replaced with share preference
        /*// show the passed data here
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String showPlace = bundle.getString("showPlace");
            String showDate = bundle.getString("showDate");
            edit_text.setText(showPlace);
            edit_text1.setText(showDate);
            selectedPlace = showPlace;
            selectedDate = showDate;
            Log.i(TAG, "onCreate: value received in description through recycler view" +showPlace+ " " +showDate);
        }*/

        ok1=findViewById(R.id.ok1);
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DescriptionActivity.this, ApprovedActivity.class);
                startActivity(intent);

                /*// value to be send
                Bundle bundle = new Bundle();
                bundle.putString("selectedPlace", selectedPlace);
                bundle.putString("selectedDate", selectedDate);
                Intent intent = new Intent(DescriptionActivity.this, ApprovedActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);*/
//                Log.i(TAG, "onCreate: value is passed from description to approved activity" +selectedPlace+ " "+selectedDate );
            }
        });

        // show selected date and place
        edit_text.setText(sharedPrefsHelper.getValue(Constant.SELECTED_PLACE,""));
        edit_text1.setText(sharedPrefsHelper.getValue(Constant.SELECTED_DATE,""));
        // show the selected car price per day
        tvcar.setText(sharedPrefsHelper.getValue(Constant.SELECTED_CAR_NAME,""));
        price.setText(sharedPrefsHelper.getValue(Constant.SELECTED_CAR_PRICE,""));
        porsche.setText(sharedPrefsHelper.getValue(Constant.SELECTED_CAR_NAME,""));
        image.setImageResource(R.drawable.bmw);
    }
}