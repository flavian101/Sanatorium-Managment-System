package com.servlets;

import com.data.Database;
import com.model.User;
import com.utils.PasswordHasher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author Sun
 */
public class AdminLogin extends HttpServlet {
     User user;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        processRequest(request, response);
      // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String specialization = request.getParameter("specialization");

        // Hash the provided password
    String hashedPassword = PasswordHasher.hashPassword(password);
    

    // Create a User object with the provided credentials
    User user = new User(specialization, username, hashedPassword);

    // Create an instance of Database to retrieve user details from the database
    Database userIO = new Database();

    // Retrieve user details from the database
    User retrievedUser = userIO.getUserDetails(user);

    if (retrievedUser != null) {
       
        if (hashedPassword.equals(retrievedUser.getPassword())) {
            response.sendRedirect("AdminHomepage.jsp");
        } else {
           
            request.setAttribute("loginError", "Invalid username or password");

            // Forward the request back to the login page with the error message
            request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
        }
    } else {
        
        request.setAttribute("loginError", "Invalid username or password");
        request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
    }
    }
     
     
  
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
