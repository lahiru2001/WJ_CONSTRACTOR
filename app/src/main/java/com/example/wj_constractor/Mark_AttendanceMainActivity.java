package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Mark_AttendanceMainActivity extends AppCompatActivity {
    int year, month, day;

    private TextView markIdTV;
    private TextView markNameTV;
    private TextView markerDateTV;

    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance_main);

        markIdTV = findViewById(R.id.markIdETV);
        markNameTV = findViewById(R.id.markNameETV);
        markerDateTV = findViewById(R.id.markDateETV);

        dataHandler.openDB();
    }

    public void onsetDate(View view) {
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                markerDateTV.setText(i2 + "-" + (i1 + 1) + "-" + i);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void onClickMarkAttendance(View view) {
        String markId = markIdTV.getText().toString();
        String markName = markNameTV.getText().toString();
        String markDate = markerDateTV.getText().toString();

        Attendance attendance= new Attendance(markId, markName, markDate);

        dataHandler.Attendance(new Attendance(markId, markName, markDate));

        Toast.makeText(getApplicationContext(), " Worker attendance added Successfully", Toast.LENGTH_LONG).show();
    }
}