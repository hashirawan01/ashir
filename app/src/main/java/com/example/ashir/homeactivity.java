package com.example.ashir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class homeactivity extends AppCompatActivity {
    TextView textView_name, textView_password;
    Button button_logout, recycle_viewbtn;
    SharedPreferences sharedPreferences;
    private static final String shared_prefrence_name = "my_pref";
    private static final String key_name = "name";
    private static final String key_password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        textView_password = findViewById(R.id.text_password);
        textView_name = findViewById(R.id.editText_name);
        button_logout = findViewById(R.id.button_logout);
        recycle_viewbtn = findViewById(R.id.recycle_viewbtn);
        sharedPreferences = getSharedPreferences(shared_prefrence_name, MODE_PRIVATE);
        String name = sharedPreferences.getString(key_name, null);
        String password = sharedPreferences.getString(key_password, null);
        if (name != null || password != null) {
            textView_name.setText("full Name is : " + name);
            textView_password.setText("password is " + password);
        }
        recycle_viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeactivity.this, Recyclerview_activity.class);
                startActivity(intent);


            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(homeactivity.this, "logout succesfully", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(j);
                finish();
            }


        });


    }

}
