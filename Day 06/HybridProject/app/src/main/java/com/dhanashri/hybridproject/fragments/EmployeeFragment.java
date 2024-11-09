package com.dhanashri.hybridproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhanashri.hybridproject.R;
import com.dhanashri.hybridproject.adapter.EmployeeAdapter;
import com.dhanashri.hybridproject.entities.Employee;

import java.util.ArrayList;
import java.util.List;


public class EmployeeFragment extends Fragment {

    RecyclerView recyclerView;
    List<Employee> employeeList;

    EmployeeAdapter employeeAdapter;

    public EmployeeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeList=new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        employeeList.add(new Employee(101, "Rajvardhan Patil", 75000.0));
        employeeList.add(new Employee(102, "Ananya Sharma", 68000.0));
        employeeList.add(new Employee(103, "Amitabh Mishra", 82000.0));
        employeeList.add(new Employee(104, "Priya Kaur", 72000.0));
        employeeList.add(new Employee(105, "Rakesh Nair", 70000.0));


        recyclerView = view.findViewById(R.id.emp_recycler);

        employeeAdapter=new EmployeeAdapter(getContext(),employeeList);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

    }
}