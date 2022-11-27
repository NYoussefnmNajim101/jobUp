package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ManageOffers extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button;
    ArrayList<String> offerId,offerTitle,offerEmail,offerPhone,offerDescription;
    DBhelper DB;

    MyAdapter myAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_manage_offers);
        recyclerView = findViewById(R.id.recyclerview);
        button = findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateOffer.class);
                startActivity(intent);
            }
        });

        offerId = new ArrayList<>();
        offerTitle = new ArrayList<>();
        offerEmail = new ArrayList<>();
        offerPhone = new ArrayList<>();
        //offerDescription = new ArrayList<>();
        DB = new DBhelper(this);
        DisplayData();

        myAdapter = new MyAdapter(this,offerId,offerTitle, offerEmail,offerPhone);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void DisplayData(){
        Cursor cursor=DB.getdata();
        if(cursor.getCount()==0){

            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {

                offerId.add(cursor.getString(0));
                offerTitle.add(cursor.getString(1));
                offerEmail.add(cursor.getString(2));
                offerPhone.add(cursor.getString(3));
                //offerDescription.add(cursor.getString(3));
            }



        }




    }

}



