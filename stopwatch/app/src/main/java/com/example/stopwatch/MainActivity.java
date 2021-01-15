package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(R.id.chronometer);
    }

    public void startchronometer(View v) {
        if(!running)
        {
            chronometer.start();
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
            running=true;
        }
    }

    public void pausechronometer(View view) {
        if(running)
        {
            chronometer.stop();
            pauseoffset=SystemClock.elapsedRealtime() - chronometer.getBase();
            running=false;
        }
    }

    public void resetchronometer(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset=0;
    }
}