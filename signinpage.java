package com.example.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.Inet4Address;

public class signinpage extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button signin;

    private Button back;

    public String temp1;
    public String temp2;

    FirebaseAuth emcr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinpage);

        //Email
        email=(EditText) findViewById(R.id.spemail);
        //temp1=email.getText().toString();

        //Firebase object
        emcr = FirebaseAuth.getInstance();
     //   if (emcr.getCurrentUser()!=null){
       //     startActivity(new Intent(getApplicationContext(),MainActivity.class));
        //    finish(); }


        //password
        password =(EditText) findViewById(R.id.sppasswd);




        //signin button
        signin=(Button) findViewById(R.id.spb1);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp2=password.getText().toString();
                temp1=email.getText().toString();
                //Toast.makeText(signinpage.this,""+"hello "+temp2,Toast.LENGTH_SHORT).show();
                if (temp1.length()!=0 && temp2.length()!=0 && temp2.length()>=8){

                        //Firebase data entry
                    //Toast.makeText(signinpage.this,"inside if",Toast.LENGTH_SHORT).show();

                    emcr.createUserWithEmailAndPassword(temp1,temp2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()){

                                   //Firebase sending verification link
                                   FirebaseUser user =emcr.getCurrentUser();
                                   user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                       @Override
                                       public void onComplete(@NonNull Task<Void> task) {
                                           if (task.isSuccessful()){
                                               Toast.makeText(signinpage.this,"Check your mails for verification" ,Toast.LENGTH_SHORT).show();
                                               Intent intent=new Intent(signinpage.this,Loginpage.class);
                                               startActivity(intent);
                                           }
                                       }
                                   });



                                }
                                else Toast.makeText(signinpage.this,"Error" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();//find an error !!!!!
                            }
                        });




                }
                else Toast.makeText(signinpage.this,"Email or password cannot be empty",Toast.LENGTH_SHORT).show();
            }
        });


        //back button
        back=(Button) findViewById(R.id.sp_button_2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(signinpage.this,MainActivity.class);
                startActivity(intent1);
            }
        });





    }
}