package com.dhanashri.app1.activity;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app1.R;
import com.dhanashri.app1.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Employee> employeeList;

    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "dhanu", 5000.0));
        employeeList.add(new Employee(2, "manu", 6000.0));
        employeeList.add(new Employee(3, "chinu", 7000.0));

        recyclerView = findViewById(R.id.recyclerView);
        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    }

    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == 1) {
                Employee employee = (Employee) o.getData().getSerializableExtra("employee");
                employeeList.add(employee);
                adapter.notifyDataSetChanged();
            }
            if (o.getResultCode() == 2) {
                Employee employee = (Employee) o.getData().getSerializableExtra("employee");
                employeeList.remove(employee);
                employeeList.add(employee);
                adapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add").setIcon(R.drawable.add).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Add")) {
            Intent intent = new Intent(this, EmployeeAddActivity.class);
            launcher.launch(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}