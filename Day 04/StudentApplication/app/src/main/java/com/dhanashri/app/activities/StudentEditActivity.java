package com.dhanashri.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.dhanashri.app.R;
import com.dhanashri.app.entities.Student;

public class StudentEditActivity extends AppCompatActivity {

    EditText editName, editCourse;
    TextView textRollNo;

    Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_edit);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("student");

        editName = findViewById(R.id.editName);
        editCourse = findViewById(R.id.editCourse);
        textRollNo = findViewById(R.id.textRollNo);


        editName.setText(student.getName());
        editCourse.setText(student.getCourse());
        textRollNo.setText("ID : " + student.getRollNo());
    }

    public void save(View view) {
        Student newStudent=new Student();
        newStudent.setRollNo(student.getRollNo());
        newStudent.setName(editName.getText().toString());
        newStudent.setCourse(editCourse.getText().toString());

        Intent intent=new Intent();
        intent.putExtra("student", newStudent);
        setResult(2,intent);
        finish();
    }

    public void cancel(View view){
        finish();
    }
}