package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class add_something_class extends FragmentStateAdapter {

    public add_something_class(@NonNull FragmentManager fragmentManager , @NonNull Lifecycle lifecycle) {
        super(fragmentManager , lifecycle);
    }

    String[] titles = new String[]{"Driver","Review","Stolen Bike"};

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position) {

            case 0:
                return new add_something_driver_Fragment();

            case 1:
                return new add_something_review_Fragment();

            case 2:
                return new add_something_stolen_bike_Fragment();
        }

        return new add_something_review_Fragment();

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
