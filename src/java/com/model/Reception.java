package com.model;

/**
 *
 * @author NATE
 */
public class Reception {
    private String firstName;
    private String secondName;
    private String gender;
    private String lastName;
    private String regNumber;
    private String admissionData;
   

    // Constructors
    public Reception() {
    }

    public Reception(String firstName, String secondName,String gender, String lastName, String regNumber, String admissionDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.lastName = lastName;
        this.regNumber = regNumber;
        this.admissionData = admissionDate;
       
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getAdmissionData() {
        return admissionData;
    }

    public void setAdmissionData(String admissionData) {
        this.admissionData = admissionData;
    }
    

   
}