package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(HospitalsActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), info_Item.class);
                String itemClicked = listItemsValue[position];
                intent.putExtra("item_name", itemClicked);
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
