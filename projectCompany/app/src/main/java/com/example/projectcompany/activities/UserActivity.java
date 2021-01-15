package com.example.projectcompany.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectcompany.R;
import com.example.projectcompany.frag11;
import com.example.projectcompany.models.User;
import com.example.projectcompany.storage.SharedPreManager;

public class UserActivity extends AppCompatActivity {

    Button button,logoutbtn,useraction;
    ProgressDialog progressDialog;
    private TextView fntext,lntext,emailtext,addresstext,gendertext,dobtext,mobiletext,passwordtext;
    LinearLayout change,change1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        logoutbtn=findViewById(R.id.logoutid);

        fntext=findViewById(R.id.fnametxt);
        lntext=findViewById(R.id.lnametxt);
        emailtext=findViewById(R.id.emailtxt);
        addresstext=findViewById(R.id.addresstxt);
        gendertext=findViewById(R.id.gendertxt);
        dobtext=findViewById(R.id.dobtxt);
        mobiletext=findViewById(R.id.mobileid);
        passwordtext=findViewById(R.id.pass1);



        button=findViewById(R.id.Alluser);
        useraction = findViewById(R.id.useraction);

        change= findViewById(R.id.change);
        change1= findViewById(R.id.change1);



        User user= SharedPreManager.getInstance(this).getUser();
        fntext.setText(user.getFirstname());
        lntext.setText(user.getLastname());
        emailtext.setText(user.getEmailid());
        addresstext.setText(user.getAddress());
        gendertext.setText(user.getGender());
        dobtext.setText(user.getBirthdate());
       mobiletext.setText(String.valueOf(user.getMobileno()));
        String pass=getIntent().getStringExtra("keypassword");
       passwordtext.setText(pass);

//        int mob = user.getMobileno();
//        mobiletext.setText(String.valueOf(mob));

        useraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,Useraction.class);
                intent.putExtra("keypasswords",pass);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change.setVisibility(View.VISIBLE);
                change1.setVisibility(View.GONE);

                progressDialog = new ProgressDialog(UserActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onBackPress();
                    }
                },2000);

                Toast.makeText(UserActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                FragmentTransaction f=getSupportFragmentManager().beginTransaction(
                      //  android.R.color.transparent
                );
                f.replace(R.id.change,new frag11());
                f.commit();

            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }

    public void logout()
    {
        SharedPreManager.getInstance(this).clear();
        Intent intent=new Intent(UserActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void onBackPress()
    {
        progressDialog.dismiss();
    }
}