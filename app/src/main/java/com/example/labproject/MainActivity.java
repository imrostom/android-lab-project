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

        TextView LoginPage = findViewById(R.id.LoginPage);
        LoginPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        });

        TextView RegisterPage = findViewById(R.id.RegisterPage);
        RegisterPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        });

        TextView UserPage = findViewById(R.id.UserPage);
        UserPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), User.class);
            startActivity(intent);
        });

        TextView ProfilePage = findViewById(R.id.ProfilePage);
        ProfilePage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);
        });

        TextView TeamPage = findViewById(R.id.TeamPage);
        TeamPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Team.class);
            startActivity(intent);
        });

        TextView MessagePage = findViewById(R.id.MessagePage);
        MessagePage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Message.class);
            startActivity(intent);
        });
    }
}