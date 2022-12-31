package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_driver_activity extends AppCompatActivity {


    List<driver_history_class> driver_history_classList = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter mAdapter;

    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_driver);

        setTitle("Drivers Reputation");

        fillDriverHistoryList();

        recyclerView = findViewById(R.id.recyclerView_driver_stories);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(driver_history_classList,this);

        recyclerView.setAdapter(mAdapter);


    }

    private void fillDriverHistoryList() {

        driver_history_class history1 = new driver_history_class("he was a good driver","available",8);
        driver_history_class history2 = new driver_history_class("he stole my bike and didnt pay","available",1);
        driver_history_class history3 = new driver_history_class("we started well and later he missed payments and i had to fire him","available",6);
        driver_history_class history4 = new driver_history_class("he was a good driver and my bike broke then he found another bike to drive","available",8);

        driver_history_classList.addAll(Arrays.asList(history1,history2,history3,history4));

    }
}