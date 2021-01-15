package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    Button alertbtns;
//
//
//    TextView txt;
//    Button btn;
//    RatingBar ratingBar;


    EditText dateformat;
    int month;
    int year;
    int day;

//    RadioGroup group;
//    RadioButton radioButton;
//
//    CheckBox check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    onclick();
    //    rating();
//        onButtonClickListner();

//        group = findViewById(R.id.radiogp);
//
//
//
//
//        check1 = findViewById(R.id.cb1);
//
//        check1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StringBuffer result = new StringBuffer();
//                result.append("Reading").append(check1.isChecked());
//                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        check2 = findViewById(R.id.cb2);
//
//        check2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StringBuffer result = new StringBuffer();
//                result.append("Movies").append(check1.isChecked());
//                Toast.makeText(MainActivity.this,result.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        check3 = findViewById(R.id.cb3);
//
//        check3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StringBuffer result = new StringBuffer();
//                result.append("Travelling").append(check1.isChecked());
//                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        dateformat=findViewById(R.id.dateformatid);
        Calendar calendar = Calendar.getInstance();

        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day =calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

//    public  void  radiobtn(View v)
//    {
//        int radiobtnselect = group.getCheckedRadioButtonId();
//        radioButton=findViewById(radiobtnselect);
//        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
//    }

//    public  void rating()
//    {
//        txt=findViewById(R.id.textrate);
//        ratingBar=findViewById(R.id.ratingbar);
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                txt.setText(String.valueOf(v));
//            }
//        });
//    }
//
//    public  void onclick()
//    {
//        ratingBar=findViewById(R.id.ratingbar);
//        btn=findViewById(R.id.btnrate);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

//    public void onButtonClickListner()
//    {
//        alertbtns=findViewById(R.id.alertbtn);
//        alertbtns.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
//                a_builder.setMessage("do you want to close this app?").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finish();
//                    }
//                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//
//                AlertDialog alertDialog=a_builder.create();
//                alertDialog.setTitle("Alert box");
//                alertDialog.show();
//
//
//            }
//        });
//    }
}