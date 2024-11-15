package com.dhanashri.fragmentapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tablayout;

    ViewPager2 viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tablayout=findViewById(R.id.toolbar);

        viewpager2=findViewById(R.id.viewpager2);

        new TabLayoutMediator(tablayout, viewpager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Contact via Phone").setIcon(R.drawable.contactphone);
                    case 1:
                        tab.setText("Contact via Email").setIcon(R.drawable.contactemail);
                }
            }
        }).attach();

        }

    }


