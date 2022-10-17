package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class welcome_pageActivity1 extends AppCompatActivity {

    private ImageView image_car, ivBike, ivBicycle;
    CardView cvRecent1, cvRecent2, cvRecent3, cvRecent4;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page1);

        ivBike = findViewById(R.id.ivBike);
        ivBicycle = findViewById(R.id.ivBicycle);
        cvRecent1 = findViewById(R.id.cvRecent1);
        cvRecent2 = findViewById(R.id.cvRecent2);
        cvRecent3 = findViewById(R.id.cvRecent3);
        cvRecent4 = findViewById(R.id.cvRecent4);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        return true;

                    case R.id.bookings:
                        startActivity(new Intent(getApplicationContext(), list.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.notifications:
                        startActivity(new Intent(getApplicationContext(), notifications.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), edit_profileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        image_car = findViewById(R.id.image_car);
        image_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome_pageActivity1.this, CarListActivity.class);
                startActivity(intent);

            }
        });

        // click on ivBike
        ivBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Clicked on Bike", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: bike clicked");
            }
        });

        // click on ivBicycle
        ivBicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Clicked on Bicycle", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: bicycle clicked");
            }
        });

        // recent view part
        cvRecent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Recent 1st item", Toast.LENGTH_SHORT).show();
            }
        });

        cvRecent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Recent 2nd item", Toast.LENGTH_SHORT).show();
            }
        });

        cvRecent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Recent 3rd item", Toast.LENGTH_SHORT).show();
            }
        });

        cvRecent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(welcome_pageActivity1.this, "Recent 4th item", Toast.LENGTH_SHORT).show();
            }
        });


    }

}





