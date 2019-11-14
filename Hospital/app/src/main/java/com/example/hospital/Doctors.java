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
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hospital.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Doctors extends Fragment {

    ListView listItemView;
    FloatingActionButton button_float;

    String[] listItemsValue = new String[] {
            "Docotr Android",
            "Docotr Android",
            "Docotr Android",


    };

    String hospital_name ="";
    String hospital_id ="";
    ConexionSQLiteHelper conn;

    ArrayList<String> listItemsIds = new ArrayList<String>();
    ArrayList<String> listItemsNames = new ArrayList<String>();

    public Doctors() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);

        Bundle res= getActivity().getIntent().getExtras();


        listItemsNames.clear();
        listItemsIds.clear();

        if(res!=null)
        {
            hospital_name=res.getString("hospital_name");
            hospital_id=res.getString("hospital_id");
        }

        conn = new  ConexionSQLiteHelper(getActivity().getApplicationContext(),"db_hospital",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String whereClause = "idHospital = ? ";
        String[] whereArgs = new String[] {
            hospital_id
        };
        String[] campos = {Utilidades.CAMPO_ID_MEDICO,Utilidades.CAMPO_NOMBRE_MEDICO};
        Cursor cursor = db.query(Utilidades.TABLA_MEDICO,campos,whereClause,whereArgs,null,null,null);


        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("nombre"));
                String idDoctor = cursor.getString(cursor.getColumnIndex("id"));

                listItemsIds.add(idDoctor);
                listItemsNames.add(name);
                cursor.moveToNext();
            }
        }



        listItemView = (ListView) rootView.findViewById(R.id.listViewDoctors);
        button_float = (FloatingActionButton) rootView.findViewById(R.id.add_doctor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_2, android.R.id.text1, listItemsNames);
        listItemView.setAdapter(adapter);
        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HospitalsActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), info_Item.class);

                String doctorName = listItemsNames.get(position);
                String doctorId = listItemsIds.get(position);

                intent.putExtra("doctor_name", doctorName);
                intent.putExtra("doctor_id", doctorId);
                intent.putExtra("hospital_id", hospital_id);

                startActivity(intent);

            }
        });

        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogsDoctor();
            }
        });
        return rootView;
    }

    private void showFormsDialogsDoctor(){

        FragmentTransaction fm = getFragmentManager().beginTransaction();
        CreateDoctorFrag form = CreateDoctorFrag.newInstance("some tilte");
        form.show(fm, "fragment_create_doctor");
    }

}
