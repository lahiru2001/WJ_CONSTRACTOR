package com.example.wj_constractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class View_supervisorMainActivity extends AppCompatActivity {

    private TextView SidTV;
    private TextView SFNameTV;
    private TextView SLNameTV;
    private TextView SAddressTV;
    private TextView SPhoneTV;
    private TextView SUsernameTV;
    private TextView SEmailTV;

    public Button view;

    DBConnector db;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supervisor_main);

        SidTV = findViewById(R.id.AdAdminIdETV);
        SFNameTV = findViewById(R.id.AdAdminFnameETV);
        SLNameTV = findViewById(R.id.AdAdmiinLnameETV);
        SAddressTV = findViewById(R.id.AdAdminAddessETV);
        SPhoneTV = findViewById(R.id.AdAdminPhoneETV);
        SUsernameTV = findViewById(R.id.AdAdminUsernameETV);
        SEmailTV = findViewById(R.id.AdAdminEmailETV);

        dataHandler.openDB();

        view = findViewById(R.id.FindSuperBTN);
        db = new DBConnector(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getsupervisordata();
                if(res.getCount()==0) {
                    Toast.makeText(View_supervisorMainActivity.this, "INVALID ENTRY EXISTS", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("super_id :"+res.getString(0)+"\n");
                    buffer.append("first_name : "+res.getString(1)+"\n");
                    buffer.append("last_name : "+res.getString(2)+"\n");
                    buffer.append("address : "+res.getString(3)+"\n");
                    buffer.append("phone : "+res.getString(4)+"\n");
                    buffer.append("username : "+res.getString(5)+"\n");
                    buffer.append("email : "+res.getString(6)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(View_supervisorMainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("ALL workers Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}