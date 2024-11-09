package com.dhanashri.hybridproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.hybridproject.R;
import com.dhanashri.hybridproject.entities.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    Context context;

    List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_vh,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.empId.setText("EmployeeID :: " + employeeList.get(position).getEmpId());
        holder.empName.setText("Employee Name :: " + employeeList.get(position).getEmpName());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView empId,empName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            empId=itemView.findViewById(R.id.empId);
            empName=itemView.findViewById(R.id.empName);
        }
    }
}
