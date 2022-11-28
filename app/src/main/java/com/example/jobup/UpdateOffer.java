package com.example.jobup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateOffer extends AppCompatActivity {

    TextInputLayout InputTitle,InputEmail,InputPhone,InputDescription;
    EditText offerTitle,offerEmail,offerPhone,offerDescription;
    String Id,Title,Email,Phone,Description;
    Button Update,Delete;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_update_offer);

        InputTitle=findViewById(R.id.offer_title_update);
        InputEmail=findViewById(R.id.offer_email_update);
        InputPhone=findViewById(R.id.offer_phone_update);
        InputDescription=findViewById(R.id.offer_desc_update);
        Update =findViewById(R.id.button_update);
        Delete =findViewById(R.id.button_delete);
        DB=new DBhelper(this);
        //Extract EditText
        offerTitle=InputTitle.getEditText();
        offerEmail=InputEmail.getEditText();
        offerPhone=InputPhone.getEditText();
        offerDescription=InputDescription.getEditText();
        //Getting data from intent and store it in local variables
        getDataFromIntent();
        //configuring update function and linked it to update button
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Title=offerTitle.getText().toString();
                Email=offerEmail.getText().toString();
                Phone=offerPhone.getText().toString();
                Description=offerDescription.getText().toString();
              Boolean res=DB.updateOffer(Id,Title,Email,Phone,Description);

              if(res==true){
                  Toast.makeText(UpdateOffer.this, "Offer Updated", Toast.LENGTH_SHORT).show();
              }else{

                  Toast.makeText(UpdateOffer.this, "Failed to "+Id+" Update offer", Toast.LENGTH_SHORT).show();
              }

            }
        });

       Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDelete();


            }
        });



    }



    void getDataFromIntent(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("email") && getIntent().hasExtra("phone") && getIntent().hasExtra("description")){
            //Getting Data from Intent
            Id = getIntent().getStringExtra("id");
            Title = getIntent().getStringExtra("title");
            Email = getIntent().getStringExtra("email");
            Phone = getIntent().getStringExtra("phone");
            Description = getIntent().getStringExtra("description");

            //Setting Intent Data
            offerTitle.setText(Title);
            offerEmail.setText(Email);
            offerPhone.setText(Phone);
            offerDescription.setText(Description);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

   void confirmDelete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + Title + " ?");
        builder.setMessage("Are you sure you want to delete " + Title + " offer ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DB.deleteOffer(Id);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        builder.create().show();

    }


}