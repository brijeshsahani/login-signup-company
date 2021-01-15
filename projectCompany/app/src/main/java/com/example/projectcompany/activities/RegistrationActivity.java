package com.example.projectcompany.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.DatePicker;

import com.example.projectcompany.R;
import com.example.projectcompany.api.RetrofitClient;
import com.example.projectcompany.models.DefaultResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

   private EditText editTextFname,editTextLname,editTextEmail,editTextAddress,editTextMobile,editTextPassword,editTextConfirmPassowrd,dateformat;
    private RadioGroup radioGroup;
    private RadioButton selectradioButton;
    RadioButton rb_male,rb_female;
    int month;
    int year;
    int day;

    String keys="846012712784601271278460127127";

    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


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
        editTextPassword=findViewById(R.id.etr_password);
        editTextConfirmPassowrd=findViewById(R.id.etr_cpassword);
        dateformat=findViewById(R.id.dateformatid);
        button=findViewById(R.id.regpagebtn);


        ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                validateEmailAddressandempty(email,password,fname,lname,address,mobileno,confirmpassword);
                userRegistration();


            }
        });






        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day =calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int day, int month, int year) {
                      //  dateformat.setText();
                        dateformat.setText(day + "-" + (month + 1) + "-" + year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


    }

//    private boolean validateEmailAddressandempty(EditText email,EditText password,EditText fname,EditText lname, EditText address,EditText mobileno,EditText confirmpassword)
//    {
//        String emailInput = email.getText().toString();
//        String passwordInput = password.getText().toString();
//        String firstnameInput = fname.getText().toString();
//        String lastnameInput = lname.getText().toString();
//        String addressInput = address.getText().toString();
//        String mobileInput = mobileno.getText().toString();
//        String cpasswordInput = confirmpassword.getText().toString();
//
//        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() && !passwordInput.isEmpty() && !firstnameInput.isEmpty() && !lastnameInput.isEmpty() && !addressInput.isEmpty() && !mobileInput.isEmpty() && !cpasswordInput.isEmpty())
//        {
//            Toast.makeText(this, "all fileds is valid", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else
//        {
//            Toast.makeText(this, "all fields required", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void userRegistration()
    {

        selectradioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        String fname = editTextFname.getText().toString().trim();
        String lname = editTextLname.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
       String mobileno = editTextMobile.getText().toString().trim();

       // final int mm = (mobileno == null || mobileno.trim().isEmpty() ? 0 : Integer.parseInt(mobileno));
        String password = editTextPassword.getText().toString().trim();
        String dob = dateformat.getText().toString().trim();
        String confirmpassowrds = editTextConfirmPassowrd.getText().toString().trim();
        int mm=0;

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


        Call<DefaultResponse> call= RetrofitClient.getmInstance()
                .getApi().userregistration(keys,fname,lname,email,address,gender,dob,mm,password,confirmpassowrds);

                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse registrationResponse = response.body();


                        if(registrationResponse.isResult())
                        {
                            Toast.makeText(RegistrationActivity.this,"success", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(intent);



                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, registrationResponse.getResponsemsg(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(RegistrationActivity.this, dob, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                    }
                });


    }
}

