package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Reg_Update_delete_Masonary_workersMainActivity extends AppCompatActivity {

    private TextView idTv;
    private TextView firstnameTv;
    private TextView lastnameTV;
    private TextView nicTV;
    private TextView ageTV;
    private TextView phoneTV;
    private TextView addressTV;
    private TextView emailTV;

    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_masonary_workers_main);

        idTv = findViewById(R.id.AddWorkerIdETV);
        firstnameTv = findViewById(R.id.AddWorkerFnameETV);
        lastnameTV = findViewById(R.id.AddWorkerLnameETV);
        nicTV = findViewById(R.id.AddworkerNicETV);
        ageTV = findViewById(R.id.AddWorkerAgeETV);
        phoneTV = findViewById(R.id.AddworkerPhoneETV);
        addressTV = findViewById(R.id.AddworkeraddressETV);
        emailTV = findViewById(R.id.AddWorkerEmailETV);

        dataHandler.openDB();
    }
    public void OnClickRegisterWorkers(View view) {

        String id = idTv.getText().toString();
        String fName = firstnameTv.getText().toString();
        String lName = lastnameTV.getText().toString();
        String nic = nicTV.getText().toString();
        String age = ageTV.getText().toString();
        String phone = phoneTV.getText().toString();
        String address = addressTV.getText().toString();
        String email = emailTV.getText().toString();

        if (id.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker ID can not be empty ", Toast.LENGTH_LONG).show();

        } else if (fName.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker First Name can not be empty ", Toast.LENGTH_LONG).show();

        } else if (lName.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Last Name can not be empty ", Toast.LENGTH_LONG).show();

        } else if (nic.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Nic can not be empty ", Toast.LENGTH_LONG).show();

        } else if (age.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Age can not be empty ", Toast.LENGTH_LONG).show();

        } else if (phone.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Phone No can not be empty ", Toast.LENGTH_LONG).show();

        } else if (address.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Address can not be empty ", Toast.LENGTH_LONG).show();

        } else if (email.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Masonry Worker Email can not be empty ", Toast.LENGTH_LONG).show();

        } else {
            Masonary_workers masonary_workers = new Masonary_workers(id, fName, lName, nic, age, phone, address, email);
            try {
                if (dataHandler.checkForWorker(new Masonary_workers())) {
                    Toast.makeText(getApplicationContext(), "WORKER ID ALREADY INSERTED", Toast.LENGTH_SHORT).show();
                } else {
                    dataHandler.RegisterMasonaryWorkers(masonary_workers);
                    Toast.makeText(getApplicationContext(), "Masonary worker Registered Successfully", Toast.LENGTH_SHORT).show();

                 /*   idTv.setText("");
                    firstnameTv.setText("");
                    lastnameTV.setText("");
                    nicTV.setText("");
                    ageTV.setText("");
                    phoneTV.setText("");
                    addressTV.setText("");
                    emailTV.setText("");

                    idTv.requestFocus();*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void onClickUpdateWorker(View view){

        String id = idTv.getText().toString();
        String fName = firstnameTv.getText().toString();
        String lName = lastnameTV.getText().toString();
        String nic = nicTV.getText().toString();
        String age = ageTV.getText().toString();
        String phone = phoneTV.getText().toString();
        String address = addressTV.getText().toString();
        String email = emailTV.getText().toString();

        Masonary_workers masonary_workers = new Masonary_workers(id, fName, lName, nic, age, phone, address, email);

        dataHandler.updateWorker(new Masonary_workers(id, fName, lName, nic, age, phone, address, email));

        Toast.makeText(getApplicationContext(), "Supervisor update Successfully", Toast.LENGTH_LONG).show();

    }
    public void onClickDeleteWorker(View view){
        Integer deleteWorker = dataHandler.DeleteWorker(idTv.getText().toString());
        if (deleteWorker > 0){
            Toast.makeText(getApplicationContext(), "WORKER DELETED SUCCESSFULLY", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "WORKER DELETE NOT SUCCESSFULLY", Toast.LENGTH_LONG).show();
        }
    }
}


