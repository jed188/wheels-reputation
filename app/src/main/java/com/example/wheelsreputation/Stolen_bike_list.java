package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Stolen_bike_list extends AppCompatActivity {

    RecyclerView recyclerView_stolen_bike;

    RecyclerView.Adapter mAdapter_stolen_bike;

    RecyclerView.LayoutManager layoutManager_stolen_bike;

    List<stolen_bike_class> stolen_bike_classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stolen_bike_list);

        setTitle("Stolen Bikes");

        stolen_bike_classList = global_variable.getStolen_bike_classList();

        recyclerView_stolen_bike = findViewById(R.id.stolen_bike_recycleView);

        recyclerView_stolen_bike.setHasFixedSize(true);

        layoutManager_stolen_bike = new LinearLayoutManager(this);

        recyclerView_stolen_bike.setLayoutManager(layoutManager_stolen_bike);

        mAdapter_stolen_bike = new Adapter_Stolen_bike(stolen_bike_classList,this);

        recyclerView_stolen_bike.setAdapter(mAdapter_stolen_bike);

    }
}