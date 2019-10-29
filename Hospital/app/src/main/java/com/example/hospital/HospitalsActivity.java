package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HospitalsActivity extends AppCompatActivity {

    ListView listItemView;
    FloatingActionButton button_float;

    String[] listItemsValue = new String[] {
            "Hospital Android",
            "Hospital PHP",
            "Hospital Web Development",
            "Hospital Blogger",
            "Hospital SEO",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        listItemView = (ListView) findViewById(R.id.listView1);
        button_float = (FloatingActionButton) findViewById(R.id.button_float1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listItemView.setAdapter(adapter);

        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogsHospital();
            }
        });

        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HospitalsActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HospitalsActivity.this, InfoHospitalActivity.class);
                String itemClicked = listItemsValue[position];
                intent.putExtra("item_name", itemClicked);
                startActivity(intent);
            }
        });

    }

    private void showFormsDialogsHospital(){
        FragmentManager fm = getSupportFragmentManager();
        CreateHospitalFrag form = CreateHospitalFrag.newInstance("some tilte");
        form.show(fm, "fragment_create_hospital");
    }


}
