package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.List;

public class Driver_reputation_list extends AppCompatActivity {

    List<driver_history_class> driver_history_classList;

    RecyclerView recyclerReputation;

    FloatingActionButton add_driver;

    Intent intent,intent1,intent2;

    Button stolenBikeButton, driverReputationButton;

    FrameLayout find_driver_layout;

    BottomNavigationView bottomNavigationView;


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

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new Spares_Fragment()).commit();
                    return true;

                case R.id.mecanic_orkshop_navigation:

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1,new add_something_driver_Fragment()).commit();
                    return true;
            }

            return false;
        });



        //floating button

        add_driver = findViewById(R.id.floatingActionButton2);

        add_driver.setOnClickListener(view -> {

            intent = new Intent(getApplicationContext() , Add_something.class);

            startActivity(intent);
        });

    }

        //onclick methods for buttons

    public void stolenBikeMethod(View view){

        intent = new Intent(getApplicationContext() , Stolen_bike_list.class);

        startActivity(intent);

    }

    public void find_driver(View view){

        intent1 = new Intent(getApplicationContext(),Find_driver_activity.class);

        startActivity(intent1);

    }

    public void driverReputationMethod(View view){

        intent2 = new Intent(getApplicationContext(),Driver_reputation_list.class);

        startActivity(intent2);

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

            case R.id.share_menu:
                //distribute the application

                shareApkFile ();

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


    //share my app code

    public void shareApkFile () {

        //how to send apk file to another device and recreate the app

        // Get current ApplicationInfo to find .apk path
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;

        Intent intent = new Intent(Intent.ACTION_SEND);

// MIME of .apk is "application/vnd.android.package-archive".
// but Bluetooth does not accept this. Let's use "*1/*" instead.
        intent.setType("*1/*");

// Only use Bluetooth to send .apk
        intent.setPackage("com.android.bluetooth");

// Append file and send Intent
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
        startActivity(Intent.createChooser(intent, "Share app"));


    }

}