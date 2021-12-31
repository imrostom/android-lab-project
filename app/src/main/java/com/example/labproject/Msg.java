package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Msg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        String[] values = new String[]{
                "Angilla Tattoo",
                "Cantate Beveled",
                "Krinkes Decor PERSONAL",
                "Krinkes Regular PERSONAL",
                "Silent Reaction"
        };

        SQLiteDatabase db = openOrCreateDatabase("messengers", MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("SELECT * FROM messages", null);
        c.moveToFirst();

        int messageIndex = c.getColumnIndex("message");

        values[0] = c.getString(messageIndex);
        try {
            int i = 1;
            while (c.moveToNext()) {
                values[i] = c.getString(messageIndex);
                i++;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }



        EditText typeMessage = findViewById(R.id.typeMessage);
        ImageView submitMessage = findViewById(R.id.submitMessage);

        submitMessage.setOnClickListener(v -> {

            String message = typeMessage.getText().toString();

            if (message.isEmpty()) {
                Toast.makeText(getApplicationContext(), "The message field is required.", Toast.LENGTH_SHORT).show();
            } else {
                db.execSQL("CREATE TABLE IF NOT EXISTS messages(message VARCHAR);");
                db.execSQL("INSERT INTO messages VALUES ('" + message + "');");
                Toast.makeText(getApplicationContext(), "Message Send Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Msg.class);
                startActivity(intent);

            }
        });

        ListView listFont = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, values);
        listFont.setAdapter(adapter);
    }
}