package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (ImageButton)findViewById(R.id.imgB1);
        b2 = (ImageButton)findViewById(R.id.imgB2);

        b1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),HospitalsActivity.class);
                startActivityForResult(intent,0);
            }
        });

        /*HospitalDB dbHelper = new HospitalDB(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
             //Hacer las operaciones que queramos sobre la base de datos
            db.execSQL("INSERT INTO Hopitals(hospital_id, hospital_name) VALUES ('Digital Learning','Esto es un comentario insertado usando el método execSQL()')");
        }*/
    }
}
