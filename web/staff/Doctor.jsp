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
                     <th class="table-cell">Action</th>
                 </tr>
             </thead>
             <tbody id="admissionsTableBody" class="table-body">
             </tbody>
         </table>
     </div>

          
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
                 <input type="hidden" id="admissionID" name="admissionID">
                 <input type="hidden" id="studentID" name="studentID">
                 <input type="hidden" id="admissionDate" name="admissionDate">
                 <button type="submit" class="form-button">Submit</button>
             </form>
         </section>
    </main>
    
     <footer class="footer">
        <div class="footer-content">
            <p class="footer-text">&copy; 2024 Triage System. All rights reserved. <a href="#" class="footer-link">Terms of Service</a> | <a href="#" class="footer-link">Privacy Policy</a></p>
        </div>
    </footer>
</body>
</html>
