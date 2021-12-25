package com.example.labproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    String[] nameList = new String[50];
    String[] emailList = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        SQLiteDatabase db = openOrCreateDatabase("messengers", MODE_PRIVATE, null);
        final Cursor c  = db.rawQuery("SELECT * FROM users", null);
        c.moveToFirst();

        int nameIndex = c.getColumnIndex("name");
        int emailIndex = c.getColumnIndex("email");

        nameList[0] = c.getString(nameIndex);
        emailList[0] = c.getString(emailIndex);

        try {
            int i = 1;
            while (c.moveToNext()) {
                nameList[i] = c.getString(nameIndex);
                emailList[i] = c.getString(emailIndex);
                i++;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            c.close();
        }

        MyListAdapter adapter = new MyListAdapter(this, nameList, emailList);
        ListView userList = findViewById(R.id.userList);
        userList.setAdapter(adapter);

        userList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), Message.class);
            startActivity(intent);
        });
    }
}