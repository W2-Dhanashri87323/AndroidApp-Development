package com.dhanashri.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> countrylist;
    TextView title;
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        countrylist=new ArrayList<>();
        Collections.addAll(countrylist,"India","China","Japan","Russia");

        title=findViewById(R.id.title);
        recyclerView=findViewById(R.id.recyclerViewId);

        countryAdapter=new CountryAdapter(this,countrylist);

        recyclerView.setAdapter(countryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}