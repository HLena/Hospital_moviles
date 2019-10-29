package com.example.hospital;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TabFragment extends Fragment {

    TextView textView;
    View view;
    FloatingActionButton button_float;
    private ListView listView;

    String[] doctores = new String[]{"dcotor1", "dcotor2", "dcotor3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab, container, false);
        button_float = (FloatingActionButton) view.findViewById(R.id.button_float1);
        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogs();
            }
        });
        return view;

    }

    private void showFormsDialogs(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CreateDoctorFrag form = CreateDoctorFrag.newInstance("some title");
        form.show(ft, "fragment_create_doctor");
    }





}
