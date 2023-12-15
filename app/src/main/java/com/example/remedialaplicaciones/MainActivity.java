package com.example.remedialaplicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.remedialaplicaciones.adapter.ContactoAdapter;
import com.example.remedialaplicaciones.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Contacto> listcon = new ArrayList<>();
        listcon.add(new Contacto("Leo","16","Male","Skateboarding"));
        listcon.add(new Contacto("Sam","19","Nonbinary","Knitting"));
        listcon.add(new Contacto("Jade","17","Female","Drawing"));
        listcon.add(new Contacto("Marcus","14","Male","Theater"));
        listcon.add(new Contacto("Abby","15","Female","Singing"));
        ContactoAdapter ca = new ContactoAdapter(listcon);
        RecyclerView rv= findViewById(R.id.recyclerbox);
        rv.setAdapter(ca);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}