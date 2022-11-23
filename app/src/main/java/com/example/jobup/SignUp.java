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

public class SignUp extends AppCompatActivity {

    TextInputLayout InputFirstName,InputLastName,InputEmail,InputPassword,InputRe_Password;
    EditText FirstName,LastName,Email,Password,Re_Password;
    Button Register;
    DBhelper DB;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        InputFirstName=findViewById(R.id.firstname);
        InputLastName=findViewById(R.id.lastname);
        InputEmail=findViewById(R.id.signup_email);
        InputPassword=findViewById(R.id.signup_password);
        InputRe_Password=findViewById(R.id.re_password);
        Register=findViewById(R.id.register);
        //Extract EditText
        FirstName=InputFirstName.getEditText();
        LastName=InputLastName.getEditText();
        Email=InputEmail.getEditText();
        Password=InputPassword.getEditText();
        Re_Password=InputRe_Password.getEditText();



        DB=new DBhelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Firstname=FirstName.getText().toString();
                String Lastname=LastName.getText().toString();
                String fullname=Firstname+" "+Lastname;
                String email=Email.getText().toString();
                String password=Password.getText().toString();
                String re_password=Re_Password.getText().toString();

                if(Firstname.equals("") || Lastname.equals("")|| email.equals("") || password.equals("") || re_password.equals("")){

                    Toast.makeText(SignUp.this, "Please enter  all the fields", Toast.LENGTH_SHORT).show();
                } else{
                    Boolean ConfirmPassword=password.equals(re_password);
                    if(ConfirmPassword){
                        Boolean checkSignUp=DB.InsertUser(fullname,email,password);
                        if(checkSignUp){

                            Toast.makeText(SignUp.this,"New User Added",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(SignUp.this,"Something Goes Wrong",Toast.LENGTH_LONG).show();

                        }

                    }else {


                        Toast.makeText(SignUp.this,"Passwords doesn't match",Toast.LENGTH_LONG).show();
                        
                    }




                }








            }
        });

    }
}