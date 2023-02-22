package com.example.wheelsreputation;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MainActivity extends Fragment {

    Intent intent,intent2,intent1 ;
    Button stolenBikeButton, driverReputationButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_main, container,false);


        stolenBikeButton = view.findViewById(R.id.button_stolen_bike);
        driverReputationButton = view.findViewById(R.id.button_reputation_list);


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();




        /* <a href="https://www.flaticon.com/free-icons/edit" title="edit icons">Edit icons created by Pixel perfect - Flaticon</a>
        if you use the writing icon you must refrence the editor in the descriptionof your application as it is set to play store
         */
    }







}