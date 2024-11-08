package com.dhanashri.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    Context cntx;

    List<Course> courseList;

    public CourseAdapter(Context cntx, List<Course> courseList) {
        this.cntx = cntx;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cntx).inflate(R.layout.view_holder,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Course c = courseList.get(position);
    holder.courseName.setText(c.getCourseName());
    holder.courseFees.setText("" + c.getFees());
    holder.img.setImageResource(c.getCourseImg());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView courseName, courseFees;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName=itemView.findViewById(R.id.courseNameId);
            courseFees=itemView.findViewById(R.id.courseFeesId);
            img=itemView.findViewById(R.id.courseImgId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(cntx,CourseDetailsActivity.class);
                    intent.putExtra("course",courseList.get(getAdapterPosition()));
                    cntx.startActivity(intent);
                }
            });
        }
    }
}
