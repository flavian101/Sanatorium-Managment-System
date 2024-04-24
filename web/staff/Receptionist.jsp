<%@ page import="com.model.Reception" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Receptionist Information</title>
    <link rel="stylesheet" href="../styles/receptionistStyles.css">
    <script>
        function updateDate() {
            var currentDate = new Date();
            var day = currentDate.getDate();
            var month = currentDate.getMonth() + 1;
            var year = currentDate.getFullYear();
            var formattedDate = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
            document.getElementById('dateOfAdmission').value = formattedDate;
        }
    </script>
</head>
<body onload="updateDate()">

<header class="header">
    <div class="header-content">
        <h1 class="header-title">Receptionist Section</h1>
        <a href="../Index.jsp" class="nav-logout-btn">Logout</a>
    </div>
</header>

<div class="container">
    <!-- Search Form -->
    <form action="SearchServlet" method="post" class="search-form">
        <input type="text" id="searchBar" name="regnumber" placeholder="Search RegNumber..." class="form-input">
        <input type="submit" value="Search" class="form-button">
    </form>
    
    <!-- Display Search Results -->
    <table class="search-results-table">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Reg Number</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                Reception searchResults = (Reception) request.getAttribute("searchResults");
                if (searchResults != null) {
            %>
            <tr>
                <td><%= searchResults.getFirstName() %></td>
                <td><%= searchResults.getLastName() %></td>
                <td><%= searchResults.getGender() %></td>
                <td><%= searchResults.getRegNumber() %></td>
                <td>
                    <form action="AdmitServlet" method="post">
                        <input type="hidden" name="regNumber" value="<%= searchResults.getRegNumber() %>">
                        <button type="submit" class="action-button process-button">Send to Triage</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <!-- Reception Form -->
    <form action="ReceptionServlet" method="post" class="form-container">
        <div class="form-group">
            <label for="firstname" class="form-label">First Name:</label>
            <input type="text" id="firstname" name="firstname" required class="form-input">
        </div>
        
        <div class="form-group">
            <label for="lastname" class="form-label">Last Name:</label>
            <input type="text" id="lastname" name="lastname" required class="form-input">
        </div>

        <div class="form-group">
            <label for="gender" class="form-label">Gender:</label>
            <select id="gender" name="gender" class="form-input">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="regnumber" class="form-label">Reg Number:</label>
            <input type="text" name="regnumber" class="form-input">
        </div>

       
        <!-- Rename submit button to "Register" -->
        <button type="submit" class="submit-button form-button">Register</button>
    </form>
</div>

<footer class="footer">
    <div class="footer-content">
        <p class="footer-text">&copy; 2024 Sanatorium System. All rights reserved. <a href="#" class="footer-link">Terms of Service</a> | <a href="#" class="footer-link">Privacy Policy</a></p>
    </div>
</footer>

</body>
</html>

