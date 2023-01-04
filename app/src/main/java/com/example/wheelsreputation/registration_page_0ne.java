package com.example.wheelsreputation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registration_page_0ne extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page0ne);

        button = findViewById(R.id.button3);

    }

    public void next_activity (View view){

        Intent intent = new Intent(this,registration_screen_2.class);

        startActivity(intent);

    }

}