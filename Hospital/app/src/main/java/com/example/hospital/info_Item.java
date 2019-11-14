package com.example.hospital;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hospital.utilidades.Utilidades;

import java.util.ArrayList;

public class info_Item extends AppCompatActivity {

    ListView listItemView;
    ListView listAppoimentsDoctor;

    ArrayList<String> listItemsValue = new ArrayList<String>();
    ArrayList<String> listItemsIds = new ArrayList<String>();

    Toolbar toolbar;

    String doctor_id;
    String doctor_name;
    String hospital_id;

    ConexionSQLiteHelper conn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__item);



        //toolbar = (Toolbar) findViewById(R.id.toolbar4);
        //toolbar.setLogo(R.drawable.cita_icon);


        listItemView = (ListView) findViewById(R.id.listViewitems);


        Bundle res= this.getIntent().getExtras();


        listItemsValue.clear();


        if(res!=null)
        {
            doctor_name=res.getString("doctor_name");
            doctor_id=res.getString("doctor_id");
            hospital_id=res.getString("hospital_id");


            TextView mytoolbarTitle =(TextView)findViewById(R.id.title);
            mytoolbarTitle.setText("Dr. "+doctor_name);



        }


        conn = new  ConexionSQLiteHelper(this.getApplicationContext(),"db_hospital",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();


        String whereClause = "idMedico = ? and idHospital =?";
        String[] whereArgs = new String[] {
                doctor_id,
                hospital_id,
        };



        String MY_QUERY ="SELECT * FROM "+Utilidades.TABLA_CITA + " INNER JOIN "+Utilidades.TABLA_PACIENTE +" ON "+Utilidades.TABLA_CITA+".idPaciente = "+Utilidades.TABLA_PACIENTE+".id WHERE "+Utilidades.TABLA_CITA+".idMedico = ? and "+Utilidades.TABLA_CITA+".idHospital =? ;";

        Cursor cursor = db.rawQuery(MY_QUERY, whereArgs);



        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String fecha = cursor.getString(cursor.getColumnIndex("fecha"));
                String idAppoinment = cursor.getString(cursor.getColumnIndex("id"));
                String pacienteAppoinment = cursor.getString(cursor.getColumnIndex("nombre"));


                listItemsIds.add(idAppoinment);
                listItemsValue.add(fecha+" - "+pacienteAppoinment );


                cursor.moveToNext();
            }
        }


        listAppoimentsDoctor = (ListView)findViewById(R.id.listViewitems);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listItemView.setAdapter(adapter);


    }
}
