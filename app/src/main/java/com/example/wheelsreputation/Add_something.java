package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Add_something extends AppCompatActivity {

    String[] titles = new String[]{"Driver","Review","Stolen Bike"};

    add_something_class adapter_Class;

    ViewPager2 view_Pager_add_something;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_something);

        setTitle("Add a Driver/ Stolen bike/ Review");

        FragmentManager manager = getSupportFragmentManager();

        adapter_Class = new add_something_class(manager,getLifecycle());

        tabLayout = findViewById(R.id.tabLayout_add_something);

        view_Pager_add_something = findViewById(R.id.view_Pager2);

        view_Pager_add_something.setAdapter(adapter_Class);

        new TabLayoutMediator(tabLayout,view_Pager_add_something,((tab , i) -> tab.setText(titles[i]))).attach();

    }
}