package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class login_Activity extends AppCompatActivity {

    ViewPager2 viewPager_login;

    TabLayout tab_login;

    fragment_login_activity_class adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Influence User");

        String[] modes = new String[]{"owner", "driver"};

        viewPager_login = findViewById(R.id.view_pager1);

        tab_login = findViewById(R.id.tab_layout);

        FragmentManager fragment = (FragmentManager) getSupportFragmentManager();

        adapter = new fragment_login_activity_class(fragment,getLifecycle());

        viewPager_login.setAdapter(adapter);

        new TabLayoutMediator(tab_login,viewPager_login,((tab,position)->tab.setText((modes[position])))).attach();

    }
}