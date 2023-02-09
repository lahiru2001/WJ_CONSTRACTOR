package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Reg_AdminMainActivity extends AppCompatActivity {

    private TextView adminIdTV;
    private TextView firstNameTv;
    private TextView lastnameTv;
    private TextView addressTV;
    private TextView phoneTV;
    private TextView usernameTV;
    private TextView passwordTV;
    private TextView emailTV;

    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_admin_main);

        adminIdTV = findViewById(R.id.AdAdminIdETV);
        firstNameTv = findViewById(R.id.AdAdminFnameETV);
        lastnameTv = findViewById(R.id.AdAdmiinLnameETV);
        addressTV = findViewById(R.id.AdAdminAddessETV);
        phoneTV = findViewById(R.id.AdAdminPhoneETV);
        usernameTV = findViewById(R.id.AdAdminUsernameETV);
        passwordTV = findViewById(R.id.AdAdminPasswordETV);
        emailTV = findViewById(R.id.AdAdminEmailETV);

        dataHandler.openDB();
    }

    public void onClickAddAdmin(View view){
        String adminId = adminIdTV.getText().toString();
        String firstname = firstNameTv.getText().toString();
        String lastname = lastnameTv.getText().toString();
        String address = addressTV.getText().toString();
        String phone = phoneTV.getText().toString();
        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();
        String email = emailTV.getText().toString();

        if (adminId.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin name Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (firstname.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin age Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (lastname.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin number Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (address.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin number Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (phone.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin nic Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (username.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin username Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (password.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin password Field cannot be empty", Toast.LENGTH_LONG).show();
        }else if (email.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin email Field cannot be empty", Toast.LENGTH_LONG).show();
        }else{
            Admin admin = new Admin(adminId,firstname,lastname,address,phone,username,password,email);
            try {
                if (dataHandler.checkForAdminRegister(new Admin())) {
                    Toast.makeText(getApplicationContext(), "ADMIN ALREADY INSERT", Toast.LENGTH_SHORT).show();
                } else {
                    dataHandler.RegisterAdmin(admin);
                    Toast.makeText(getApplicationContext(), "ADMIN Registered Successfully", Toast.LENGTH_SHORT).show();

                    adminIdTV.setText("");
                    firstNameTv.setText("");
                    lastnameTv.setText("");
                    addressTV.setText("");
                    phoneTV.setText("");
                    usernameTV.setText("");
                    passwordTV.setText("");
                    emailTV.setText("");

                    adminIdTV.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}