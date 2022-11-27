package com.example.jobup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {


    TextInputLayout InputEmail,InputPassword;
    EditText Email,Password;
    Button Login,Signup;
    DBhelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InputEmail =findViewById(R.id.signup_email);
        InputPassword=findViewById(R.id.entredpassword);
        Email=InputEmail.getEditText();
        Password=InputPassword.getEditText();

        Login=findViewById(R.id.login);
        Signup=findViewById(R.id.signup);
        DB=new DBhelper(this);
        DB.InsertAdmin("admin@gmail.com","admin");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password=Password.getText().toString();
                if(email.equals("") || password.equals("")){

                    Toast.makeText(Login.this, "Please enter "+email+" all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean UserExist =DB.CheckUserExistence(email);
                    if (UserExist ==true){

                        Boolean ConfirmPassword =DB.CheckPassword(email,password);
                        if (ConfirmPassword ==true){
                            if(email.equals("admin@gmail.com") && password.equals("admin")){
                                Intent intent=new Intent(getApplicationContext(), ManageOffers.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(Login.this, "User Logged succesfully", Toast.LENGTH_SHORT).show();

                                Intent myIntent = new Intent(Login.this, NavActivity.class);
                                String data = DB.getUserInfo(email);
                                //String userEmail = DB.getUserInfo(email,2);
                                myIntent.putExtra("name", data);
                                //myIntent.putExtra("userEmail",userEmail);
                                startActivity(myIntent);
                            }

                        }else {
                            Toast.makeText(Login.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Login.this, "User "+ email+" doesn't exist", Toast.LENGTH_SHORT).show();
                    }


                }



            }
        });


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });

    }
}