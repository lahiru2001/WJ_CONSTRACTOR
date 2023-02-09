package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Update_delete_Supervisor extends AppCompatActivity {
    private TextView superIdTV;
    private TextView firstnameTV;
    private TextView lastnameTV;
    private TextView addressTV;
    private TextView phoneTv;
    private TextView usernameTV;
    private TextView passwordTv;
    private TextView emailTV;


    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_update_delete_supervisor_fragment);

        superIdTV = findViewById(R.id.AdAdminIdETV);
        firstnameTV = findViewById(R.id.CreateSuperFNameETV);
        lastnameTV = findViewById(R.id.CreateSuperLnameETV);
        addressTV = findViewById(R.id.CreateSuperAddressETV);
        phoneTv = findViewById(R.id.CreateSuperPhoneETV);
        usernameTV = findViewById(R.id.CreateSuperUsernameETV);
        passwordTv = findViewById(R.id.CreateSuperPasswordETV);
        emailTV = findViewById(R.id.CreateSuperEmailETV);

        dataHandler.openDB();
    }
    public void OnClickSupervisor(View view){
        String superId = superIdTV.getText().toString();
        String firstname = firstnameTV.getText().toString();
        String lastname = lastnameTV.getText().toString();
        String address = addressTV.getText().toString();
        String phone = phoneTv.getText().toString();
        String username = usernameTV.getText().toString();
        String password = passwordTv.getText().toString();
        String email = emailTV.getText().toString();

        if (superId.trim().isEmpty()) {
            Toast.makeText(this, "SUPERVISOR ID CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (firstname.trim().isEmpty()) {
                Toast.makeText(this, "FIRST NAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (lastname.trim().isEmpty()) {
            Toast.makeText(this, "LAST NAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (address.trim().isEmpty()) {
            Toast.makeText(this, "ADDRESS CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (phone.trim().isEmpty()) {
            Toast.makeText(this, "PLEASE ENTER MOBILE PHONE NUMBER", Toast.LENGTH_SHORT).show();
        } else if (username.trim().isEmpty()) {
            Toast.makeText(this, "PLEASE ENTER  USERNAME", Toast.LENGTH_SHORT).show();
        } else if (password.trim().isEmpty()) {
            Toast.makeText(this, "PLEASE ENTER PASSWORD", Toast.LENGTH_SHORT).show();
        } else if (email.trim().isEmpty()) {
            Toast.makeText(this, "PLEASE ENTER SITE EMAIL", Toast.LENGTH_SHORT).show();
        } else {
            Supervisor supervisor = new Supervisor(superId,firstname,lastname,address,phone,username,password,email);
            try {
                if (dataHandler.checkForSupervisor(new Supervisor())) {
                    Toast.makeText(getApplicationContext(), "USERNAME ALREADY INSERT", Toast.LENGTH_SHORT).show();
                } else {
                    dataHandler.RegisterSuper(supervisor);
                    Toast.makeText(getApplicationContext(), "Supervisor Registered Successfully", Toast.LENGTH_SHORT).show();

                    superIdTV.setText("");
                    firstnameTV.setText("");
                    lastnameTV.setText("");
                    addressTV.setText("");
                    phoneTv.setText("");
                    usernameTV.setText("");
                    passwordTv.setText("");
                    emailTV.setText("");

                    superIdTV.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void onClickUpdate(View view){

        String superId = superIdTV.getText().toString();
        String firstname = firstnameTV.getText().toString();
        String lastname = lastnameTV.getText().toString();
        String address = addressTV.getText().toString();
        String phone = phoneTv.getText().toString();
        String username = usernameTV.getText().toString();
        String password = passwordTv.getText().toString();
        String email = emailTV.getText().toString();

        Supervisor supervisor = new Supervisor(superId,firstname,lastname,address,phone,username,password,email);

        dataHandler.updateSupervisor(new Supervisor(superId,firstname,lastname,address,phone,username,password,email));

        Toast.makeText(getApplicationContext(), "Supervisor Update Successfully", Toast.LENGTH_LONG).show();

    }

    public void onClickDelete(View view){
        Integer deleteSuper = dataHandler.DeleteSupervisor(superIdTV.getText().toString());
        if (deleteSuper > 0){
            Toast.makeText(getApplicationContext(), "Supervisor Delete Successfully", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Supervisor Delete Not Successfully", Toast.LENGTH_LONG).show();
        }
    }
}






