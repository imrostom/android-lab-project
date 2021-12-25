package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        String name = pref.getString("name", "Default");
        String email = pref.getString("email", "default@gmail.com");

        TextView userName = findViewById(R.id.userName);
        TextView userEmail = findViewById(R.id.userEmail);

        userName.setText(name);
        userEmail.setText(email);

    }
}