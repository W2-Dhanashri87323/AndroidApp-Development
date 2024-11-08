package com.dhanashri.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhanashri.app.R;
import com.dhanashri.app.adapters.StudentAdapter;
import com.dhanashri.app.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> launcher;
    Toolbar toolbar;

    RecyclerView recyclerView;

    List<Student> studentList;

    StudentAdapter studentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycleView);

        studentList = new ArrayList<>();
        studentList.add(new Student("DHANASHRI", 1, "CST", R.drawable.dhanu));
        studentList.add(new Student("RAJVARDHAN", 2, "CST", R.drawable.ic_launcher_background));


        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == 1) { // for "add" case
                    Student student = (Student) result.getData().getSerializableExtra("student");
                    studentList.add(student);
                    studentAdapter.notifyDataSetChanged();
                } else if (result.getResultCode() == 2) { // for "edit" case
                    Student updatedStudent = (Student) result.getData().getSerializableExtra("student");
                    updateStudentInList(updatedStudent);

                }
            }

            private void updateStudentInList(Student updatedStudent) {
                if (updatedStudent == null || studentList == null) {
                    return; // Exit if updatedStudent or studentList is null
                }

                for (int i = 0; i < studentList.size(); i++) {
                    // Compare roll numbers to find the matching student
                    if (studentList.get(i).getRollNo() == updatedStudent.getRollNo()) {
                        studentList.set(i, updatedStudent); // Replace with updated student
                        studentAdapter.notifyItemChanged(i); // Notify adapter about the change
                        break;
                    }
                }
            }

        });

        studentAdapter=new StudentAdapter(this,studentList,launcher);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Student");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"add clicked" ,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,AddStudentActivity.class);
        launcher.launch(intent);

        return super.onOptionsItemSelected(item);
    }
}