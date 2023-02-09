package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class View_workerMainActivity extends AppCompatActivity {

    private TextView idTv;
    private TextView firstnameTv;
    private TextView lastnameTV;
    private TextView nicTV;
    private TextView ageTV;
    private TextView phoneTV;
    private TextView addressTV;
    private TextView emailTV;

    public Button View;

    DBConnector db;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_worker_main);

        idTv = findViewById(R.id.AddWorkerIdETV);
        firstnameTv = findViewById(R.id.AddWorkerFnameETV);
        lastnameTV = findViewById(R.id.AddWorkerLnameETV);
        nicTV = findViewById(R.id.AddworkerNicETV);
        ageTV = findViewById(R.id.AddWorkerAgeETV);
        phoneTV = findViewById(R.id.AddworkerPhoneETV);
        addressTV = findViewById(R.id.AddworkeraddressETV);
        emailTV = findViewById(R.id.AddWorkerEmailETV);

        dataHandler.openDB();
        db = new DBConnector(this);

        View = findViewById(R.id.FindWorkerBTN);

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getworkerdata();
                if(res.getCount()==0) {
                    Toast.makeText(View_workerMainActivity.this, "INVALID ENTRY EXISTS", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("worker_ID :"+res.getString(0)+"\n");
                    buffer.append("first_name : "+res.getString(1)+"\n");
                    buffer.append("last_name : "+res.getString(2)+"\n");
                    buffer.append("address : "+res.getString(3)+"\n");
                    buffer.append("phone : "+res.getString(4)+"\n");
                    buffer.append("username : "+res.getString(5)+"\n");
                    buffer.append("email : "+res.getString(6)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(View_workerMainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("ALL workers Details");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}