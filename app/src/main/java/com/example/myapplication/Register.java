package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {

    private FirebaseHandler firebaseHandler;
    private FirebaseAuth mAuth;

    private Button RGB;
    private EditText RGEmail;
    private EditText RGPass;
    private EditText VRPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // [START initialize_auth]
        // Initialize Firebase Auth
        firebaseHandler = new FirebaseHandler();
        mAuth = firebaseHandler.getmAuth();
        // [END initialize_auth]

        RGEmail = findViewById(R.id.RGEmail);
        RGPass = findViewById(R.id.RGPass);
        VRPass = findViewById(R.id.VRPass);
        RGB = findViewById(R.id.RGB);

        RGB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (VRPass.getText().toString().equals(RGPass.getText().toString())) {
                    firebaseHandler.createAccount(RGEmail.getText().toString(),RGPass.getText().toString(), success -> {
                        if (success) {
                            Toast.makeText(Register.this, "Register completed!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Register.this, "Try again.", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Register.this, "Passwords do not match!", Toast.LENGTH_LONG);
                }

            }
        });
    }


}