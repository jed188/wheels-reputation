package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Driver_reputation_list extends AppCompatActivity {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    RecyclerView.Adapter mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;

    //global_variable globalVariable = (global_variable) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_reputation_list);

        setTitle("Drivers Reputation");

        driver_history_classList = global_variable.getDriver_history_classList();

        recyclerReputation = findViewById(R.id.reputataion_list_recyclerView);

        recyclerReputation.setHasFixedSize(true);

        layoutManagerReputation = new LinearLayoutManager(getApplicationContext());

        recyclerReputation.setLayoutManager(layoutManagerReputation);

        mAdapterReputation = new adapter_reputation_list(this , driver_history_classList);

        recyclerReputation.setAdapter(mAdapterReputation);

    }
}