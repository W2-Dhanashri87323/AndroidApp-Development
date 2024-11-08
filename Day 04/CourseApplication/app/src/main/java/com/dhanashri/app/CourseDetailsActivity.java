package com.dhanashri.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;


public class CourseDetailsActivity extends AppCompatActivity {

   TextView cNameID,cDescID,cFeesID;

   ImageView imgId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.course_details);

        imgId=findViewById(R.id.imgId);
        cNameID=findViewById(R.id.cNameID);
        cDescID=findViewById(R.id.cDescID);
        cFeesID=findViewById(R.id.cFeesID);

        Intent intent= getIntent();
        Course obj = (Course) intent.getSerializableExtra("course");

        imgId.setImageResource(obj.getCourseImg());
        cNameID.setText(obj.getCourseName());
        cDescID.setText(obj.getCourseDesc());
        cFeesID.setText(""+obj.getFees());

    }
}