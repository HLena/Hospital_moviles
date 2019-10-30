package com.example.hospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.hospital.entidades.Hospital;
import com.example.hospital.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Vector;

public class HospitalsActivity extends AppCompatActivity {

    ListView listItemView;
    FloatingActionButton button_float;

    ConexionSQLiteHelper conn;
    ArrayList<String> listItemsValue = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        conn = new  ConexionSQLiteHelper(getApplicationContext(),"db_hospital",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String[] campos = {Utilidades.CAMPO_NOMBRE};
        Cursor cursor = db.query(Utilidades.TABLA_HOSPITAL,campos,null,null,null,null,null);

        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("nombre"));

                    listItemsValue.add(name);
                cursor.moveToNext();
            }
        }


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
                String itemClicked = listItemsValue.get(position);

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
