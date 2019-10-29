package com.example.hospital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Doctors extends Fragment {

    ListView listItemView;
    FloatingActionButton button_float;

    String[] listItemsValue = new String[] {
            "Docotr Android",
            "Docotr Android",
            "Docotr Android",


    };
    public Doctors() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);

        listItemView = (ListView) rootView.findViewById(R.id.listViewDoctors);
        button_float = (FloatingActionButton) rootView.findViewById(R.id.add_doctor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listItemView.setAdapter(adapter);

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
