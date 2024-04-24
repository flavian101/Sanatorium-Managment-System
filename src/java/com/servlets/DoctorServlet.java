package com.servlets;


import com.data.Database;
import com.model.Doctor;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoctorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      // Get the admission ID parameter from the request
    String admissionIDParam = request.getParameter("admissionID");

    // Initialize id as 0
    int id = 0;

    // Check if the admission ID parameter is not null and not empty
    if (admissionIDParam != null && !admissionIDParam.isEmpty()) {
        // Parse the admission ID parameter as an integer
        id = Integer.parseInt(admissionIDParam);
    } else {
        // Log a message indicating that the admission ID parameter is null or empty
        System.err.println("Admission ID parameter is null or empty");
    }

    // Create a Doctor object and set its properties
    Doctor doctor = new Doctor();
    doctor.setObservation(request.getParameter("observation"));
    doctor.setDiagnosis(request.getParameter("diagnosis"));
    doctor.setPrescription(request.getParameter("prescription"));

    // Submit the doctor data to the database
    Database data = new Database();
    data.submitDoctor(doctor, id);

    // Set the doctor object as an attribute in the request
    request.setAttribute("doctor", doctor);

    // Forward the request to the Doctor.jsp page
    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/staff/Doctor.jsp");
    dispatcher.forward(request, response);
    }
}