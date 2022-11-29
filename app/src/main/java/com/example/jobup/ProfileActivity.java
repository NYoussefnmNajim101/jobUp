package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobup.domain.UserDomain;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
     private Intent intent ;
     private TextView fullname;
     private TextView email ;
     private TextView fullNameInput;

     UserDomain userObject;

    DBhelper dbHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




        intent = getIntent();
        userObject = (UserDomain) intent.getSerializableExtra("userObject");

        fullname = findViewById(R.id.profileName);
        fullname.setText(userObject.getUserFullName());

        email = findViewById(R.id.userEmail);
        email.setText(userObject.getUserEmail());


        fullNameInput = findViewById(R.id.UserName);
        fullNameInput.setText(userObject.getUserFullName());


    }
    public void ProfileButtonClicked(View view) {

      System.out.println("already in profile");

    }

    public void LogOutClicked(View view) {
        Intent myIntent = new Intent(ProfileActivity.this,Login.class);
        startActivity(myIntent);
    }

    public void SupportButtonClicked(View view) {
        Toast.makeText(ProfileActivity.this, "Support Clicked", Toast.LENGTH_SHORT).show();
    }

    public void HomeButtonClicked(View view) {

        Intent myIntent = new Intent(ProfileActivity.this,HomeActivity.class);

        startActivity(myIntent);

    }
}