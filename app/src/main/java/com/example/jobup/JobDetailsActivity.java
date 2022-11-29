package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JobDetailsActivity extends AppCompatActivity {
    private TextView title ;
    private TextView email ;
    private TextView phone ;
    private TextView desc ;
    Intent intent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        title = findViewById(R.id.titleDetail);
        email = findViewById(R.id.emailD);
        phone = findViewById(R.id.phoneD);
        desc = findViewById(R.id.descD);
        intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        email.setText(intent.getStringExtra("email"));
        phone.setText(intent.getStringExtra("phone"));
        desc.setText(intent.getStringExtra("description"));


    }
}