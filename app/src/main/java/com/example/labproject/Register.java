package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v -> {
            EditText userName = findViewById(R.id.userName);
            EditText userEmail = findViewById(R.id.userEmail);
            EditText userPassword = findViewById(R.id.userPassword);

            String name = userName.getText().toString();
            String email = userEmail.getText().toString();
            String password = userPassword.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "The name, email and password field is required.", Toast.LENGTH_SHORT).show();
            } else {

                SQLiteDatabase db = openOrCreateDatabase("messengers", MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, email VARCHAR, password VARCHAR);");
                db.execSQL("INSERT INTO users VALUES ('" + name + "', '" + email + "', '" + password + "');");
                Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);

            }
        });
    }
}