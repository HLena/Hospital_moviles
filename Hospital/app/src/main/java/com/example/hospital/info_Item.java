package com.example.hospital;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class info_Item extends AppCompatActivity {

    ListView listItemView;

    String[] listItemsValue = new String[] {
            "Docotr Android",
            "Docotr Android",
            "Docotr Android",


    };
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__item);

        //toolbar = (Toolbar) findViewById(R.id.toolbar4);
        //toolbar.setLogo(R.drawable.cita_icon);
        listItemView = (ListView) findViewById(R.id.listViewitems);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listItemView.setAdapter(adapter);


    }
}
