$(document).ready(function() {
    // Show success message on page load
    $("#success-message").fadeIn(1000).delay(3000).fadeOut(1000);

    // Function to toggle add new user form visibility
    function toggleAddUserForm() {
        $("#add-staff-form").slideToggle("slow");
        $("#user-table-container").slideUp("slow"); // Hide the user table
    }

    // Function to toggle user table visibility
    function toggleUserTable() {
        // Make an AJAX request to fetch user data from the servlet
        $.ajax({
            url: "ViewUsers",
            type: "POST",
            success: function(response) {
                // Insert the response (HTML) into the user-table-body
                $("#user-table-body").html(response);
                // Toggle visibility of the user table
                $("#user-table-container").slideToggle("slow");
                // Hide the add new user form
                $("#add-staff-form").slideUp("slow");
            },
            error: function(xhr, status, error) {
                console.error("Error:", error);
            }
        });
    }

    // Toggle add new user form visibility when "Add New User" link is clicked
    $("#add-user-link").click(function(e) {
        e.preventDefault();
        toggleAddUserForm();
    });

    // Toggle user table visibility when "View Users" link is clicked
    $("#view-users-link").click(function() {
        toggleUserTable();
    });
});
