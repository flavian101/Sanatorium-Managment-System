<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../styles/success.css">
    <title>Success</title>
</head>
<body>
       <%@page import="com.model.User" %>
    <%
        String username =  (String)request.getAttribute("username");
        
    %>
    <div class="container">
        <div class="success-message animated fadeIn">
            <div class="header">Success!</div>
            <p>You have successfully added <span class="username"><%= username %></span> as a new user.</p>
        </div>
    </div>

   <script>
    setTimeout(function(){
        window.location.href = document.referrer;
    }, 5000);
    </script>
</body>
</html>
