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

import java.util.List;

public class Driver_reputation_list extends AppCompatActivity {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    RecyclerView.Adapter mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;

    Intent intent;

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

    public void stolenBikeMethod(View view){

        intent = new Intent(this , Stolen_bike_list.class);

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
            case R.id.username:
                // define the username of the user and set text to his name

                intent = new Intent(this,login_Activity.class);

                startActivity(intent);

                return true;

            case R.id.add_something:
                //send to an activity with a compsed window to choose between the 3 toggle options

                intent = new Intent(this,Add_something.class);

                startActivity(intent);

                return true;

            case R.id.search:

                intent = new Intent(this,MainActivity.class);

                startActivity(intent);

            case R.id.logout:
                //logs the user out

                return true;

            default:
                return false;
        }
    }
}