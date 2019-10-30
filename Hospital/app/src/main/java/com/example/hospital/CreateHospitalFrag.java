package com.example.hospital;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.hospital.utilidades.Utilidades;


public class CreateHospitalFrag extends DialogFragment {
    private EditText mEditText;
    private  Button createB, cancelB;



    public CreateHospitalFrag() {
        // Required empty public constructor
    }

    public static CreateHospitalFrag newInstance(String title) {
        CreateHospitalFrag frag = new CreateHospitalFrag();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_hospital, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.name_hospital);
        createB = (Button) view.findViewById(R.id.button_create);
        cancelB = (Button) view.findViewById(R.id.button_cancel_cita);



        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarHospital();
            }
        });

        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public  void registrarHospitalSQL()
    {
        ConexionSQLiteHelper conn = new  ConexionSQLiteHelper(getActivity(),"db_hospital",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        String insert="INSERT INTO "+Utilidades.TABLA_HOSPITAL+" ( "+Utilidades.CAMPO_NOMBRE+") VALUES ('"+mEditText.getText().toString()+"')" ;
        db.execSQL(insert);



        Toast.makeText(getActivity().getApplicationContext(),"id Registro completado " ,Toast.LENGTH_SHORT).show();
        db.close();
    }


    public void registrarHospital()
    {
        ConexionSQLiteHelper conn = new  ConexionSQLiteHelper(getActivity(),"db_hospital",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,mEditText.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_HOSPITAL,Utilidades.CAMPO_ID,values);
        Toast.makeText(getActivity().getApplicationContext(),"id Registro: "+ idResultante ,Toast.LENGTH_SHORT).show();
        db.close();

    }


}
