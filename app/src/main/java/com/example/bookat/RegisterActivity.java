package com.example.bookat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView signUpButton;
    TextView alreadyRegistered, forgotPassword;
    EditText emailEditText, passwordEditText, confirm_passwordEditText;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        getSupportActionBar().hide(); //this code removes the Title Bar

        // Define the card

        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.passWord);
        confirm_passwordEditText = (EditText) findViewById(R.id.confirmPassword);

        // Adding click listener to the card
//        signUpButton.setOnClickListener(this);

        alreadyRegistered = findViewById(R.id.alreadyRegistered);
        alreadyRegistered.setInputType(InputType.TYPE_NULL);
        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        db = new DatabaseHelper(this);

        signUpButton = (CardView) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirm_pwd = confirm_passwordEditText.getText().toString().trim();

                if (password.equals(confirm_pwd)) {

                    long val = db.addUser(email, password);

                    if (val > 0 )
                    {
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }


                }

                else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onClick(View v) {
//        Intent i;
//
//        switch (v.getId()) {
//            case R.id.signUpButton : i = new Intent(this, LoginActivity.class); startActivity(i);break;
//            default:break;
//
//        }
//
//        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show();
//

    }


}
