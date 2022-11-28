package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
     private Intent intent ;
     private TextView fullname;
     private TextView email ;
     private TextView fullNameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        intent = getIntent();
        fullname = findViewById(R.id.profileName);
        fullname.setText(intent.getStringExtra("fullname"));
        DBhelper db = new DBhelper(this);
        email = findViewById(R.id.email);
        try {
            Cursor cur = db.getInfo(intent.getStringExtra("fullname"));
            cur.moveToFirst();
            email.setText(cur.getString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }


        fullNameInput = findViewById(R.id.fullNameInput);
        fullNameInput.setText(intent.getStringExtra("fullname"));


    }
}