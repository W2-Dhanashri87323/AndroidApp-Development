package com.dhanashri.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.dhanashri.app.R;
import com.dhanashri.app.entities.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText rollno, name, course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);

        rollno = findViewById(R.id.rollno);
        name = findViewById(R.id.name);
        course = findViewById(R.id.course);

    }

    public void save(View view) {
        Student student = new Student();
        student.setRollNo(Integer.parseInt(rollno.getText().toString()));
        student.setName(name.getText().toString());
        student.setCourse(course.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("student", student);
        setResult(1, intent);
        Toast.makeText(this, "Details saved", Toast.LENGTH_LONG).show();
        finish();

    }

    public void cancel() {
        finish();
    }
}