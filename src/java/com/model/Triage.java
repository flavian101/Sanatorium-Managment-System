/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author NATE
 */

public class Triage {
    private int admissionID;
    private String studentID;
    private float bodyTemp;
    private float bloodPressure;
    private float heartRate;
    private float respiratoryRate;
    private String triageDate;

    public Triage() {
    }

    public Triage(float bodyTemp, float bloodPressure, float heartRate, float respiratoryRate, String triageDate) {
   
        this.bodyTemp = bodyTemp;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.triageDate = triageDate;
        this.admissionID = 0;
        this.studentID="";
    }
    public float getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(float bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }

    public float getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(float respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getTriageDate() {
        return triageDate;
    }

    public void setTriageDate(String triageDate) {
        this.triageDate = triageDate;
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
    
}