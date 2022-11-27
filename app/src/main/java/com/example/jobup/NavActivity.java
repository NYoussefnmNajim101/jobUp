package com.example.jobup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;

public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {



    private DrawerLayout drawerLayout;
    @NonNull private TextView fullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);


        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
        toolbar.setOnClickListener(this);







        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
            setSupportActionBar(toolbar);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        fullName = findViewById(R.id.fullName);
        Intent myintent= getIntent();
        fullName.setText(myintent.getStringExtra("name"));

        switch(item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
            case R.id.historique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HistoryFragment()).commit();
                break;
            case R.id.logout:
                Toast.makeText(this, "do you really want to go out ?", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(NavActivity.this,Login.class);
                startActivity(myIntent);
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View v) {

    }
}