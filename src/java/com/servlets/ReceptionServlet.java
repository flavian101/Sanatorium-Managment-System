
package com.servlets;

import com.data.Database;
import com.model.Reception;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;




public class ReceptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Reception reception = new Reception();
        reception.setFirstName(request.getParameter("firstname"));
        reception.setLastName(request.getParameter("lastname"));
        reception.setGender(request.getParameter("gender"));
        reception.setRegNumber(request.getParameter("regnumber"));
        reception.setAdmissionData(request.getParameter("dateOfAdmission"));
      
        Database data = new Database();
        data.submitReception(reception);
        request.setAttribute("receptionist", reception);
        String url = "/staff/Receptionist.jsp";
        
       
    
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        //request.getRequestDispatcher(url).forward(request, response);
           
        dispatcher.forward(request, response);
    }
}