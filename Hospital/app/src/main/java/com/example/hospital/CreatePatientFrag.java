package com.example.hospital;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CreatePatientFrag extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public CreatePatientFrag() {
        // Required empty public constructor
    }
    public static CreatePatientFrag newInstance(String param1, String param2) {
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



}
