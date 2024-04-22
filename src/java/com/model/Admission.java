/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Sun
 */
public class Admission {
    private int admissionID;
    private String studentID;
    private String admissionDate;

    public Admission(int admissionID, String studentID, String admissionDate) {
        this.admissionID = admissionID;
        this.studentID = studentID;
        this.admissionDate = admissionDate;
    }

    public Admission() {
        admissionID = 0;
        studentID = "";
        admissionDate = "";
                
    }

    public int getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(int admissionID) {
        this.admissionID = admissionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }
    
}
