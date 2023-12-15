package com.example.remedialaplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpecificInfo extends AppCompatActivity {
    TextView na,ag,gen,hob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_info);
        Intent info = getIntent();
        String name = info.getStringExtra("name");
        String age = info.getStringExtra("age");
        String gender = info.getStringExtra("gender");
        String hobby = info.getStringExtra("hobby");
        na = findViewById(R.id.name);
        ag = findViewById(R.id.age);
        gen = findViewById(R.id.gender);
        hob = findViewById(R.id.hobby);
        na.setText(name);
        ag.setText(age);
        gen.setText(gender);
        hob.setText(hobby);
    }
}