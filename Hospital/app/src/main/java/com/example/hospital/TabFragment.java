package com.example.hospital;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TabFragment extends Fragment {

    TextView textView;
    View view;
    private ListView listView;


    String[] typeItem = new String[]{"especialidades", "doctores", "pacientes"};
    String[] especialidades = new String[]{"spe1", "spe2", "spe3"};
    String[] doctores = new String[]{"dcotor1", "dcotor2", "dcotor3"};
    String[] pacientes = new String[]{"pacient1", "pacient2", "pacient3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab, container, false);
        return view;

    }

    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        int value = 2;
        listView = (ListView) getView().findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_2, android.R.id.text1, doctores);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener();
    }

}
