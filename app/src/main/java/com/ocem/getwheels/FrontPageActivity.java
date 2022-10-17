package com.ocem.getwheels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class FrontPageActivity extends AppCompatActivity {

    public Button tvbutton1;
    public Button tvbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        tvbutton1 = (Button) findViewById(R.id.tvbutton1);
        tvbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FrontPageActivity.this,RegisterActivity.class);
                startActivity(intent);
            }

        });

        Button tvbutton2= findViewById(R.id.tvbutton2);
        tvbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FrontPageActivity.this,loginActivity.class);
                startActivity(i);
            }
        });

    }
}