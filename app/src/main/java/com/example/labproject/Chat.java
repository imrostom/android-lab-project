package com.example.labproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Chat extends AppCompatActivity {

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
        setContentView(R.layout.activity_chat);

        MyListAdapter adapter = new MyListAdapter(this, mainTitle, subTitle, imgId);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Chatbox.class);
                startActivity(intent);
            }
        });
    }
}