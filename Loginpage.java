package com.example.signin;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Loginpage extends AppCompatActivity {

    private EditText email;
    private EditText password;

    public String temp1;
    public String temp2;

    private TextView signin;
    private TextView forpass;

    private Button login;
    FirebaseAuth emlg;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        //Email
        email=(EditText) findViewById(R.id.lpemail);



        //password
        password =(EditText) findViewById(R.id.lppaaswd);

        emlg = FirebaseAuth.getInstance();





        //login button
        login =(Button) findViewById(R.id.lpb1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //email password assignment
                temp1=email.getText().toString().trim();
                temp2=password.getText().toString().trim();

               // Toast.makeText(Loginpage.this,"Outside if &"+temp1.getClass().getName()+"&"+temp2.getClass().getName()+"&" ,Toast.LENGTH_LONG).show();




                //Authentication
                if (temp1.length()!=0 && temp2.length()!=0){

                    emlg.signInWithEmailAndPassword(temp1,temp2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //signin Firebase
                            if (task.isSuccessful()){
                                FirebaseUser user =emlg.getCurrentUser();

                                //email verification
                                if (!user.isEmailVerified()){
                                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(Loginpage.this,"Check your mails for verification",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                                else{
                                    Intent intent=new Intent(Loginpage.this,finalpage.class);
                                    startActivity(intent);
                                }
                            }
                            else Toast.makeText(Loginpage.this,"Error either user id or password is invalid",Toast.LENGTH_SHORT).show();//find an error !!!!!
                        }
                    });
                }
                else Toast.makeText(Loginpage.this,"Email or password cannot be empty",Toast.LENGTH_LONG).show();
            }
        });


        //forgot passsword
        forpass=(TextView) findViewById(R.id.lpage_fpass);
        forpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Loginpage.this,verification.class);
                startActivity(intent);
            }
        });


        //signin text
        signin=(TextView) findViewById(R.id.lpage_text);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Loginpage.this,signinpage.class);
                startActivity(intent);
            }
        });




    }
}