package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.window.SplashScreen;

import com.google.android.material.textfield.TextInputLayout;


public class add_something_driver_Fragment extends Fragment {


    String[] choice = {"Yes","No"};
    Spinner spinner;
    Button save;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_something_driver_ , container , false);

        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter adapter =  new ArrayAdapter(getContext(),R.layout.dropdown,choice);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);


        save = view.findViewById(R.id.button_add_driver);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i ("itemVelue",spinner.getSelectedItem().toString());
            }
        });


        return view;
    }
}