package com.example.projectcompany.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projectcompany.R;
import com.example.projectcompany.api.RetrofitClient;
import com.example.projectcompany.models.DefaultResponse;
import com.example.projectcompany.models.User;
import com.example.projectcompany.storage.SharedPreManager;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Useraction extends AppCompatActivity {

    private EditText editTextFname,editTextLname,editTextEmail,editTextAddress,editTextMobile,editTextPassword,editTextConfirmPassowrd,dateformat;
    private RadioGroup radioGroup;
    private RadioButton selectradioButton;
    RadioButton rb_male,rb_female;
    int month;
    int year;
    int day;
    CheckBox showpassword;



    Button deletebtn , updatebtn;
    String keys="846012712784601271278460127127";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useraction);
        dateformat=findViewById(R.id.dateformatid);
        Calendar calendar = Calendar.getInstance();

        editTextFname=findViewById(R.id.etr_fname);
        editTextLname=findViewById(R.id.etr_lname);
        editTextEmail=findViewById(R.id.etr_email);
        editTextAddress=findViewById(R.id.etr_address);
        editTextMobile=findViewById(R.id.etr_mobile);

        radioGroup=findViewById(R.id.radioGender);

        rb_male=findViewById(R.id.radio1);
        rb_female=findViewById(R.id.radio2);

        showpassword=findViewById(R.id.show_password);


        editTextPassword=findViewById(R.id.etrPassword);
        editTextConfirmPassowrd=findViewById(R.id.etrCpasswoed);
        dateformat=findViewById(R.id.dateformatid);



        User user= SharedPreManager.getInstance(this).getUser();
        editTextFname.setText(user.getFirstname());
        editTextLname.setText(user.getLastname());
        editTextEmail.setText(user.getEmailid());
        editTextAddress.setText(user.getAddress());

        dateformat.setText(user.getBirthdate());
        editTextMobile.setText(String.valueOf(user.getMobileno()));


        String pass=getIntent().getStringExtra("keypasswords");
        editTextPassword.setText(pass);

        editTextConfirmPassowrd.setText(pass);
        if(user.getGender().equals("male"))
        {
            rb_male.setChecked(true);
        }
        else
        {
            rb_female.setChecked(true);
        }

        deletebtn = findViewById(R.id.deleteuser);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });

        updatebtn=findViewById(R.id.updatepagebtn);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day =calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Useraction.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int day, int month, int year) {
                        //  dateformat.setText();
                        dateformat.setText(day + "-" + (month + 1) + "-" + year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    editTextConfirmPassowrd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else
                {
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editTextConfirmPassowrd.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });

    }

    public void deleteUser()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Useraction.this);
        builder.setTitle("Are You Sure..!");
        builder.setMessage("Your Account will be deleted for permanent");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                User user = SharedPreManager.getInstance(Useraction.this).getUser();
                Call<DefaultResponse> call = RetrofitClient.getmInstance().getApi().deleteUser(keys,user.getId());
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse deleteresponse = response.body();
                        if(deleteresponse.isResult())
                        {
                            SharedPreManager.getInstance(Useraction.this).clear();
                            Intent intent = new Intent(Useraction.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                    }
                });
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog ad=builder.create();
        ad.show();
    }




    public void updateProfile()
    {
        selectradioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        String fname = editTextFname.getText().toString().trim();
        String lname = editTextLname.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String mobileno = editTextMobile.getText().toString().trim();
        int mm=0;
        // final int mm = (mobileno == null || mobileno.trim().isEmpty() ? 0 : Integer.parseInt(mobileno));
        String password = editTextPassword.getText().toString().trim();
        String dob = dateformat.getText().toString().trim();
        String confirmpassowrds = editTextConfirmPassowrd.getText().toString().trim();
        String gender = selectradioButton.getText().toString();


        if(fname.isEmpty())
        {
            editTextFname.setError("fname is required.");
            editTextFname.requestFocus();
            return;
        }
        if(lname.isEmpty())
        {
            editTextLname.setError("lname is required.");
            editTextLname.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required.");
            editTextEmail.requestFocus();
            return;
        }
        if(address.isEmpty())
        {
            editTextAddress.setError("address is required.");
            editTextAddress.requestFocus();
            return;
        }
        if(mobileno.isEmpty() && mobileno.equals("") && !mobileno.matches("[0-9]{10}"))
        {
            editTextMobile.setError("mobile no is required.");
            editTextMobile.requestFocus();
            return;
        }
        else
        {
            mm = (int) Long.parseLong(mobileno);

        }
        if(password.isEmpty())
        {
            editTextPassword.setError("password is required.");
            editTextPassword.requestFocus();
            return;
        }
        if(confirmpassowrds.isEmpty())
        {
            editTextConfirmPassowrd.setError("password is required.");
            editTextConfirmPassowrd.requestFocus();
            return;
        }

        User user = SharedPreManager.getInstance(Useraction.this).getUser();
        Call<DefaultResponse> call= RetrofitClient.getmInstance()
                .getApi().updateUser(keys,user.getId(),fname,lname,email,address,gender,dob,mm,password,confirmpassowrds);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse updateresponse = response.body();

                if(updateresponse.isResult())
                {
                    Toast.makeText(Useraction.this, response.body().getResponsemsg(), Toast.LENGTH_SHORT).show();
                    SharedPreManager.getInstance(Useraction.this).saveUser(response.body().getData());
                    Intent intent=new Intent(Useraction.this,UserActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Useraction.this, response.body().getResponsemsg(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }


}