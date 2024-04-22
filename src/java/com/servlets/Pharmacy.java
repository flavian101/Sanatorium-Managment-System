
package com.servlets;

import com.data.Database;
import com.model.Prescription;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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
         
         
         
         
         //database
          String[][] recommendations = {
            {"John Doe", "RX123456", "Prescription details for John Doe"},
            {"Jane Smith", "RX789012", "Prescription details for Jane Smith"}
        };

        // Format data into HTML table rows
        StringBuilder tableRows = new StringBuilder();
        for (String[] recommendation : recommendations) {
            tableRows.append("<tr>");
            for (String field : recommendation) {
                tableRows.append("<td>").append(field).append("</td>");
            }
            tableRows.append("<td><button class='processButton'>Process</button></td>");
            tableRows.append("</tr>");
        }

        // Send response with HTML content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(tableRows.toString());
        out.close();

         String url = "/staff/pharmacy.jsp";
         RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
           
        dispatcher.forward(request, response);
    
}
}
