package com.dhanashri.app1.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app1.R;
import com.dhanashri.app1.entity.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    Context context;
    List<Employee> employeeList;
    ActivityResultLauncher launcher;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    public EmployeeAdapter(Context context, List<Employee> employeeList, ActivityResultLauncher launcher) {
        this.context = context;
        this.employeeList = employeeList;
        this.launcher = launcher;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textId.setText("" + employeeList.get(position).getId());
        holder.textName.setText(employeeList.get(position).getName());
        holder.textSalary.setText(String.valueOf(employeeList.get(position).getSalary()));

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView textId, textName, textSalary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.textId);
            textName = itemView.findViewById(R.id.textName);
            textSalary = itemView.findViewById(R.id.textSalary);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, EmployeeDetailsActivity.class);
            intent.putExtra("employee", employeeList.get(getAdapterPosition()));
            context.startActivity(intent);

        }

        @Override
        public boolean onLongClick(View v) {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.getMenu().add("edit");
            popupMenu.getMenu().add("delete");
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getTitle().equals("edit")) {
                    Intent intent = new Intent(context, EmployeeEditActivity.class);
                    intent.putExtra("employee", employeeList.get(getAdapterPosition()));
                    launcher.launch(intent);
                }
                if (item.getTitle().equals("delete")) {
                    employeeList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
                return false;
            });

            return false;
        }
    }
}
