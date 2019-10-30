package com.example.hospital;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.hospital.utilidades.Utilidades;

public class CreatePatientFrag extends DialogFragment {
    private EditText input1, input2, input3;
    private Button createB, cancelB;
    private Spinner spinner;
    //private OnFragmentInteractionListener mListener;

    public CreatePatientFrag() {
        // Required empty public constructor
    }
    public static CreatePatientFrag newInstance(String title) {
        CreatePatientFrag fragment = new CreatePatientFrag();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_patient, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        //return inflater.inflate(R.layout.fragment_create_patient, container, false);
        String[] type_patient = {"Continuo","No Continuo"};
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, type_patient));
        input1 = (EditText) view.findViewById(R.id.name_doctor1);
        input2 = (EditText) view.findViewById(R.id.adress_doctor1);
        input3 = (EditText) view.findViewById(R.id.telf_doctor1);
        createB = (Button) view.findViewById(R.id.button_create1);
        cancelB = (Button) view.findViewById(R.id.button_cancel1);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        input1.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //accion botones
        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarPacienteSQL();
                Toast.makeText(getActivity(), "creado", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public  void registrarPacienteSQL()
    {

        Bundle res= getActivity().getIntent().getExtras();
        String hospital_id ="";

        if(res!=null)
        {
            hospital_id=res.getString("hospital_id");
        }


        ConexionSQLiteHelper conn = new  ConexionSQLiteHelper(getActivity(),"db_hospital",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        Integer continuo=0;
        if(spinner.getSelectedItem().toString()=="Continuo")
            continuo=1;
        else
            continuo=0;

        String insert="INSERT INTO "+ Utilidades.TABLA_PACIENTE+" ( "+Utilidades.CAMPO_NOMBRE_PACIENTE+" , "+Utilidades.CAMPO_ID_HOSPITAL_PACIENTE+") VALUES ('"+input1.getText().toString()+"','"+hospital_id+"')" ;
        db.execSQL(insert);
        db.close();

    }
}
