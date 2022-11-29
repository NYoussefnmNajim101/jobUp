package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobup.domain.JobOfferDomain;

public class OfferDetailsActivity extends AppCompatActivity {


    TextView titleOffer, phoneOffer,emailOffer,descriptionoffer;
    private JobOfferDomain offerObject;
    DBhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);
        DBhelper db = new DBhelper(this);

        initView();
        getObjectOffer();
    }

    private void getObjectOffer() {
        offerObject = (JobOfferDomain) getIntent().getSerializableExtra("offer");

        titleOffer.setText(offerObject.getOfferTitle());
        phoneOffer.setText(offerObject.getOfferPhone());
        emailOffer.setText(offerObject.getOfferEmail());
        descriptionoffer.setText(offerObject.getOfferDescription());
    }

    private void initView() {
        titleOffer = findViewById(R.id.TitleOfferViewDetails);
        phoneOffer = findViewById(R.id.PhoneOfferViewDetails);
        emailOffer = findViewById(R.id.emailOfferViewDetails);
        descriptionoffer = findViewById(R.id.DescriptionOfferViewDetails);
    }



    public void LogOutClicked(View view) {
        Intent myIntent = new Intent(OfferDetailsActivity.this,Login.class);
        startActivity(myIntent);
    }

    public void SupportButtonClicked(View view) {
        Toast.makeText(OfferDetailsActivity.this, "Support Clicked", Toast.LENGTH_SHORT).show();
    }

    public void HomeButtonClicked(View view) {

        Intent myIntent = new Intent(OfferDetailsActivity.this,HomeActivity.class);

        startActivity(myIntent);

    }
}