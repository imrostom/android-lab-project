package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView LoginPage = (TextView) findViewById(R.id.LoginPage);
        LoginPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        });

        TextView RegisterPage = (TextView) findViewById(R.id.RegisterPage);
        RegisterPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        });

        TextView UserPage = (TextView) findViewById(R.id.UserPage);
        UserPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), User.class);
            startActivity(intent);
        });

        TextView ProfilePage = (TextView) findViewById(R.id.ProfilePage);
        ProfilePage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);
        });

        TextView TeamPage = (TextView) findViewById(R.id.TeamPage);
        TeamPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Team.class);
            startActivity(intent);
        });
    }
}