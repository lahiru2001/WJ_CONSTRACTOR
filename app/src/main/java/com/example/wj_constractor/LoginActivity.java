package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity<checkAdminLogin> extends AppCompatActivity {

    private EditText usernameTv;
    private EditText passwordTV;


    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTv = findViewById(R.id.LoginUserNameETV);
        passwordTV = findViewById(R.id.LoginPasswordETV);

        dataHandler.openDB();
    }
    public void onLoginClick(View view) {
        String username = usernameTv.getText().toString();
        String password = passwordTV.getText().toString();

        Boolean checkSupervisorLogin = dataHandler.checkSupervisorLogin(username, password);
        if (checkSupervisorLogin == true) {
            Toast.makeText(getApplicationContext(), "Login Successfully As a Supervisor", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity_forS_Fragment.class);
            startActivity(intent);

        } else {
            Boolean checkAdminLogin = dataHandler.checkAdminLogin(username, password);
            if (checkAdminLogin == true) {
                Toast.makeText(getApplicationContext(), "Login Successfully As a Admin", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity_for_Fragment.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Logging Failed Try Again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}