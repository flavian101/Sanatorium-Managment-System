<%-- 
    Document   : AdminLogin
    Created on : Mar 19, 2024, 2:42:04 AM
    Author     : Sun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Administrator Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../styles/AdminStyle.css">
    </head>
    <body>
        <header class="header">
            <h1>Sanatorium Management System</h1>
        </header>
       
        <div class="background">
            <div class="container">
                <div id="admin-login" class="login-form">
                    <h2>Administrator Login</h2>
                    <form action="AdminLogin" method="post" id="login-form">
                        <input type="hidden" name="specialization" value="administrator">
                        <div class="input-group">
                            <input type="text" name="username" id="username" placeholder="Username" required>
                        </div>
                        <div class="input-group">
                        <input type="password" name="password" id="password" placeholder="Password" required><!-- comment -->
                        </div><!-- comment -->
                        <button type="submit" class="btn">Login</button>
                    </form>
                </div>
            </div>
        </div>
        
        <script src="login.js"></script>
    </body>
</html>

