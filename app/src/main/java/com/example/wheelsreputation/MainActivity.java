package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Drivers Reputation");
    }

    public void find_driver(View view){

        intent = new Intent(this,Find_driver_activity.class);

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

                return true;

            case R.id.add_something:
                //send to an activity with a compsed window to choose between the 3 toggle options

                return true;

            case R.id.logout:
                //logs the user out

                return true;

            default:
                return false;
        }

    }
}