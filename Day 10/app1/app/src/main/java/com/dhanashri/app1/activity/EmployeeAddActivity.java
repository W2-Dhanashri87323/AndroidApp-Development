package com.dhanashri.app1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app1.R;
import com.dhanashri.app1.entity.Employee;

public class EmployeeAddActivity extends AppCompatActivity {

    EditText editId, editName, editSalary;
    Employee employee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);

        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editSalary = findViewById(R.id.editSalary);

    }

    public void save(View view) {
        employee = new Employee();
        employee.setId(Integer.parseInt(editId.getText().toString()));
        employee.setName(editName.getText().toString());
        employee.setSalary(Double.parseDouble(editSalary.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("employee", employee);
        setResult(1, intent);
        finish();


    }

    public void cancel(View view) {
        finish();
    }

}
