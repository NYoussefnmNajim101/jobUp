package com.example.jobup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobup.domain.JobOfferDomain;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    DBhelper dbHelper;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewJobOffersList;
    Intent intent;
    TextView userFullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.jobup.R.layout.activity_home);
        intent = getIntent();
        userFullName = findViewById(R.id.userFullName);
        userFullName.setText(intent.getStringExtra("name"));
        dbHelper = new DBhelper(this);
        recyclerViewJobOffers();

            }

    private void recyclerViewJobOffers() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewJobOffersList = findViewById(R.id.jobOffersRecyclerView);
        recyclerViewJobOffersList.setLayoutManager(linearLayoutManager);

        ArrayList<JobOfferDomain> offers = dbHelper.getAllJobOffers();
        adapter = new JobOfferAdapter(offers);
        recyclerViewJobOffersList.setAdapter(adapter);
    }




    public void LogOutClicked(View view) {
        Intent myIntent = new Intent(HomeActivity.this,Login.class);
        startActivity(myIntent);
    }

    public void SupportButtonClicked(View view) {
        Toast.makeText(HomeActivity.this, "Support Clicked", Toast.LENGTH_SHORT).show();
    }

    public void ProfileButtonClicked(View view) {
        Toast.makeText(HomeActivity.this, "Profile Button Clicked", Toast.LENGTH_SHORT).show();

    }

    public void HomeButtonClicked(View view) {
        Toast.makeText(HomeActivity.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();

    }
}
