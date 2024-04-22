/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.data.Database;
import com.model.Triage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;


/**
 *
 * @author Sun
 */
public class TriageGetServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Database data = new Database();
        List<Triage> triageList = data.getTriageRecords();
        // Print each triage record to the console
       System.out.println("Triage Records:");
    for (Triage triage : triageList) {
    System.out.println("Body Temp: " + triage.getBodyTemp());
    System.out.println("Blood Pressure: " + triage.getBloodPressure());
    System.out.println("Heart Rate: " + triage.getHeartRate());
    System.out.println("Respiratory Rate: " + triage.getRespiratoryRate());
    System.out.println("Admission ID: " + triage.getAdmissionID());
    System.out.println("Student ID: " + triage.getStudentID());
    System.out.println("Admission Date: " + triage.getTriageDate());
    System.out.println("-----------------------------------");
}
        
         // Build the response manually using StringBuilder
       StringBuilder responseBuilder = new StringBuilder("[");
        for (Triage triage : triageList) {
            responseBuilder.append("{");
            responseBuilder.append("\"bodyTemp\":\"").append(triage.getBodyTemp()).append("\",");
            responseBuilder.append("\"bloodPressure\":\"").append(triage.getBloodPressure()).append("\",");
            responseBuilder.append("\"heartRate\":\"").append(triage.getHeartRate()).append("\",");
            responseBuilder.append("\"respiratoryRate\":\"").append(triage.getRespiratoryRate()).append("\",");
            responseBuilder.append("\"admissionID\":\"").append(triage.getAdmissionID()).append("\",");
            responseBuilder.append("\"studentID\":\"").append(triage.getStudentID()).append("\",");
            responseBuilder.append("\"admissionDate\":\"").append(triage.getTriageDate()).append("\"");
            responseBuilder.append("},");
        }
        if (!triageList.isEmpty()) {
            responseBuilder.setLength(responseBuilder.length() - 1); // Remove the last comma
        }
        responseBuilder.append("]");

        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

       // Write JSON string to the response
    try (PrintWriter out = response.getWriter()) {
        out.print(responseBuilder.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
        


  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
