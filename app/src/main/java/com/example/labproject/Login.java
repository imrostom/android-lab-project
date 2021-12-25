package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.loginBtn);
        EditText userEmail = findViewById(R.id.userEmail);
        EditText userPassword = findViewById(R.id.userPassword);

        loginBtn.setOnClickListener(v -> {

            String name = "";
            String email = userEmail.getText().toString();
            String password = userPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "The email and password field is required.", Toast.LENGTH_SHORT).show();
            } else {

                SQLiteDatabase db = openOrCreateDatabase("messengers", MODE_PRIVATE, null);
                final Cursor c = db.rawQuery("SELECT * FROM users", null);
                c.moveToFirst();

                int nameIndex = c.getColumnIndex("name");
                int emailIndex = c.getColumnIndex("email");
                int passwordIndex = c.getColumnIndex("password");

                boolean loginCheck = false;
                if (c.getString(emailIndex).equals(email) && c.getString(passwordIndex).equals(password)) {
                    name = c.getString(nameIndex);
                    loginCheck = true;
                }

                try {
                    while (c.moveToNext()) {
                        if (c.getString(emailIndex).equals(email) && c.getString(passwordIndex).equals(password)) {
                            name = c.getString(nameIndex);
                            loginCheck = true;
                            break;
                        } else {
                            loginCheck = false;
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    c.close();
                }

                if (loginCheck) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), User.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please provide valid information", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}