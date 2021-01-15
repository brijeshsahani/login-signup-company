package com.example.projectcompany.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectcompany.R;

public class ProfileActivity extends AppCompatActivity {

    TextView txtFirstname,txtLastname,txtEmail,txtBirthdate,txtGender,txtMobileno,txtAddress;
    Button backbtn;
    String Firstname = "";
    String Lastname = "";
    String Email = "";
    String Birthdate = "";
    String Gender= "";
    String Mobileno = "";
    String Address = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backbtn = findViewById(R.id.backid);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });

        txtFirstname = findViewById(R.id.txtFirstname);
        txtLastname = findViewById(R.id.txtLastname);
        txtEmail = findViewById(R.id.txtEmail);
        txtBirthdate = findViewById(R.id.txtBirthdate);
        txtGender = findViewById(R.id.txtGender);
        txtMobileno = findViewById(R.id.txtMobileno);
        txtAddress = findViewById(R.id.txtAddress);

        Firstname = getIntent().getStringExtra("Firstname");
        Lastname = getIntent().getStringExtra("Lastname");
        Email = getIntent().getStringExtra("Email");
        Birthdate = getIntent().getStringExtra("Birthdate");
        Gender = getIntent().getStringExtra("Gender");
        Mobileno = getIntent().getStringExtra("Mobileno");
        Address = getIntent().getStringExtra("Address");

        txtFirstname.setText(Firstname);
        txtLastname.setText(Lastname);
        txtEmail.setText(Email);
        txtBirthdate.setText(Birthdate);
        txtGender.setText(Gender);
        txtMobileno.setText(Mobileno);
        txtAddress.setText(Address);
    }
}