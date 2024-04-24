$(document).ready(function() {
    // Function to fetch combined admissions and triage data from the servlet and populate the table
    $.ajax({
        url: "TriageGetServlet",
        type: "POST",
        success: function(data) {
            populateTable(data);
        },
        error: function(xhr, status, error) {
            console.error("Error fetching admissions and triage data:", error);
        }
    });
});

function populateTable(data) {
    var tableBody = $("#admissionsTableBody");
    tableBody.empty(); // Clear existing data
    data.forEach(function(rowData) {
        var row = "<tr>" +
                    "<td>" + rowData.admissionID + "</td>" +
                    "<td>" + rowData.studentID + "</td>" +
                    "<td>" + rowData.admissionDate + "</td>";
        if (rowData.bodyTemp && rowData.bloodPressure && rowData.heartRate && rowData.respiratoryRate) {
            row += "<td>" + rowData.bodyTemp + "</td>" +
                   "<td>" + rowData.bloodPressure + "</td>" +
                   "<td>" + rowData.heartRate + "</td>" +
                   "<td>" + rowData.respiratoryRate + "</td>";
        } else {
            row += "<td colspan='4'>-</td>"; // If triage data is not available, display "-" in those columns
        }
        row += "<td><button class='processButton' onclick='processMedicalForm(" + rowData.admissionID + ", \"" + rowData.studentID + "\", \"" + rowData.admissionDate + "\")'>Process</button></td>" +
                "</tr>";
        tableBody.append(row);
    });
}

function fillTriageDetails(admissionID, studentID, admissionDate) {
    document.getElementById("bodyTemp").value = "";
    document.getElementById("bloodPressure").value = "";
    document.getElementById("heartRate").value = "";
    document.getElementById("respiratoryRate").value = "";
    document.getElementById("admissionID").value = admissionID;
    document.getElementById("studentID").value = studentID;
    document.getElementById("admissionDate").value = admissionDate;
}

function processMedicalForm(admissionID, studentID, admissionDate) {
    // Fill hidden fields in the medical examination form
    $('#admissionIDMed').val(admissionID);
    $('#studentIDMed').val(studentID);
    $('#admissionDateMed').val(admissionDate);
    
    // Show the medical examination form
    $('#drug-form').show();
}
