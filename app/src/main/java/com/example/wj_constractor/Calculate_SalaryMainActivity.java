package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate_SalaryMainActivity extends AppCompatActivity {

    private TextView workerSIdTV;
    private TextView workerSnameTV;
    private TextView workersdaysTV;
    private TextView workerSalaryTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_salary_main);

        workerSIdTV = findViewById(R.id.WorkerSalartIDETV);
        workerSnameTV = findViewById(R.id.WorkersalaryNameETV);
        workersdaysTV = findViewById(R.id.WorkerSalaryDayETV);
        workerSalaryTV = findViewById(R.id.WorkerSalaryETV);
    }
    public void onClickCalSalary(View view){

        int amount;
        int payment =3000;

        String id = workerSIdTV.getText().toString();
        String name = workerSnameTV.getText().toString();
        Integer days = Integer.parseInt(workersdaysTV.getText().toString());

            amount = payment * days;
            workerSalaryTV.setText(String.valueOf(amount));
            Toast.makeText(getApplicationContext(), "Salary calculation Successfully ", Toast.LENGTH_LONG).show();
        }
    }
