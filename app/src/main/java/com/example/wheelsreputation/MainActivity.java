package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    LinearLayout linLayout;
    Button stolenBikeButton, driverReputationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linLayout = findViewById(R.id.linear_layout_main_activity);

        stolenBikeButton = findViewById(R.id.button_stolen_bike);
        driverReputationButton = findViewById(R.id.button_reputation_list);


        setTitle("Drivers Reputation");





        /* <a href="https://www.flaticon.com/free-icons/edit" title="edit icons">Edit icons created by Pixel perfect - Flaticon</a>
        if you use the writing icon you must refrence the editor in the descriptionof your application as it is set to play store
         */
    }

    public void find_driver(View view){

        intent = new Intent(this,Find_driver_activity.class);

        startActivity(intent);

    }

    public void stolenBikeMethod(View view){

        intent = new Intent(MainActivity.this,Stolen_bike_list.class);

        startActivity(intent);

    }


    public void driverReputationMethod(View view){

        intent = new Intent(MainActivity.this,Driver_reputation_list.class);

        startActivity(intent);

    }


    public void shareApkFile () {

        //how to send apk file to another device and recreate the app

        // Get current ApplicationInfo to find .apk path
     /*   ApplicationInfo app = getApplicationContext().getApplicationInfo();
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



      */
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

            case R.id.logout:
                //logs the user out

                return true;

            default:
                return false;
        }

    }
}