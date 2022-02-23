package com.example.ashir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class sign_up extends AppCompatActivity {
    TextView textView2;
    EditText TextPersonName,TextEmailAddress,password1;
    Button register;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
     FirebaseAuth mauth;
     FirebaseUser muser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textView2=findViewById(R.id.textView2);
        TextPersonName=findViewById(R.id.TextPersonName);
        TextEmailAddress=findViewById(R.id.TextEmailAddress);
        password1=findViewById(R.id.password1);
        register=findViewById(R.id.register);
        progressDialog=new ProgressDialog(this);
        mauth=FirebaseAuth.getInstance();
        muser=mauth.getCurrentUser();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performauth();
            }
        });
    }

    private void performauth() {
        String name=TextPersonName.getText().toString();
        String email=TextEmailAddress.getText().toString();
        String password=password1.getText().toString();

        if(!email.matches( emailPattern))
        {
            TextEmailAddress.setError("Enter the correct email address");
        }
        else if(password.isEmpty() || password.length()<6)
        {
        password1.setError("enter valid password");

        }
        else if(name.isEmpty())
        {
            TextPersonName.setError("please enter your Name ");
        }
        else{
            progressDialog.setMessage("please wait for Registration....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sentUsertoNewactivity();
                        Toast.makeText(sign_up.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(sign_up.this, "Error occured while registrating", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void  sentUsertoNewactivity() {
        Intent intent=new Intent(sign_up.this,homeactivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}