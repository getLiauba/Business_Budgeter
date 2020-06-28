package com.example.business_budgeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText rFirstName, rLastName, rEmail, rPassword;
    Button Register;
    TextView rLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rFirstName = findViewById(R.id.First_Name_Input);
        rLastName = findViewById(R.id.Last_Name_Input);
        rEmail = findViewById(R.id.Email_Input);
        rPassword = findViewById(R.id.Password_Input);
        Register = findViewById(R.id.Create_Account);
        rLoginBtn = findViewById(R.id.GoToLogin);

        fAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = rEmail.getText().toString().trim();
                String password = rPassword.getText().toString().trim();

                //Add Error checking to ensure user has been created!!
                fAuth.createUserWithEmailAndPassword(email,password);
            }
        });

        rLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }
}