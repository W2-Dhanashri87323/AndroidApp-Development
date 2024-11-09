package com.dhanashri.hybridproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.dhanashri.hybridproject.R;
import com.dhanashri.hybridproject.adapter.FragmentAdapter;
import com.dhanashri.hybridproject.entities.Employee;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    TabLayout tabLayout;

    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;

    List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);

        viewPager2 = findViewById(R.id.viewpager2);

        fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Employees").setIcon(R.drawable.employee);
                        break;
                    case 1:
                        tab.setText("Countries").setIcon(R.drawable.country);
                        break;
                }

            }
        }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Employee");
        menu.add("Add Country");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Add Employee")) {
            Intent intent = new Intent(this, AddEmployeeActivity.class);
            startActivity(intent);

        }

        if (item.getTitle().equals("Add Country")) {
            Intent intent = new Intent(this, AddCountryActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}