/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.data.Database;
import com.model.User;
import com.utils.PasswordHasher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;





/**
 *
 * @author Sun
 */
public class Login extends HttpServlet {
    String ErrorMessage ="Invalid username or password";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    processRequest(request, response);

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String specialization = request.getParameter("specialization");

    String hashedPassword = PasswordHasher.hashPassword(password);
   // System.out.println(hashedPassword);

    User user = new User(specialization,username , hashedPassword );
    Database userIO = new Database();

     // Retrieve user details from the database
    User retrievedUser = (User) userIO.getUserDetails(user); 

     if (retrievedUser != null && hashedPassword.equals(retrievedUser.getPassword())) {
          // Set session attributes upon successful login
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);
            session.setAttribute("specialization", specialization);
          

            // Redirect with specialization
            String redirectPage;
            redirectPage = switch (specialization) {
            case "reception" -> "staff/Receptionist.jsp";
            case "triage" -> "staff/Triage.jsp";
            case "doctor" -> "staff/Doctor.jsp";
            case "labAssistant" -> "staff/labAssistant.jsp";
            case "pharmacist" -> "staff/pharmacy.jsp";
            default -> "Index.jsp";
        }; // Default redirection page
            response.sendRedirect(redirectPage);
        } else {
            // User authentication failed
            request.setAttribute("loginError", ErrorMessage);
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        }
    }


}

   



