package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


public class add_something_review_Fragment extends Fragment {

    RatingBar ratingBar;
    String ratingValue;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_something_review_ , container , false);

        ratingBar = view.findViewById(R.id.rating_value_textView2);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar , float v , boolean b) {

                ratingValue = String.valueOf(ratingBar.getRating());

            }

        });

        ratingBar.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view , MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){

                    ratingBar.getRating();

                }

                return true;
            }
        });

        return view;
    }
}