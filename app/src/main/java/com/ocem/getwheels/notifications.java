package com.ocem.getwheels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.notifications);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {            @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), welcome_pageActivity1.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.bookings:
                    startActivity(new Intent(getApplicationContext(), bookingsActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.notifications:
                    return true;

                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), edit_profileActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        }
        });
    }
}