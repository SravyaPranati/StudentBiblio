package com.example.studentbiblio.model;

import java.io.Serializable;

public class StudentInfo implements Serializable   {

    String RollNumber;
    Double CGPA;
    String Name;
    String Course;
    String Photo;
    public StudentInfo()
    {}

    public StudentInfo(String rollNumber) {

    }

    public StudentInfo(String rollNumber, Double CGPA, String name, String course, String photo) {
        RollNumber = rollNumber;
        this.CGPA = CGPA;
        Name = name;
        Course = course;
        Photo = photo;
    }

    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }

    public Double getCGPA() {
        return CGPA;
    }

    public void setCGPA(Double CGPA) {
        this.CGPA = CGPA;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String toString()
    {
        return  Name+" "+RollNumber+" "+Course+" "+Photo+" "+CGPA+"\n";

    }
}
