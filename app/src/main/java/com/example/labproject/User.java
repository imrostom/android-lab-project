package com.example.labproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    String[] mainTitle = {
            "Rostom Ali",
            "Noman Sheikh",
            "Hamim Ahammad",
            "Tapos",
            "Any",
    };

    String[] subTitle = {
            "Student",
            "Student",
            "Student",
            "Student",
            "Student",
    };

    Integer[] imgId = {
            R.drawable.user,
            R.drawable.user,
            R.drawable.user,
            R.drawable.user,
            R.drawable.user,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        MyListAdapter adapter = new MyListAdapter(this, mainTitle, subTitle, imgId);
        ListView userList = (ListView) findViewById(R.id.userList);
        userList.setAdapter(adapter);

        userList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), Message.class);
            startActivity(intent);
        });
    }
}