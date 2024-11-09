package com.dhanashri.hybridproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.hybridproject.R;
import com.dhanashri.hybridproject.entities.Employee;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText addEmpId,addEmpName,addEmpSal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_employee);

        addEmpId=findViewById(R.id.addEmpId);
        addEmpName=findViewById(R.id.addEmpName);
        addEmpSal=findViewById(R.id.addEmpSal);
    }

    public void save(){
        Employee employee=new Employee();
        employee.setEmpId(Integer.parseInt(addEmpId.getText().toString()));
        employee.setEmpName(addEmpName.getText().toString());
        employee.setEmpSalary(Double.parseDouble(addEmpSal.getText().toString()));

        Intent intent= new Intent();
        intent.putExtra("emp",employee);
        setResult(1,intent);
    }

    public void cancel(){
        finish();
    }
}