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


public class Appointment extends Fragment {

    ListView listItemView;
    FloatingActionButton button_float;

    String[] listItemsValue = new String[] {
            "cita 1",
            "cita 2",
            "cita 3",
    };
    public Appointment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_appointment, container, false);

        listItemView = (ListView) rootView.findViewById(R.id.listViewAppointments);
        button_float = (FloatingActionButton) rootView.findViewById(R.id.add_appointment);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_2, android.R.id.text1, listItemsValue);
        listItemView.setAdapter(adapter);

        button_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormsDialogsAppointment();
            }
        });
        return rootView;
    }

    private void showFormsDialogsAppointment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CreateBookingFrag form = CreateBookingFrag.newInstance("some title");
        form.show(ft, "fragment_create_booking");


    }


}
