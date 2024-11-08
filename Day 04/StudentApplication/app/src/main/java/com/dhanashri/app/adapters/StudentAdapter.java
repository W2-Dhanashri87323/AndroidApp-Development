package com.dhanashri.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app.R;
import com.dhanashri.app.activities.StudentDetailsActivity;
import com.dhanashri.app.activities.StudentEditActivity;
import com.dhanashri.app.entities.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    Context cntx;

    List<Student> studentList;

    ActivityResultLauncher launcher;

    public StudentAdapter(Context cntx, List<Student> studentList, ActivityResultLauncher launcher) {
        this.cntx = cntx;
        this.studentList = studentList;
        this.launcher = launcher;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cntx).inflate(R.layout.view_holder, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText("name : " + studentList.get(position).getName());
        holder.rollno.setText("RollNo : " + studentList.get(position).getRollNo());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, rollno;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            rollno = itemView.findViewById(R.id.rollno);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(cntx, "Displaying Details", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(cntx, StudentDetailsActivity.class);
                    intent.putExtra("student", studentList.get(getAdapterPosition()));
                    cntx.startActivity(intent);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(cntx, view);
                    popupMenu.getMenu().add("edit");
                    popupMenu.getMenu().add("delete");
                    popupMenu.show();

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if(item.getTitle().equals("edit")){
                                Intent intent = new Intent(cntx, StudentEditActivity.class);
                                intent.putExtra("student", studentList.get(getAdapterPosition()));
                                launcher.launch(intent);
                                notifyDataSetChanged();
                            }

                            if(item.getTitle().equals("delete")){
                                studentList.remove(getAdapterPosition());
                                notifyDataSetChanged(); //for refresh list
                            }
                            return false;
                        }
                    });

                    return false;
                }
            });
        }
    }
}
