package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ocem.getwheels.Modelresponse.Vehiclecategory;
import com.ocem.getwheels.Modelresponse.VehileCategoryResponse;
import com.ocem.getwheels.adapter.CarListAdapter;
import com.ocem.getwheels.model.CarListModel;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarListActivity extends AppCompatActivity {

    private TextView etlocation;
    private TextView placeview, dateview;
    String showPlaceFor;
    String showDateFor;

    List<CarListModel> carServiceList;
    CarListAdapter carListAdapter;

    // attributes
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        dateview = findViewById(R.id.dateview);
        placeview = findViewById(R.id.placeview);

        // load data from restAPI
        loadData();

        placeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarListActivity.this, dateActivity.class);
                startActivity(intent);
            }
        });

        // 1.2 assign id
        recycle = findViewById(R.id.recycleview);

        recycle.setLayoutManager(new LinearLayoutManager(this));

    }


    private void loadData() {
        Call<VehileCategoryResponse> call = RetrofitClient
                .getInstance()
                .getapi()
                .getVehicle();

        call.enqueue(new Callback<VehileCategoryResponse>() {
            @Override
            public void onResponse(Call<VehileCategoryResponse> call, Response<VehileCategoryResponse> response) {
                if (response.code() == 200) {
                    Log.i(TAG, "onResponse: Success");
                    List<Vehiclecategory> list = response.body().getVehiclecategorie();

                    carServiceList = new ArrayList<>();
                    CarListModel carlist;
                    // looping through list
                    for (int i = 0; i < list.size(); i++) {
                        carlist = new CarListModel(list.get(i).getId(), list.get(i).getImage(), list.get(i).getModelName(), "2", list.get(i).getCostPerDay());
                        carServiceList.add(carlist);
                    }

                    carListAdapter = new CarListAdapter(carServiceList, CarListActivity.this, showPlaceFor, showDateFor);
                    recycle.setAdapter(carListAdapter);

                }
            }

            @Override
            public void onFailure(Call<VehileCategoryResponse> call, Throwable t) {
                Toast.makeText(CarListActivity.this, "Unable to get data from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}