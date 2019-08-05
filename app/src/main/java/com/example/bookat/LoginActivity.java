package com.example.bookat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView signInButton;
    TextView signUp, forgotPassword;
    EditText emailEditText, passwordEditText;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); //this code removes the Title Bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //this code removed the Notification Bar

        // Defining the

        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.passWord);

        // Adding click listener to the card
//        signInButton.setOnClickListener(this);

        signUp = (TextView) findViewById(R.id.registerHere);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setInputType(InputType.TYPE_NULL);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailDialogBox();
            }
        });



        db = new DatabaseHelper(this);

        signInButton = (CardView) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (db.checkUser(email, password)) {
                    Intent moveToHome = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(moveToHome);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public void onClick(View v) {
//        Intent i;
//
//        switch (v.getId()) {
//            case R.id.signInButton : i = new Intent(this, HomeActivity.class); startActivity(i);break;
//            default:break;
//
//        }

    }

    public void emailDialogBox() {
        new AlertDialog.Builder(this)
                .setTitle("Forgotten Password?")
                .setMessage("Send a verification code to your email?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "Reset code sent to your email", Toast.LENGTH_LONG).show();

                    }
                }).create().show();
    }
}
