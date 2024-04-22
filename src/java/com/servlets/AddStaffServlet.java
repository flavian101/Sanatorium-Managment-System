/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.data.Database;
import com.model.User;
import com.utils.PasswordHasher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author Sun
 */
public class AddStaffServlet extends HttpServlet {

    
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
        
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String specialization = request.getParameter("specialization");
            System.out.println("new user created            " + specialization);

    String hashedPassword = PasswordHasher.hashPassword(password);
    
    User user = new User(specialization,username , hashedPassword );
    Database userIO = new Database();
    
    if(userIO.AddUserDetails(user))
    {
        
        request.setAttribute("username", user.getM_username());
        System.out.println("new user created");
        //redirect
        String url="/utils/success.jsp";
        RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher(url);
        dispacher.forward(request, response);
    
    }
    
  
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
