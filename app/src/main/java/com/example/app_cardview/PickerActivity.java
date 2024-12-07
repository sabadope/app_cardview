package com.example.app_cardview;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class PickerActivity extends AppCompatActivity {
    private static Button date, time;
    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        // Find the back arrow ImageView
        ImageView backArrow = findViewById(R.id.back_arrow);

        // Set a click listener for the back arrow
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                onBackPressed(); // Or any custom back navigation
            }
        });

        date = findViewById(R.id.selectdate);
        time = findViewById(R.id.selecttime);
        set_date = findViewById(R.id.set_date);
        set_time = findViewById(R.id.set_time);

        date.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDialog(Date_id);  // Show Date dialog
            }
        });

        time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDialog(Time_id);  // Show Time dialog
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar c = Calendar.getInstance();  // Get the calendar instance

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:
                return new DatePickerDialog(PickerActivity.this, date_listener, year, month, day);
            case Time_id:
                return new TimePickerDialog(PickerActivity.this, time_listener, hour, minute, false);
        }
        return null;
    }

    // Date picker listener
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            month = month + 1;  // Adjust month because Calendar month is 0-indexed
            String date1 = String.format("%02d/%02d/%d", month, day, year);  // Format as MM/DD/YYYY
            set_date.setText(date1);
        }
    };

    // Time picker listener
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            String time1 = String.format("%02d:%02d", hour, minute);  // Format time as HH:MM
            set_time.setText(time1);
        }
    };
}
