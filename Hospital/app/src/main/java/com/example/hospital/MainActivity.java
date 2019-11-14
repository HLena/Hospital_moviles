package com.example.hospital;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hospital.entidades.Hospital;

public class MainActivity extends AppCompatActivity {


    Button b1,b2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        b1 = (Button)findViewById(R.id.button_ingresar);


        b1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),HospitalsActivity.class);
                startActivityForResult(intent,0);
            }
        });


        b2 = (Button)findViewById(R.id.button_salir);


        b2.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        });




        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"db_hospital",null,1);





    }
}
