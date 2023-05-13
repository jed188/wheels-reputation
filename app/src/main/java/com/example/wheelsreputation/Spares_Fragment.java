package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class Spares_Fragment extends Fragment {

    RecyclerView recyclerView_spares;
    RecyclerView.Adapter sparesAdapter;
    RecyclerView.LayoutManager sparesLayoutManager;
    List<spare_parts_class> spare_parts_class1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_spares_ , container , false);

         spare_parts_class1 = global_variable.getSpare_parts_classList();

         recyclerView_spares = view.findViewById(R.id.recyclerView_spares);
         recyclerView_spares.setHasFixedSize(true);
         sparesLayoutManager = new LinearLayoutManager(getActivity());
         recyclerView_spares.setLayoutManager(sparesLayoutManager);
         sparesAdapter = new Adapter_Spares(spare_parts_class1,getContext());
         recyclerView_spares.setAdapter(sparesAdapter);

         return view;

    }
}