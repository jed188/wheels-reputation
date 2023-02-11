package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Driver_reputation_list extends AppCompatActivity {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    RecyclerView.Adapter mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;

    FloatingActionButton add_driver;

    Intent intent;

    BottomAppBar bottomAppBar;

    BottomNavigationView bottomNavigationView;

    //global_variable globalVariable = (global_variable) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_reputation_list);

        //declaration of attributes

        setTitle("Drivers Reputation");

        driver_history_classList = global_variable.getDriver_history_classList();

        recyclerReputation = findViewById(R.id.reputataion_list_recyclerView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setBackground(null);



        //recycle view of the drivers reputstion

        recyclerReputation.setHasFixedSize(true);

        layoutManagerReputation = new LinearLayoutManager(getApplicationContext());

        recyclerReputation.setLayoutManager(layoutManagerReputation);

        mAdapterReputation = new adapter_reputation_list(this , driver_history_classList);

        recyclerReputation.setAdapter(mAdapterReputation);

        add_driver = findViewById(R.id.floatingActionButton2);

        add_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(getApplicationContext() , Add_something.class);

                startActivity(intent);
            }
        });

    }

    public void stolenBikeMethod(View view){

        intent = new Intent(this , Stolen_bike_list.class);

        startActivity(intent);

    }



    public void find_driver(View view){

        intent = new Intent(this , MainActivity.class);

        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_first_page,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.StolenBike:
                // the stolen bike activity

                intent = new Intent(this,login_Activity.class);

                startActivity(intent);

                return true;

            case R.id.drivers_rating:
                //the reputation activity

                intent = new Intent(this,Add_something.class);

                startActivity(intent);

                return true;

            case R.id.spare_part:
                //activity to sell part

                intent = new Intent(this,MainActivity.class);

                startActivity(intent);

            case R.id.mecanic_orkshop:
                //logs the user out

                return true;

            default:
                return false;
        }
    }
}