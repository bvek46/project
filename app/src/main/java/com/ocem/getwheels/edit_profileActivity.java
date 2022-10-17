package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

public class edit_profileActivity extends AppCompatActivity {
    private TextView edit_profile;
    private TextView my_bookings;
    private TextView notifications1;
    private TextView signout;

    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

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
                    startActivity(new Intent(getApplicationContext(), notifications.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.profile:
                    return true;
            }
            return false;
        }
        });

        edit_profile = findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_profileActivity.this, myprofileActivity.class);
                startActivity(intent);

            }
        });
        my_bookings = findViewById(R.id.my_bookings);
        my_bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_profileActivity.this, bookingsActivity.class);
                startActivity(intent);

            }
        });
        notifications1 = findViewById(R.id.notifications1);
        notifications1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_profileActivity.this, notifications.class);
                startActivity(intent);

            }
        });
        signout = findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // clear saved value from shared preference
                sharedPrefsHelper.clear();
                Intent intent = new Intent(edit_profileActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });
    }
}