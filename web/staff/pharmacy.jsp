<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy Management System</title>
    <link rel="stylesheet" href="../styles/pharmacyStyles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
      $(document).ready(function() {
    // Function to fetch recommendations from the servlet and populate the table
    $.ajax({
        url: "Pharmacy",
        type: "POST",
        success: function(data) {
            $("#recommendationsTableBody").html(data);
        },
        error: function(xhr, status, error) {
            console.error("Error fetching recommendations:", error);
        }
    });
});
    </script>
</head>
<body>
    <header class="header">
        <div class="header-content">
            <h1 class="header-title">Pharmacy Management System</h1>
            <a href="../Index.jsp" class="nav-logout-btn">Logout</a>
        </div>
    </header>

    <main>
        <!-- Recommendations Table -->
        <div class="recommendations">
            <h2>Doctor Recommendations</h2>
            <table class="recommendations-table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Registration Number</th>
                        <th>Prescription</th>
                        <th>Action</th> <!-- Added Action column -->
                    </tr>
                </thead>
                <tbody id="recommendationsTableBody"> <!-- Updated with id for dynamic population -->
                </tbody>
            </table>
        </div>

        <!-- Prescription Form -->
        <div class="drug-form">
            <div class="form-container">
                <h2 class="form-title">Prescription Information</h2>
                <form action="Pharmacy" method="post" class="form">
                    <div class="form-field">
                        <label for="drugName" class="form-label">Drug Name:</label>
                        <input type="text" id="drugName" name="drugName" placeholder="Enter drug name" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="dosage" class="form-label">Dosage:</label>
                        <input type="text" id="dosage" name="dosage" placeholder="Enter dosage" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="prescribingPhysician" class="form-label">Prescribing Physician:</label>
                        <input type="text" id="prescribingPhysician" name="prescribingPhysician" placeholder="Enter physician's name" class="form-input" required>
                    </div>
                    <div class="form-field">
                        <label for="patientSelect" class="form-label">Select Patient:</label>
                        <select name="patientSelect" id="patientSelect" class="form-input">
                            <option value="patient1">Patient 1</option>
                            <option value="patient2">Patient 2</option>
                            <!-- Add more options dynamically based on available patients -->
                        </select>
                    </div>
                    <button type="submit" id="prescribeButton" class="form-button">Prescribe</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="footer">
        <div class="footer-content">
            <p class="footer-text">&copy; 2024 Pharmacy Management System. All rights reserved. <a href="#" class="footer-link">Terms of Service</a> | <a href="#" class="footer-link">Privacy Policy</a></p>
        </div>
    </footer>
</body>
</html>
