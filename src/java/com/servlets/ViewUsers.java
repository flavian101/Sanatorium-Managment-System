/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.data.Database;
import com.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author Sun
 */
public class ViewUsers extends HttpServlet {

   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    Database database = new Database();
    List<User> userList = database.getAllUsers();
    
    // Create HTML content to represent the user data
    StringBuilder htmlContent = new StringBuilder();
    for (User user : userList) {
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append(user.getM_username()).append("</td>");
        htmlContent.append("<td>").append(user.getM_specialization()).append("</td>");
        htmlContent.append("</tr>");
    }
    
    // Set content type and write HTML content to the response
    response.setContentType("text/html");
    response.getWriter().write(htmlContent.toString());
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
