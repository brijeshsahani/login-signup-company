package com.example.projectcompany.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectcompany.R;
import com.example.projectcompany.api.RetrofitClient;
import com.example.projectcompany.models.DefaultResponse;
import com.example.projectcompany.storage.SharedPreManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail,editTextPassword;
    String keys="846012712784601271278460127127";
    Button button;
    CheckBox showpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail=findViewById(R.id.et_email);
        button=findViewById(R.id.loginpagebtn);

        editTextPassword = findViewById(R.id.et_password);
        showpassword=findViewById(R.id.show_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                userlogin();


            }
        });

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void userlogin()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required.");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editTextPassword.setError("password is required.");
            editTextPassword.requestFocus();
            return;
        }

        Call<DefaultResponse> call= RetrofitClient.getmInstance()
                .getApi().userlogin(keys,email,password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse loginResponse = response.body();

                if(loginResponse.getResponsemsg().equals("login successfully"))
                {
                    SharedPreManager.getInstance(LoginActivity.this).saveUser(loginResponse.getData());
                    Toast.makeText(LoginActivity.this, loginResponse.getData().getConfirmpassword(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this,"success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                    intent.putExtra("keypassword",password);
                    startActivity(intent);



                }
                else {
                    Toast.makeText(LoginActivity.this, loginResponse.getResponsemsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

//    private void openProfile(){
//        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
//
//        startActivity(intent);
//    }

}