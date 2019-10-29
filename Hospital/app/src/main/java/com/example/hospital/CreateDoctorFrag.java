package com.example.hospital;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


public class CreateDoctorFrag extends DialogFragment {
    private EditText input1, input2, input3;
    private Button createB, cancelB;

    public CreateDoctorFrag() {
        // Required empty public constructor
    }

    public static CreateDoctorFrag newInstance(String title) {
        CreateDoctorFrag fragment = new CreateDoctorFrag();
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
        return inflater.inflate(R.layout.fragment_create_doctor, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        input1 = (EditText) view.findViewById(R.id.name_doctor);
        input2 = (EditText) view.findViewById(R.id.adress_doctor);
        input3 = (EditText) view.findViewById(R.id.telf_doctor);
        createB = (Button) view.findViewById(R.id.button_create);
        cancelB = (Button) view.findViewById(R.id.button_cancel);
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
}
