package com.example.wheelsreputation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragment_login_activity_class extends FragmentStateAdapter {

    String[] modes = new String[]{"owner", "driver"};

    public fragment_login_activity_class(@NonNull FragmentManager fragmentManager , @NonNull Lifecycle lifecycle) {
        super(fragmentManager , lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){

            case 0: return new owner_login_Fragment();

            case 1: return new driver_login_Fragment();
        }
        return new owner_login_Fragment();
    }

    @Override
    public int getItemCount() {
        return modes.length;
    }
}
