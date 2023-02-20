package com.example.wheelsreputation;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MainActivity extends Fragment {

    Intent intent;
    Button stolenBikeButton, driverReputationButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_main, container,false);

    }

    @Override
    public void onStart() {
        super.onStart();

        stolenBikeButton = getView().findViewById(R.id.button_stolen_bike);
        driverReputationButton = getView().findViewById(R.id.button_reputation_list);




        /* <a href="https://www.flaticon.com/free-icons/edit" title="edit icons">Edit icons created by Pixel perfect - Flaticon</a>
        if you use the writing icon you must refrence the editor in the descriptionof your application as it is set to play store
         */
    }

    public void find_driver(View view){

        intent = new Intent(getActivity(),Find_driver_activity.class);

        startActivity(intent);

    }

    public void stolenBikeMethod(View view){

        intent = new Intent(getActivity(),Stolen_bike_list.class);

        startActivity(intent);

    }


    public void driverReputationMethod(View view){

        intent = new Intent(getActivity(),driver_reps_first.class);

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


}