package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Add_New_SiteMain_Activity extends AppCompatActivity {

    int year, month, day;

    private TextView siteIdTV;
    private TextView siteNameTV;
    private TextView siteSuperTV;
    private TextView locationTV;
    private TextView sDateTV;

    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_site_main);

        siteIdTV = findViewById(R.id.AddSiteIdETV);
        siteNameTV = findViewById(R.id.AddSiteNameETV);
        siteSuperTV = findViewById(R.id.SiteSuperNameETV);
        locationTV = findViewById(R.id.AddSiteLocationETV);
        sDateTV = findViewById(R.id.SiteStartDateETV);

        dataHandler.openDB();
    }

    public void onStartDate(View view){

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                sDateTV.setText(i2 + "-" + (i1+1)+ "-" + i);
            }
        },year,month,day);
        datePickerDialog.show();
    }

    public void OnClickAddNewSite(View view){

        String id = siteIdTV.getText().toString();
        String siteName = siteNameTV.getText().toString();
        String SuperId = siteSuperTV.getText().toString();
        String location = locationTV.getText().toString();
        String startDate = sDateTV.getText().toString();

        if (id.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site ID cannot be empty ", Toast.LENGTH_LONG).show();

        }else if (siteName.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site Name cannot be empty ", Toast.LENGTH_LONG).show();

        }else if (SuperId.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site Supervisor ID cannot be empty ", Toast.LENGTH_LONG).show();

        }else if (location.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site location cannot be empty ", Toast.LENGTH_LONG).show();

        }else if (startDate.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site start date cannot be empty ", Toast.LENGTH_LONG).show();

        }
        else {

            AddNewSite addNewSite = new AddNewSite(id,siteName,SuperId,location,startDate);

            dataHandler.AddNewSite(new AddNewSite(id,siteName,SuperId,location,startDate));
            Toast.makeText(getApplicationContext(), "New Site Added Successfully", Toast.LENGTH_LONG).show();

            siteIdTV.setText("");
            siteNameTV.setText("");
            siteSuperTV.setText("");
            locationTV.setText("");
            sDateTV.setText("");

            siteIdTV.requestFocus();
        }
    }
}