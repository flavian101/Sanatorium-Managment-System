<%@ page import="com.model.Reception" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Receptionist Information</title>
    <link rel="stylesheet" href="pharmacycss.css">
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

<div class="container">
    <h2>Receptionist Information</h2>
    <!-- Search Form -->
    <form action="SearchServlet" method="post">
        <input type="text" id="searchBar" name="regnumber" placeholder="Search RegNumber...">
        <input type="submit" value="Search">
    </form>
    
    <!-- Display Search Results -->
    <table>
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
                        <input type="submit" value="Send to Triage">
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <form action="ReceptionServlet" method="post">
        <label for="firstname">First Name:</label>
        <input type="text" id="firstname" name="firstname" required>
        
        <label for="lastname">Last Name:</label>
        <input type="text" id="lastname" name="lastname" required>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>
        
        <label for="regnumber">Reg Number:</label><br><br>
        <input type="text" name="regnumber">

        <!-- Hidden field for Date of Admission -->
        <input type="date" id="dateOfAdmission" name="dateOfAdmission">

        <!-- Rename submit button to "Register" -->
        <input type="submit" value="Register">
    </form>
</div>

<footer>
    <p style="text-align: center;">&copy; 2024 Sanatorium Pharmacy. All rights reserved.</p>
</footer>

</body>
</html>
