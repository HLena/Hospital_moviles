package com.example.hospital;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.hospital.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class list_appoiment_patient extends AppCompatActivity {

    ListView listAppoimentsPatient;



    ArrayList<String> listItemsValue = new ArrayList<String>();
    ArrayList<String> listItemsIds = new ArrayList<String>();

    ConexionSQLiteHelper conn;

    Toolbar toolbar;

    String patient_id ="";
    String patient_name ="";
    String hospital_id="";

    FloatingActionButton button_float;

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appoiment_patient);

        listAppoimentsPatient = (ListView) findViewById(R.id.listViewitems);




        Bundle res= this.getIntent().getExtras();


        listItemsValue.clear();


        if(res!=null)
        {
            patient_name=res.getString("patient_name");
            patient_id=res.getString("patient_id");
            hospital_id=res.getString("hospital_id");

            TextView mytoolbarTitle =(TextView)findViewById(R.id.title);
            mytoolbarTitle.setText(patient_name);
        }

        conn = new  ConexionSQLiteHelper(this.getApplicationContext(),"db_hospital",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String whereClause = "idPaciente = ? and idHospital =?";
        String[] whereArgs = new String[] {
                patient_id,
                hospital_id,
        };


        String[] campos = {Utilidades.CAMPO_ID_CITA,Utilidades.CAMPO_ID_PACIENTE_CITA,Utilidades.CAMPO_FECHA_CITA};

        Cursor cursor = db.query(Utilidades.TABLA_CITA,campos,whereClause,whereArgs,null,null,null);


        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String fecha = cursor.getString(cursor.getColumnIndex("fecha"));
                String idAppoinment = cursor.getString(cursor.getColumnIndex("id"));

                listItemsIds.add(idAppoinment);
                listItemsValue.add("F: "+fecha+"  Cod: "+idAppoinment );

                cursor.moveToNext();
            }
        }

        listAppoimentsPatient = (ListView)findViewById(R.id.listViewAppointmentsPatient);

        button_float = (FloatingActionButton) findViewById(R.id.add_appointment);
        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogsPatient();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listAppoimentsPatient.setAdapter(adapter);

        back = (ImageButton)findViewById(R.id.backButton);


        back.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                list_appoiment_patient.super.onBackPressed();
            }
        });
    }



    private void showFormsDialogsPatient(){
        FragmentManager fm = getSupportFragmentManager();
        CreateBookingFrag form = CreateBookingFrag.newInstance("some tilte");
        form.show(fm, "fragment_create_booking");
    }


}
