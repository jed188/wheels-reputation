package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import java.text.SimpleDateFormat;
import java.util.Date;


public class add_something_review_Fragment extends Fragment {

    RatingBar ratingBar;
    String ratingValue;
    View start_date, end_date ;


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_something_review_ , container , false);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


        ratingBar = view.findViewById(R.id.rating_value_textView2);

        start_date = view.findViewById(R.id.beginning_service_value_textView3);

        end_date = view.findViewById(R.id.end_service_value_textView3);

        String start_date_time_format = df. format(start_date);

        String end_date_time_format = df. format(start_date);

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
                    ratingBar.animate().scaleX(1.5f).scaleY(1.5f);

                }

                return true;
            }
        });

        return view;
    }
}