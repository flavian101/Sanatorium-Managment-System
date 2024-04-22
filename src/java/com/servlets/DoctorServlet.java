


package com.santorium.servlets;

import com.santorium.user.Doctor;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LabServlet", urlPatterns = {"/PharmacyServlet2"})
public class DoctorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Doctor doctor = new Doctor();
        doctor.setObservation(request.getParameter("observation"));
        doctor.setExamination(request.getParameter("examination"));
        doctor.setDiagnosis(request.getParameter("diagnosis"));
        doctor.setRecommendations(request.getParameter("recommendations"));
        doctor.setPrescription(request.getParameter("prescription"));

        request.setAttribute("doctor", doctor);
        RequestDispatcher  Dispatcher= request.getServletContext().getRequestDispatcher("Doctor.jsp");
        Dispatcher.forward(request, response);
    }
}