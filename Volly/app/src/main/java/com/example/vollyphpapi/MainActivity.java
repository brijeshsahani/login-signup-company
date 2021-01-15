package com.example.vollyphpapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView get_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button get_btn=findViewById(R.id.getbtn);
        get_text=findViewById(R.id.getres);

        get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendGetData();
            }
        });
    }

    public void sendGetData()
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://www.getpostman.com/collections/289877c71befed473bd0";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                get_text.setText("Data"+response);
                Log.d("a",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                get_text.setText("error");
            }
        });
        queue.add(stringRequest);
    }
}