package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class CreateOffer extends AppCompatActivity {

    TextInputLayout InputTitle,InputEmail,InputPhone,InputDescription;
    EditText offerTitle,offerEmail,offerPhone,offerDescription;
    Button Add;
    DBhelper DB;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_create_offer);

        InputTitle=findViewById(R.id.offer_title);
        InputEmail=findViewById(R.id.offer_email);
        InputPhone=findViewById(R.id.offer_phone);
        InputDescription=findViewById(R.id.offer_desc);
        Add=findViewById(R.id.button_add);
        //Extract EditText
        offerTitle=InputTitle.getEditText();
        offerEmail=InputEmail.getEditText();
        offerPhone=InputPhone.getEditText();
        offerDescription=InputDescription.getEditText();

        DB=new DBhelper(this);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title=offerTitle.getText().toString();
                String email=offerEmail.getText().toString();
                String phone=offerPhone.getText().toString();
                String description=offerDescription.getText().toString();

                Boolean res= DB.InsertOffer(title,email,phone,description);

                if (res==true){

                    Toast.makeText(CreateOffer.this, "New offer Added", Toast.LENGTH_SHORT).show();
                }else{


                    Toast.makeText(CreateOffer.this, "Error", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}