package com.example.studentbiblio.model;

import java.io.Serializable;

public class FacultyInfo implements Serializable {
    String FacultyId;
    String FacultyName;
    String Designation;
    String Photo;

    public FacultyInfo()
    {

    }




    public FacultyInfo(String facultyId, String facultyName, String designation, String photo) {
        FacultyId = facultyId;
        FacultyName = facultyName;
        Designation = designation;
        Photo = photo;
    }

    public String getFacultyId() {
        return FacultyId;
    }
    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getString()
    {
        return FacultyId+" "+FacultyName+"\n"+" "+Designation;
    }
}
