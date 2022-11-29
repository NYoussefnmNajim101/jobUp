package com.example.jobup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobup.domain.JobOfferDomain;

import java.io.IOException;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    DBhelper dbHelper;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewJobOffersList;
    Intent intent;
    TextView offerEmail;
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
        dbHelper = new DBhelper(this);
        Intent myIntent = new Intent(HomeActivity.this,ProfileActivity.class);
        String fullName = intent.getStringExtra("name");
        myIntent.putExtra("fullname",fullName);
        startActivity(myIntent);
    }

    public void HomeButtonClicked(View view) {
        Toast.makeText(HomeActivity.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();

    }
    @SuppressLint("Range")
    public void details(View v) throws IOException {
        offerEmail = findViewById(R.id.JobItemEmail);
        DBhelper db = new DBhelper(this);
        Cursor cur = db.getOfferInfo(offerEmail.getText().toString());
        Intent myIntent = new Intent(HomeActivity.this,JobDetailsActivity.class);

        if(cur.getCount()>0){
            cur.moveToFirst();
             String title = cur.getString(cur.getColumnIndex("title"));
             String email = cur.getString(cur.getColumnIndex("email"));
             String phone = cur.getString(cur.getColumnIndex("phone"));
             String desc = cur.getString(cur.getColumnIndex("description"));
             myIntent.putExtra("title",title);
             myIntent.putExtra("email",email);
             myIntent.putExtra("phone",phone);
             myIntent.putExtra("description",desc);
             startActivity(myIntent);
        }


    }
}
