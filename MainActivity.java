package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button login;
    //private Button signin;     // login variable

    private TextView signin;     // signin variable





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //login button
        login = (Button) findViewById(R.id.button11);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Loginpage.class);
                startActivity(intent);
            }


        });

        /*
        //signin button
        signin = (Button) findViewById(R.id.button12);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, signinpage.class);
                startActivity(intent);
            }
        });*/


        //signin text button
        signin =(TextView)findViewById(R.id.mplt);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, signinpage.class);
                startActivity(intent);

            }
        });



    }
}