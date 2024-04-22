<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sanatorium Management System</title>
    <link rel="stylesheet" href="../styles/AHstyle.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../scripts/Ascript.js"></script>
</head>
<body>
    <header class="header">
        <h1>Sanatorium Management System</h1>
        <a href="../admin/AdminLogin.jsp" class="logout-btn">Logout</a>
    </header>
    <div class="container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul>
                    <li><a href="#" class="nav-link" id="add-user-link">Add New User</a></li>
                    <li><a href="#" class="nav-link" id="view-users-link">View Users</a></li>
                </ul>
            </nav>
        </div>
        <main>
            <div class="content">
                <!-- Success message container -->
                <div id="success-message">You have successfully logged in.</div> 
                <form action="AddStaffServlet" method="post" class="form" id="add-staff-form" style="display: none;">
                    <!-- Your form for adding staff members -->
                    <h2>Add Staff Members</h2>
                    <div class="form-group">
                        <label for="specialization">Specialization:</label>
                        <select name="specialization" id="specialization">
                            <option value="doctor">Doctor</option>
                            <option value="triage">Triage</option>
                            <option value="pharmacist">Pharmacist</option>
                            <option value="labAssistant">Lab Assistant</option>
                            <option value="reception">Receptionist</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" placeholder="Enter username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password" placeholder="Enter password">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add Staff Member</button>
                    </div>
                </form>
                
                <!-- Dynamic table to display users -->
                <div id="user-table-container">
                    <h2>All Users</h2>
                    <table id="user-table">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Specialization</th>
                            </tr>
                        </thead>
                         <tbody id="user-table-body">
                          
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
