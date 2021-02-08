package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class verification extends AppCompatActivity {

    private Button otp;
    private EditText email;
    private String emailtext;

    FirebaseAuth emailver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        //email input
        email=(EditText) findViewById(R.id.ver_email);
        emailtext=email.getText().toString().trim();

        emailver=FirebaseAuth.getInstance()

        if(email.length()!=0){


        }
        else Toast.makeText(verification.this, "Email field cannot be empty", Toast.LENGTH_SHORT).show();








        //get otp button
        otp = (Button) findViewById(R.id.otp_button);
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(verification.this,otp.class);
                startActivity(intent);
            }
        });
    }
}