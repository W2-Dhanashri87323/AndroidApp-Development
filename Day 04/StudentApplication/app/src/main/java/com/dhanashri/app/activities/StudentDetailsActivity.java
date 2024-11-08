package com.dhanashri.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.dhanashri.app.R;
import com.dhanashri.app.entities.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView name, rollno, course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        rollno = findViewById(R.id.rollno);
        course = findViewById(R.id.course);

        Intent intent = getIntent();
        Student obj =(Student) intent.getSerializableExtra("student");

        image.setImageResource(obj.getImgage());
        name.setText("Student Name ::  "+obj.getName());
        rollno.setText("Student RollNo ::  "+obj.getRollNo());
        course.setText("Student Course ::  "+obj.getCourse());
    }
}