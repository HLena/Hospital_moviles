package com.example.hospital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class CreatePatientFrag extends Fragment {
    private EditText input1, input2, input3;
    private Button createB, cancelB;
    //private OnFragmentInteractionListener mListener;

    public CreatePatientFrag() {
        // Required empty public constructor
    }
    public static CreatePatientFrag newInstance(String title) {
        CreatePatientFrag fragment = new CreatePatientFrag();
        Bundle args = new Bundle();
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
        input1 = (EditText) view.findViewById(R.id.name_doctor);
        input2 = (EditText) view.findViewById(R.id.adress_doctor);
        input3 = (EditText) view.findViewById(R.id.telf_doctor);
        createB = (Button) view.findViewById(R.id.button_create);
        cancelB = (Button) view.findViewById(R.id.button_cancel);
        // Fetch arguments from bundle and set title


    }



}
