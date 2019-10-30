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


public class patients extends Fragment {

    ListView listItemView;
    FloatingActionButton button_float;

    String[] listItemsValue = new String[] {
            "paciete Android",
            "paciente Android",
            "paciente Android",


    };
    public patients() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_patients, container, false);

        listItemView = (ListView) rootView.findViewById(R.id.listViewPatients);
        button_float = (FloatingActionButton) rootView.findViewById(R.id.add_patient);

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
                showFormsDialogsPatient();
            }
        });

        return rootView;
    }

    private void showFormsDialogsPatient(){
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        CreatePatientFrag form = CreatePatientFrag.newInstance("some tilte");
        form.show(fm, "fragment_create_patient");
    }

}
