package com.dhanashri.app1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app1.R;
import com.dhanashri.app1.entity.Employee;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView textId,textName,textSalary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        textId = findViewById(R.id.textId);
        textName = findViewById(R.id.textName);
        textSalary = findViewById(R.id.textSalary);

        Intent intent = getIntent();
        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        textId.setText(""+employee.getId());
        textName.setText(employee.getName());
        textSalary.setText(String.valueOf(employee.getSalary()));

    }
}
