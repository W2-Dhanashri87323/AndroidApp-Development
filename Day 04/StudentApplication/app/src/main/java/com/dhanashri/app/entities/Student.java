package com.dhanashri.app.entities;

import com.dhanashri.app.R;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private int rollNo;
    private String course;
    private int imgage;

    public Student() {
        this("",0,"", R.drawable.ic_launcher_background);
    }

    public Student(String name, int rollNo, String course, int imgage) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.imgage = imgage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getImgage() {
        return imgage;
    }

    public void setImgage(int imgage) {
        this.imgage = imgage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", course='" + course + '\'' +
                ", imgage=" + imgage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

}
