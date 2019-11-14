package com.example.hospital;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.hospital.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.Calendar;


public class CreateBookingFrag extends DialogFragment {

    private EditText input1, input2, input3;
    private Button createB, cancelB;

    ArrayList<String> listDoctorsIds = new ArrayList<String>();
    ArrayList<String> listDoctorsNames = new ArrayList<String>();

    String hospital_name ="";
    String hospital_id ="";

    String selected_doctor_id="";
    ConexionSQLiteHelper conn;


    Spinner doctorSpinner;

    private static final String TAG = "Main Activity";

    private DatePickerDialog.OnDateSetListener mDataSetListener;


    public static CreateBookingFrag newInstance(String title) {
        CreateBookingFrag fragment = new CreateBookingFrag();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    public CreateBookingFrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_booking, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        input1 = (EditText) view.findViewById(R.id.input_date);

        input1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.
                        Theme_Holo_Dialog_MinWidth,
                        mDataSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=month+"/"+day+"/"+year;
                input1.setText(date );

            }
        };

        input2 = (EditText) view.findViewById(R.id.input_bed);
        input3 = (EditText) view.findViewById(R.id.input_room);
        createB = (Button) view.findViewById(R.id.button_create_cita);
        cancelB = (Button) view.findViewById(R.id.button_cancel_cita);

        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


        Bundle res= getActivity().getIntent().getExtras();

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

                listDoctorsIds.add(idDoctor);
                listDoctorsNames.add(name);
                cursor.moveToNext();
            }
        }




        // Spinner with results of DB
        doctorSpinner = (Spinner)view.findViewById(R.id.select_doctor_spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, listDoctorsNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doctorSpinner.setAdapter(dataAdapter);

        doctorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                selected_doctor_id = listDoctorsIds.get(arg2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });



        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCitaSQL();
                dismiss();
                getActivity().finish();
                startActivity(getActivity().getIntent())    ;
            }
        });

        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });





    }

    public  void registrarCitaSQL()
    {
        ConexionSQLiteHelper conn = new  ConexionSQLiteHelper(getActivity(),"db_hospital",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        Bundle res= getActivity().getIntent().getExtras();


        String hospital_id ="";
        String patient_id ="";

        if(res!=null)
        {
            hospital_id=res.getString("hospital_id");
            patient_id=res.getString("patient_id");
        }


        String insert="INSERT INTO "+Utilidades.TABLA_CITA+" ( "+Utilidades.CAMPO_ID_HOSPITAL_CITA+","+
                                                                Utilidades.CAMPO_ID_PACIENTE_CITA+","+
                                                                Utilidades.CAMPO_ID_MEDICO_CITA+","+
                                                                Utilidades.CAMPO_FECHA_CITA+","+
                                                                Utilidades.CAMPO_NUM_HABITACION_CITA+","+
                                                                Utilidades.CAMPO_NUM_CAMA_CITA+") " +
                "VALUES ('"+hospital_id+"','"+patient_id+"','"+selected_doctor_id+"' ,'"+input1.getText().toString()+"' , '"+input3.getText().toString()+"','"+input2.getText().toString()+"')" ;
        db.execSQL(insert);
        db.close();

    }



}
