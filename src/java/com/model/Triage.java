package com.model;

/**
 *
 * @author NATE
 */

public class Triage {
    private int triageId;
    private int admissionId;
    private float bodyTemp;
    private float bloodPressure;
    private float weight;
    private float heartRate;
    private float respiratoryRate;
    private String Date;
    private float height;

    public Triage() {
    }

    public Triage(int triageId, int admissionId, float bodyTemp, float bloodPressure,float weight, float heartRate, float respiratoryRate, String Date, float height) {
        this.triageId = triageId;
        this.admissionId = admissionId;
        this.bodyTemp = bodyTemp;
        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.Date = Date;
        this.height = height;
    }

    public int getTriageId() {
        return triageId;
    }

    public void setTriageId(int triageId) {
        this.triageId = triageId;
    }

    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public float getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(float bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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
        return Date;
    }

    public void setTriageDate(String Date) {
        this.Date = Date;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
}