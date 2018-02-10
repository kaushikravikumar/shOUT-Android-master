package com.android.shout;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class ReportIncident extends AppCompatActivity{

    EditText postTitle;

    EditText postText;

    String txtDate = "";

    String txtTime = "";

    String txtLoc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_incident);
        postTitle = (EditText) findViewById(R.id.postTitle);
        postText = (EditText) findViewById(R.id.postText);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);
    }

    public void post(View v) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("messages");
        if(postTitle.getText().toString().isEmpty() || postText.getText().toString().isEmpty())
        {
            Toast.makeText(ReportIncident.this, "Make sure to fill in post title and message", Toast.LENGTH_LONG).show();
        }
        else {
            Message m = new Message(postText.getText().toString(), txtDate, txtTime, postTitle.getText().toString());
            String ID = database.push().getKey();
            m.setID(ID);
            database.child(ID).setValue(m);
            startActivity(new Intent(ReportIncident.this, MainActivity.class));
        }
    }

    public void cancel(View v) {
        startActivity(new Intent(ReportIncident.this, MainActivity.class));
    }

    public void setLocation(View v)
    {

    }

    public void setDate(View v)
    {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setTime(View v)
    {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        if(hourOfDay > 12)
                        {
                            txtTime = (hourOfDay - 12) + ":" + minute + "pm";
                        }
                        else
                        {

                        }
                        txtTime = hourOfDay + ":" + minute;
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}
