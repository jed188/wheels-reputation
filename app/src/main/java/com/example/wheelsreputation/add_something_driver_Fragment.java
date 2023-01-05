package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;


public class add_something_driver_Fragment extends Fragment {


    String[] choice = {"Yes","No"};
    AutoCompleteTextView autocomplete;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_something_driver_ , container , false);

        autocomplete = view.findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(),R.layout.dropdown,choice);

        autocomplete.setAdapter(adapter);

        return view;
    }
}