package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    // [START declare_auth]
    private FirebaseHandler firebaseHandler;
    private FirebaseAuth mAuth;

    private EditText ETEA;
    private EditText ETP;
    private Button signInBtn;
    private Button OpenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // [START initialize_auth]
        firebaseHandler = new FirebaseHandler();
        // Initialize Firebase Auth
        mAuth = firebaseHandler.getmAuth();
        // [END initialize_auth]

        ETEA = findViewById(R.id.ETEA);
        ETP = findViewById(R.id.ETP);
        signInBtn = findViewById(R.id.SIButton);
        OpenBtn = findViewById(R.id.OpenBtn);

        OpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Opening.class);
                startActivity(next);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseHandler.signIn(ETEA.getText().toString(), ETP.getText().toString(), success -> {
                    if (success) {
                        Toast.makeText(MainActivity.this, "Signed in successfully!", Toast.LENGTH_LONG);
                        Intent openingActivity = new Intent(MainActivity.this, Opening.class);
                        startActivity(openingActivity);
                    } else {
                        Toast.makeText(MainActivity.this, "Try again." , Toast.LENGTH_LONG);
                    }
                });
            }
        });

    }



    /*private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(MainActivity.this, "Authentication succeed.",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // [END sign_in_with_email]
    }*/
}