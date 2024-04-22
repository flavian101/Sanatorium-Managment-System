<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Triage Section</title>
    <link rel="stylesheet" href="../styles/pharmacyStyles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Function to fetch admissions from the servlet and populate the table
            $.ajax({
                url: "AdmissionServlet",
                type: "POST",
                success: function(data) {
                    populateTable(data);
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching admissions:", error);
                }
            });
        });

        // Function to populate table with admissions data
        function populateTable(admissions) {
            var tableBody = $("#admissionsTableBody");
            tableBody.empty(); // Clear existing data
            admissions.forEach(function(admission) {
                var row = "<tr>" +
                            "<td>" + admission.admissionID + "</td>" +
                            "<td>" + admission.studentID + "</td>" +
                            "<td>" + admission.admissionDate + "</td>" +
                            "<td><a href='#' onclick='fillTriageDetails(" + admission.admissionID + ", \"" + admission.studentID + "\", \"" + admission.admissionDate + "\")'>Process</a></td>" +
                        "</tr>";
                tableBody.append(row);
            });
        }

        // JavaScript function to fill in the triage details
        function fillTriageDetails(admissionID, studentID, admissionDate) {
            document.getElementById("bodyTemp").value = "";
            document.getElementById("bloodPressure").value = "";
            document.getElementById("heartRate").value = "";
            document.getElementById("respiratoryRate").value = "";
            document.getElementById("admissionID").value = admissionID;
            document.getElementById("studentID").value = studentID;
            document.getElementById("admissionDate").value = admissionDate;
        }
    </script>
</head>
<body>
    <header class="header">
        <div class="header-content">
            <h1 class="header-title">Triage Section</h1>
            <a href="../Index.jsp" class="nav-logout-btn">Logout</a>
        </div>
    </header>

    <main>
        <!-- Admissions Table -->
        <div class="admissions">
            <h2>Admissions</h2>
            <table class="admissions-table">
                <thead>
                    <tr>
                        <th>Admission ID</th>
                        <th>Student ID</th>
                        <th>Admission Date</th>
                        <th>Action</th> <!-- Added Action column -->
                    </tr>
                </thead>
                <tbody id="admissionsTableBody"> <!-- Updated with id for dynamic population -->
                </tbody>
            </table>
        </div>

        <!-- Triage Form -->
        <div class="triage-form">
            <div class="form-container">
                <h2 class="form-title">Triage Details</h2>
                <form action="TriageServlet" method="post" class="form">
                    <div class="form-field">
                        <label for="bodyTemp" class="form-label">Body Temperature:</label>
                        <input type="text" id="bodyTemp" name="bodyTemp" placeholder="Enter body temperature" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="bloodPressure" class="form-label">Blood Pressure:</label>
                        <input type="text" id="bloodPressure" name="bloodPressure" placeholder="Enter blood pressure" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="heartRate" class="form-label">Heart Rate:</label>
                        <input type="text" id="heartRate" name="heartRate" placeholder="Enter heart rate" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="respiratoryRate" class="form-label">Respiratory Rate:</label>
                        <input type="text" id="respiratoryRate" name="respiratoryRate" placeholder="Enter respiratory rate" class="form-input" required>
                    </div>
                    <input type="hidden" id="admissionID" name="admissionID" value="<%= request.getParameter("admissionID") %>">
                    <input type="hidden" id="studentID" name="studentID">
                    <input type="hidden" id="admissionDate" name="admissionDate">
                    <button type="submit" id="triageButton" class="form-button">Submit Triage</button>
                 </form>
            </div>
        </div>
    </main>

    <footer class="footer">
        <div class="footer-content">
            <p class="footer-text">&copy; 2024 Triage System. All rights reserved. <a href="#" class="footer-link">Terms of Service</a> | <a href="#" class="footer-link">Privacy Policy</a></p>
        </div>
    </footer>
</body>
</html>
