/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.data.Database;
import com.model.Admission;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author Sun
 */
public class AdmissionServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     // Obtain admissions data from the database
    Database database = new Database();
    List<Admission> admissions = database.getAdmissions();

    // Build JSON manually
    StringBuilder jsonBuilder = new StringBuilder("[");
    for (Admission admission : admissions) {
        jsonBuilder.append("{");
        jsonBuilder.append("\"admissionID\":\"").append(admission.getAdmissionID()).append("\",");
        jsonBuilder.append("\"studentID\":\"").append(admission.getStudentID()).append("\",");
        jsonBuilder.append("\"admissionDate\":\"").append(admission.getAdmissionDate()).append("\"");
        jsonBuilder.append("},");
    }
    if (admissions.size() > 0) {
        jsonBuilder.setLength(jsonBuilder.length() - 1); // Remove the last comma
    }
    jsonBuilder.append("]");

    // Set response content type
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    // Write JSON string to the response
    try (PrintWriter out = response.getWriter()) {
        out.print(jsonBuilder.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
