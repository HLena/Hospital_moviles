package com.example.hospital;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hospital.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Appointment extends Fragment {

    ListView listItemView;
    FloatingActionButton button_float;
    ConexionSQLiteHelper conn;

    ArrayList<String> listItemsIds = new ArrayList<String>();
    ArrayList<String> listItemsNames = new ArrayList<String>();


    public Appointment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_appointment, container, false);

        Bundle res= getActivity().getIntent().getExtras();
        String hospital_id ="";

        if(res!=null)
        {
            hospital_id=res.getString("hospital_id");
        }

        conn = new  ConexionSQLiteHelper(getActivity().getApplicationContext(),"db_hospital",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String whereClause = "idHospital = ? ";
        String[] whereArgs = new String[] {
                hospital_id
        };
        String[] campos = {Utilidades.CAMPO_ID_CITA,Utilidades.CAMPO_FECHA_CITA};
        Cursor cursor = db.query(Utilidades.TABLA_CITA,campos,whereClause,whereArgs,null,null,null);


        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("fecha"));
                String idHospital = cursor.getString(cursor.getColumnIndex("id"));

                listItemsIds.add(idHospital);
                listItemsNames.add(name);
                cursor.moveToNext();
            }
        }


        listItemView = (ListView) rootView.findViewById(R.id.listViewAppointments);
        button_float = (FloatingActionButton) rootView.findViewById(R.id.add_appointment);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_2, android.R.id.text1,listItemsNames);
        listItemView.setAdapter(adapter);

        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogsAppointment();
            }
        });

        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HospitalsActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), info_Item.class);
                String itemClicked = listItemsNames.get(position);
                intent.putExtra("item_name", itemClicked);
                startActivity(intent);

            }
        });
        return rootView;
    }

    private void showFormsDialogsAppointment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CreateBookingFrag form = CreateBookingFrag.newInstance("some title");
        form.show(ft, "fragment_create_booking");


    }


}
