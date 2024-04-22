/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Sun
 */
public class Prescription {
    private String drugName;
    private String dosage;
    private String prescribingPhysician;

    // Constructors
    public Prescription() {
    }

    public Prescription(String drugName, String dosage, String prescribingPhysician) {
        this.drugName = drugName;
        this.dosage = dosage;
        this.prescribingPhysician = prescribingPhysician;
    }

    // Getters and setters
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPrescribingPhysician() {
        return prescribingPhysician;
    }

    public void setPrescribingPhysician(String prescribingPhysician) {
        this.prescribingPhysician = prescribingPhysician;
    }
}
