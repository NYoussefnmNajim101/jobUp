package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
    private Intent intent;
    private TextView firstname;
    private TextView lastname;
    private TextView fullName;
    private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intent = getIntent();

        String fullname = intent.getStringExtra("fullname");
        firstname = findViewById(R.id.firstNameInput);
        firstname.setText(fullname.split(" ")[0]);
        lastname = findViewById(R.id.lastNameInput);
        lastname.setText(fullname.split(" ")[1]);
        DBhelper db = new DBhelper(this);
        email = findViewById(R.id.email);
        try {
            Cursor cur = db.getInfo(intent.getStringExtra("fullname"));
            cur.moveToFirst();
            email.setText(cur.getString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }


        fullName = findViewById(R.id.fullName);
        fullName.setText(intent.getStringExtra("fullname"));


    }


    public void HomeButton(View view) {
        //Toast.makeText(ProfileActivity.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(ProfileActivity.this,HomeActivity.class);
        myIntent.putExtra("name",intent.getStringExtra("fullname"));
        startActivity(myIntent);

    }

    public void logOut(View v){
        Intent myIntent = new Intent(ProfileActivity.this,Login.class);
        startActivity(myIntent);
    }

}