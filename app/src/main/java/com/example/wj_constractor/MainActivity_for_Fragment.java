package com.example.wj_constractor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity_for_Fragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Admin_Home_fragment()).commit();
                break;
            case R.id.a_admin:
                Intent intent1 = new Intent(this,Reg_AdminMainActivity.class);
                startActivity(intent1);
                break;

            case R.id.a_newSite:
                Intent intent2 = new Intent(this, Add_New_SiteMain_Activity.class);
                startActivity(intent2);
                break;
            case R.id.aud_supervisor:
                Intent intent3 = new Intent(this, Register_Update_delete_Supervisor.class);
                startActivity(intent3);
                break;
            case R.id.aud_worker:
                Intent intent4 = new Intent(this, Reg_Update_delete_Masonary_workersMainActivity.class);
                startActivity(intent4);
                break;
            case R.id.v_supervisor:
                Intent intent5 = new Intent(this, View_supervisorMainActivity.class);
                startActivity(intent5);
                break;
            case R.id.v_worker:
                Intent intent6 = new Intent(this, View_workerMainActivity.class);
                startActivity(intent6);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_fragment);

        drawerLayout=findViewById(R.id.nav_View);
        //NAVIGATION LINE CREATE
        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Admin_Home_fragment()).commit();


    }

}


