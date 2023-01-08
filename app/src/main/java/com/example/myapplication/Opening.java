package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opening extends AppCompatActivity {

    private Button LIB, IMB, PB, RB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        LIB = findViewById(R.id.LIB);
        LIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Opening.this , MainActivity.class);
                startActivity(next);
            }
        });
        IMB = findViewById(R.id.IMB);
        IMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Opening.this , MainActivity.class);
                startActivity(next);
            }
        });
        PB = findViewById(R.id.PB);
        PB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Opening.this , MainActivity.class);
                startActivity(next);
            }

        });
        RB = findViewById(R.id.RB);
        RB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Opening.this , MainActivity.class);
                startActivity(next);
            }
        });


        }
    }

