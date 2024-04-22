

package com.servlets;

import com.data.Database;
import com.model.Triage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TriageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Retrieve form data
        float bodyTemp = Float.parseFloat(request.getParameter("bodyTemp"));
        float bloodPressure = Float.parseFloat(request.getParameter("bloodPressure"));
        float heartRate = Float.parseFloat(request.getParameter("heartRate"));
        float respiratoryRate = Float.parseFloat(request.getParameter("respiratoryRate"));
        String triageDate = request.getParameter("triageDate");
        int admissionID = Integer.parseInt(request.getParameter("admissionID")); // Retrieve admissionID from form

        // Create a Triage object
        Triage triage = new Triage(bodyTemp, bloodPressure, heartRate, respiratoryRate, triageDate);
        Database data = new Database();
        data.submitTriage(triage, admissionID); // Pass admissionID to the method
        // Store the Triage object in request scope
        
        request.setAttribute("triage", triage);
        
       request.getRequestDispatcher("/staff/Triage.jsp").forward(request, response);

    }
}