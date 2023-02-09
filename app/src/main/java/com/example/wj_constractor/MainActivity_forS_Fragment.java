package com.example.wj_constractor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity_forS_Fragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {

            case R.id.admin_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SupervisorHomeFragment()).commit();
                break;
            case R.id.AUD_SUPERVISOR:
                Intent intent1 = new Intent(this,Register_Update_delete_Supervisor.class);
                startActivity(intent1);
                break;

            case R.id.cal_salary:
                Intent intent2 = new Intent(this, Reg_Update_delete_Masonary_workersMainActivity.class);
                startActivity(intent2);
                break;
            case R.id.log_out:
                Intent intent3 = new Intent(this, LoginActivity.class);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_fragmen2);



        drawerLayout=findViewById(R.id.nav_View2);
        //NAVIGATION LINE CREATE
        NavigationView navigationView=findViewById(R.id.navigation_view2);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SupervisorHomeFragment()).commit();


    }

}


