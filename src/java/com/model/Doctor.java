package com.model;

/**
 *
 * @author NATE
 */


public class Doctor {
    private String observation;
    private String examination;
    private String diagnosis;
    private String recommendations;
    private String prescription;

    public Doctor(String observation, String examination, String diagnosis, String recommendations, String prescription) {
        this.observation = observation;
        this.examination = examination;
        this.diagnosis = diagnosis;
        this.recommendations = recommendations;
        this.prescription = prescription;
    }

    public Doctor() {
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
} 