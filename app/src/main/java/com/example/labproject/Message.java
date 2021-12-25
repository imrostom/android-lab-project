package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        EditText typeMessage = findViewById(R.id.typeMessage);
        ImageView submitMessage = findViewById(R.id.submitMessage);

        submitMessage.setOnClickListener(v -> {

            String message = typeMessage.getText().toString();

            if (message.isEmpty()) {
                Toast.makeText(getApplicationContext(), "The message field is required.", Toast.LENGTH_SHORT).show();
            } else {

                SQLiteDatabase db = openOrCreateDatabase("messengers", MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS messages(message VARCHAR);");
                db.execSQL("INSERT INTO messages VALUES ('" + message + "');");
                Toast.makeText(getApplicationContext(), "Message Send Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), User.class);
                startActivity(intent);

            }
        });
    }
}