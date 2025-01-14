<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor's Section</title>
    <link rel="stylesheet" href="../styles/pharmacyStyles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../scripts/doctorScript.js"></script> <!-- External JavaScript file -->
</head>
<body>
   <header class="header">
        <div class="header-content">
            <h1 class="header-title">Doctor's section</h1>
            <a href="../Index.jsp" class="nav-logout-btn">Logout</a>
        </div>
    </header>
    
    <main>
        <!-- Admissions and Triage Table -->
        <div class="admissions">
            <h2 class="header-title">Admissions and Triage</h2>
            <table class="admissions-table table">
                <thead>
                    <tr class="table-row">
                        <th class="table-cell">Admission ID</th>
                        <th class="table-cell">Student ID</th>
                        <th class="table-cell">Admission Date</th>
                        <th class="table-cell">Body Temp</th>
                        <th class="table-cell">Blood Pressure</th>
                        <th class="table-cell">Heart Rate</th>
                        <th class="table-cell">Respiratory Rate</th>
                        <th class="table-cell">Actions</th>
                    </tr>
                </thead>
                <tbody id="admissionsTableBody" class="table-body">
                    <!-- Table rows will be dynamically added here -->
                </tbody>
            </table>
        </div>

       <section id="lab-test-form" class="drug-form" style="display: none;">
            <h2 class="form-title">Lab Test</h2>
            <form id="labTestForm" action="LabTestServlet" method="post">
                <div class="form-field">
                    <label for="testType" class="form-label">Select Test Type:</label>
                    <select name="testType" id="testType" class="form-input" required>
                        <option value="blood">Blood Test</option>
                        <option value="urine">Urine Test</option>
                        <option value="xray">X-Ray</option>
                        <!-- Add more options as needed -->
                    </select>
                </div>
                <input type="hidden" id="admissionID" name="admissionID" >
                <input type="hidden" id="studentID" name="studentID">
                <input type="hidden" id="admissionDate" name="admissionDate">
                <button type="submit" class="form-button" id="sendToLabButton">Send to Lab</button>
            </form>
        </section>

        <!-- Medical Examination Form -->
        <section id="drug-form" class="drug-form">
            <h2 class="form-title">Medical Examination</h2>
            <form action="DoctorServlet" method="post">
                <div class="form-field">
                    <label for="observation" class="form-label">Observation:</label>
                    <textarea name="observation" id="observation" rows="2" class="form-input" required></textarea>
                </div>
                <div class="form-field">
                    <label for="diagnosis" class="form-label">Diagnosis:</label>
                    <input type="text" id="diagnosis" name="diagnosis" class="form-input" required>
                </div>
                <div class="form-field">
                    <label for="prescription" class="form-label">Prescription:</label>
                    <textarea name="prescription" id="prescription" rows="2" class="form-input" required></textarea>
                </div>
                <input type="hidden" id="admissionIDMed" name="admissionID">
                <input type="hidden" id="studentIDMed" name="studentID">
                <input type="hidden" id="admissionDateMed" name="admissionDate">
                <button type="submit" class="form-button">Submit</button>
            </form>
        </section>
    </main>
    
    <footer class="footer">
        <div class="footer-content">
            <p class="footer-text">&copy; 2024 Triage System. All rights reserved. <a href="#" class="footer-link">Terms of Service</a> | <a href="#" class="footer-link">Privacy Policy</a></p>
        </div>
    </footer>

    <script>
        // Function to populate the table with admissions data
        $(document).ready(function() {
            // Your code to dynamically populate the admissions table here
        });

        function processMedicalForm() {
            // Get selected admission ID
            var selectedAdmissionID = $('input[name="admissionID"]:checked').val();
            
            // Get data from the selected row
            var studentID = $('#studentID_' + selectedAdmissionID).text();
            var admissionDate = $('#admissionDate_' + selectedAdmissionID).text();
            
            // Fill hidden fields in the medical examination form
            $('#admissionIDMed').val(selectedAdmissionID);
            $('#studentIDMed').val(studentID);
            $('#admissionDateMed').val(admissionDate);
            
            // Show the medical examination form
            $('#drug-form').show();
        }
    </script>
</body>
</html>
