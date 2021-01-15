package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    public boolean table_flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void collapseTable(View view) {
        TableLayout table = findViewById(R.id.tableid);
        Button btnshow = findViewById(R.id.btnshow);
        table.setColumnCollapsed(1,table_flag);
        table.setColumnCollapsed(2,table_flag);
        if(table_flag)
        {
            table_flag=false;
            btnshow.setText("show detail");

        }
        else
        {
            table_flag=true;
            btnshow.setText("hide details");
        }
    }
}