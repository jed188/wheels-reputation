package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_driver_activity extends AppCompatActivity {


    List<driver_history_class> driver_history_classList ;

    RecyclerView recyclerView;

    RecyclerView.Adapter mAdapter;

    RecyclerView.LayoutManager layoutManager;

    //global_variable globalVariable = (global_variable) this.getApplication();

    Intent intent = getIntent();

    FloatingActionButton add_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_driver);

        setTitle("Drivers Reputation");

      //  String driverName = intent.getStringExtra("value");



        driver_history_classList = global_variable.getDriver_history_classList();

        recyclerView = findViewById(R.id.recyclerView_driver_stories);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(driver_history_classList,this);

        recyclerView.setAdapter(mAdapter);

        add_review = findViewById(R.id.floatingActionButton);

        add_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Add_something.class);

                startActivity(intent);
            }
        });


    }


}