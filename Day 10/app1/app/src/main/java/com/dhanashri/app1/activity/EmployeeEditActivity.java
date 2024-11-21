package com.dhanashri.app1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app1.R;
import com.dhanashri.app1.entity.Employee;

public class EmployeeEditActivity extends AppCompatActivity {
    EditText editId, editName, editSalary;
    Employee employee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_edit);

        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editSalary = findViewById(R.id.editSalary);

        employee = (Employee) getIntent().getSerializableExtra("employee");
        editId.setText("" + employee.getId());
        editName.setText(employee.getName());
        editSalary.setText(String.valueOf(employee.getSalary()));
    }

    public void save(View view) {
     Employee newEmployee = new Employee();
     newEmployee.setId(Integer.parseInt(editId.getText().toString()));
     newEmployee.setName(editName.getText().toString());
     newEmployee.setSalary(Double.parseDouble(editSalary.getText().toString()));

     Intent intent = new Intent();
     intent.putExtra("employee", newEmployee);
     setResult(2, intent);
     finish();
    }

    public void cancel(View view) {
        finish();
    }

    }
