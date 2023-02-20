package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Driver_reputation_list extends AppCompatActivity {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    Adapter mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;

    FloatingActionButton add_driver;

    Intent intent;

    FrameLayout find_driver_layout;

    BottomNavigationView bottomNavigationView;


    //global_variable globalVariable = (global_variable) this.getApplication();


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_reputation_list);

        //declaration of attributes

        setTitle("Drivers Reputation");


        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new driver_reps_first()).commit();

        driver_history_classList = global_variable.getDriver_history_classList();

        recyclerReputation = findViewById(R.id.reputataion_list_recyclerView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        find_driver_layout= findViewById(R.id.find_driver_layout);

        //navigation bar set ups

        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {


            switch (item.getItemId()){

                case R.id.find_Driver_navigation:

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new MainActivity()).commit();
                    return true;

                case R.id.drivers_rating_navigation:

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new driver_reps_first()).commit();
                    return true;

                case R.id.spare_part_navigation:

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new add_something_review_Fragment()).commit();
                    return true;

                case R.id.mecanic_orkshop_navigation:

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new add_something_driver_Fragment()).commit();
                    return true;
            }

            return false;
        });


        //recycle view of the drivers reputation
/*
        recyclerReputation.setHasFixedSize(true);

        layoutManagerReputation = new LinearLayoutManager(getApplicationContext());

        recyclerReputation.setLayoutManager(layoutManagerReputation);

        mAdapterReputation = new adapter_reputation_list(getApplicationContext() , driver_history_classList);

        recyclerReputation.setAdapter(mAdapterReputation);


 */

        //floating button

        add_driver = findViewById(R.id.floatingActionButton2);

        add_driver.setOnClickListener(view -> {

            intent = new Intent(getApplicationContext() , Add_something.class);

            startActivity(intent);
        });

    }

    public void stolenBikeMethod(View view){

        intent = new Intent(getApplicationContext() , Stolen_bike_list.class);

        startActivity(intent);

    }



    public void find_driver(View view){

        intent = new Intent(getApplicationContext() , MainActivity.class);

        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_needed,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.username:
                // log the name of the user

                intent = new Intent(getApplicationContext(),login_Activity.class);

                startActivity(intent);

                return true;

            case R.id.contact_us:
                //the send a maessage to the installation team for attention



                return true;

            case R.id.suggestions:
                //logs a asuggestions could be merged with contact us and add a complaint window

                intent = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intent);

                return true;

            case R.id.logout:
                //logs the user out

                return true;

            case R.id.driver_review_menu:
                //add a review and an extra to drop in the right page

                intent = new Intent(getApplicationContext(),Add_something.class);

                startActivity(intent);

                return true;

            case R.id.new_driver_menu:
                //add a new driver and an extra to drop in the right page

                intent = new Intent(getApplicationContext(),Add_something.class);

                startActivity(intent);

                return true;

            case R.id.stolen_bike_menu:
                //add a stolen bike and an extra to drop in the right page

                intent = new Intent(getApplicationContext(),Add_something.class);

                startActivity(intent);

                return true;

            default:
                return false;
        }
    }
}