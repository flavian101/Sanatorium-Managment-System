package com.model;

/**
 *
 * @author NATE
 */
public class Lab {
    private int  labTestId;
    private int admissionId;
    private String testName;
    private String testResult;
    private String testDate;

    // Constructors
    public Lab() {
    }

    public Lab(int labTestId, int admissionId, String testName, String testResult, String testDate) {
        this.labTestId = labTestId;
        this.admissionId = admissionId;
        this.testName = testName;
        this.testResult = testResult;
        this.testDate = testDate;
    }

    // Getters and setters
    public int getLabTestId() {
        return labTestId;
    }

    public void setLabTestId(int labTestId) {
        this.labTestId = labTestId;
    }

    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }
}