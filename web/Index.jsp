<%-- 
    Document   : Index
    Created on : Mar 19, 2024, 1:39:43 AM
    Author     : Sun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link rel="stylesheet" href="styles/loginstyles.css">
</head>
 <header class="header">
     <div class="title">
     <h1> Sanatorium Management System</h1>
    </div> 
    </header>


    
<body>
<nav class="navbar">
  <ul>
       <li><a href="#" onclick="showLoginForm('reception')">Reception</a></li>
       <li><a href="#" onclick="showLoginForm('triage')">Triage</a></li>
       <li><a href="#" onclick="showLoginForm('doctor')">Doctor</a></li>
       <li><a href="#" onclick="showLoginForm('labAssistant')">Laboratory</a></li>
       <li><a href="#" onclick="showLoginForm('pharmacist')">Pharmacy</a></li>
  </ul>
</nav>

 <div class="background"></div>
<div class="container">
     <div id="reception-login" class="login-form" > <!-- Set display to block -->
    <h2>Reception </h2>
    <form action="Login" method="post" id="login-form">
                    <input type="hidden" name="specialization" value="reception">
                    
      <div class="input-group">
        <input type="text" name="username" id="username" placeholder="Username" required>
      </div>
      <div class="input-group">
        <input type="password" name="password" id="password" placeholder="Password" required>
      </div>
         <% String receptionError = (String) request.getAttribute("loginError"); %>
         <% if (receptionError != null) { %>
             <div class="error-message"><%= receptionError %></div>
         <% } %>
      <button type="submit" class="btn">Login</button>
    </form>
  </div>
    <div id="triage-login" class="login-form">
            <h2>Triage </h2>
      <form action="Login" method="post" id="login-form">
                    <input type="hidden" name="specialization" value="triage">
                    
      <div class="input-group">
        <input type="text" name="username" id="username" placeholder="Username" required>
      </div>
      <div class="input-group">
        <input type="password" name="password" id="password" placeholder="Password" required>
      </div>
         <% String triageError = (String) request.getAttribute("loginError"); %>
         <% if (triageError != null) { %>
             <div class="error-message"><%= triageError %></div>
         <% } %>
      <button type="submit" class="btn">Login</button>
    </form>
    </div>
 
  <div id="doctor-login" class="login-form" style="display: block;"> <!-- Set display to block -->
    <h2>Doctor </h2>
    <form action="Login" method="post" id="login-form">
                    <input type="hidden" name="specialization" value="doctor">
                    
      <div class="input-group">
        <input type="text" name="username" id="username" placeholder="Username" required>
      </div>
      <div class="input-group">
        <input type="password" name="password" id="password" placeholder="Password" required>
      </div>
          <% String doctorError = (String) request.getAttribute("loginError"); %>
         <% if (doctorError != null) { %>
             <div class="error-message"><%= doctorError %></div>
         <% } %>
      <button type="submit" class="btn">Login</button>
    </form>
  </div>
        	
    <div id="pharmacist-login" class="login-form">
            <h2>Pharmacy</h2>
            <form action="Login" method="post" id="login-form">
                    <input type="hidden" name="specialization" value="pharmacist">
                    
      <div class="input-group">
        <input type="text" name="username" id="username" placeholder="Username" required>
      </div>
      <div class="input-group">
        <input type="password" name="password" id="password" placeholder="Password" required>
      </div>
         <% String pharmacistError = (String) request.getAttribute("loginError"); %>
         <% if (pharmacistError != null) { %>
             <div class="error-message"><%= pharmacistError %></div>
         <% } %>
      <button type="submit" class="btn">Login</button>
    </form>
        </div>
        
   <div id="labAssistant-login" class="login-form">
            <h2>Laboratory</h2>
           <form action="Login" method="post" id="login-form">
                   <input type="hidden" name="specialization" value="labAssistant">

      <div class="input-group">
        <input type="text" name="username" id="username" placeholder="Username" required>
      </div>
      <div class="input-group">
        <input type="password" name="password" id="password" placeholder="Password" required>
      </div>
         <% String labAssistantError = (String) request.getAttribute("loginError"); %>
         <% if (labAssistantError != null) { %>
             <div class="error-message"><%= labAssistantError %></div>
         <% } %>
      <button type="submit" class="btn">Login</button>
    </form>
        </div>
 
  </div>
<script src="scripts/login.js"></script>
</body>
</html>
