package com.example.wheelsreputation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;


public class driver_reps_first extends Fragment {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    RecyclerView.Adapter mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;




    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_driver_reps_first , container , false);


        recyclerReputation = view.findViewById(R.id.reputataion_list_recyclerView);


        //recycle view of the drivers reputation

        recyclerReputation.setHasFixedSize(true);

        layoutManagerReputation = new LinearLayoutManager(getContext());

        recyclerReputation.setLayoutManager(layoutManagerReputation);

        mAdapterReputation = new adapter_reputation_list(getContext() , driver_history_classList);

        recyclerReputation.setAdapter(mAdapterReputation);


        return view;
                }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //declaration of attributes



        getActivity().setTitle("Drivers Reputation");

        driver_history_classList = global_variable.getDriver_history_classList();


    }



}