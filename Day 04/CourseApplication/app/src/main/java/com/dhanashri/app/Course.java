package com.dhanashri.app;

import java.io.Serializable;

public class Course implements Serializable {
    private int courseId;
    private String courseName;

    private String courseDesc;

    private Double fees;

    private int courseImg;


    public Course() {
    }

    public Course(int courseId, String courseName, String courseDesc, Double fees, int courseImg) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.fees = fees;
        this.courseImg = courseImg;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public Double getFees() {
        return fees;
    }

    public int getCourseImg() {
        return courseImg;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public void setCourseImg(int courseImg) {
        this.courseImg = courseImg;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", fees=" + fees +
                ", courseImg=" + courseImg +
                '}';
    }
}
