package com.ocem.getwheels;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.ocem.getwheels.sharedpreference.Constant;
import com.ocem.getwheels.sharedpreference.SharedPrefsHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateActivity extends AppCompatActivity {
    EditText text;
    ImageView calendar;
    public Button done;
    Spinner spinner;
    String[] place = {"Pulchowk, Chitwan", "Pokhara Buspark Area", "Airport Area"};

    String selectedPlace;
    String selectedDate;
    SharedPrefsHelper sharedPrefsHelper;
    String startDate;
    String endDate;
    SimpleDateFormat simpleFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);

        sharedPrefsHelper = SharedPrefsHelper.getInstance(this);

        spinner = findViewById(R.id.spinnerr);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(dateActivity.this, android.R.layout.simple_spinner_item, place);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                selectedPlace = value;
                Toast.makeText(dateActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        text = findViewById(R.id.text);
        calendar = findViewById(R.id.calendar);
        // selected two date at time
        MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.dateRangePicker().
                setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
//        int days = Days.daysBetween(date1, date2).getDays();
        Log.i("", "onCreate: This is date"+materialDatePicker);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "Tag_picker");
              /*  materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        text.setText(selection);
                        selectedDate = materialDatePicker.getHeaderText();
                        date1 = selectedDate.split("-")[0];
                        Log.i(TAG, "onPositiveButtonClick: This is date1"+date1);
                        Log.i(TAG, "onPositiveButtonClick: This is date2"+date2);
                        Log.i(TAG, "onPositiveButtonClick: selected date: " + selectedDate);
                    }
                });*/
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
//                Get the selected DATE RANGE
                        Pair selectedDates = (Pair) materialDatePicker.getSelection();
//              then obtain the startDate & endDate from the range
                        final Pair<Date, Date> rangeDate = new Pair<>(new Date((Long) selectedDates.first), new Date((Long) selectedDates.second));
//              assigned variables
                       startDate = rangeDate.first.toString();
                       endDate = rangeDate.second.toString();
//              Format the dates in ur desired display mode
                         simpleFormat = new SimpleDateFormat("dd MMM yyyy");
//
                    }
                });
//                int days = Days.daysBetween(date1, date2).getDays();
                done = findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedPrefsHelper.saveValue(Constant.SELECTED_PLACE, selectedPlace);
                        sharedPrefsHelper.saveValue(Constant.SELECTED_DATE, selectedDate);
                        startActivity(new Intent(dateActivity.this, CarListActivity.class));
                        finish();
                        Date date=null;
                        Date date2 = null;
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy");
                        String temp = startDate;
                        String temp1 = endDate;
                        try {
                            date = formatter.parse(temp);
                            date2 = formatter.parse(temp1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String formateDate = new SimpleDateFormat("MM-dd-yyyy").format(date);
                        String endFormatedDate = new SimpleDateFormat("MM-dd-yyyy").format(date2);
                        Log.i("", "onCreate: This is formated date"+formateDate);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date date1 = null;
                        Date date22 = null;
                        try {
                             date1 = sdf.parse(formateDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        try {
                            date22 = sdf.parse(endFormatedDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Log.i("", "onClick: This is date1"+date1.getTime());

                        long diff = date1.getTime() - date22.getTime();
                        Log.i("", "onClick: This is difference"+diff);

                    }
                });


            }
        });

    }



}