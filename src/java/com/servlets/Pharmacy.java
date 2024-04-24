package com.servlets;

import com.data.Database;
import com.model.Prescription;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Pharmacy extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String drugName = request.getParameter("drugName");
        String dosage = request.getParameter("dosage");
        String prescribingPhysician = request.getParameter("prescribingPhysician");

        Prescription prescription = new Prescription(drugName, dosage, prescribingPhysician);

        Database data = new Database();
        data.submitPrescription(prescription);
        request.setAttribute("prescription", prescription);

        // Retrieve prescriptions from the database
        Database database = new Database();
        List<Prescription> prescriptions = database.getPrescriptionsWithRegNumber();

        // Format data into HTML table rows
        StringBuilder tableRows = new StringBuilder();
        for (Prescription presc : prescriptions) {
            tableRows.append("<tr>");
            tableRows.append("<td>").append(presc.getDrugName()).append("</td>");
            tableRows.append("<td>").append(presc.getDosage()).append("</td>");
            tableRows.append("<td>").append(presc.getPrescribingPhysician()).append("</td>");
            tableRows.append("<td>").append(presc.getRegNumber()).append("</td>");
            tableRows.append("<td><button class='processButton'>Process</button></td>");
            tableRows.append("</tr>");
        }

        // Send response with HTML content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(tableRows.toString());
        out.close();

        // Note: Remove the following lines if you want to only send the HTML response
        String url = "/staff/pharmacy.jsp";
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
