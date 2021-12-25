package com.example.labproject;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] nameList;
    private final String[] emailList;

    public MyListAdapter(Activity context, String[] nameList, String[] emailList) {
        super(context, R.layout.userlist, nameList);

        this.context = context;
        this.nameList = nameList;
        this.emailList = emailList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.userlist, null, true);

        TextView nameListText = rowView.findViewById(R.id.title);
        TextView emailListText = rowView.findViewById(R.id.subtitle);

        nameListText.setText(nameList[position]);
        emailListText.setText(emailList[position]);

        return rowView;

    }
}