package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class battery extends AppCompatActivity {

    private TextView BTV;
    private ProgressBar BPB;
    private BroadcastReceiver BR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        BTV = (TextView) findViewById(R.id.textViewEmail);
        }

}