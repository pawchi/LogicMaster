package com.example.logicmaster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SimpleListView extends Activity {
    String[] users = {"Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń",
            "Pawel Chilon", "Jan Kowalski", "Bernart Masztalski", "Monika Kalarepka", "Witold Pyzdroń"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> userAdapter = new ArrayAdapter<String>(this, R.layout.my_simple_listview, R.id.userName, users); //robimy adapter
        //ListView userList = new ListView(this); //można też dodać to w XMLu i zainicjować po id
        //setContentView(userList);

        //userList.setAdapter(userAdapter); //powiązuje ListView z adapterem

        GridView gridView = new GridView(this);
        setContentView(gridView);

        gridView.setNumColumns(3);

        gridView.setVerticalSpacing(120);
        gridView.setHorizontalSpacing(120);

        gridView.setAdapter(userAdapter);

        /*
        GridLayout gridLayout = new GridLayout(this);
        for (String item : users){
            TextView text = new TextView(this);
            text.setText(item);
            gridLayout.addView(text);
        }
         */

    }
}
