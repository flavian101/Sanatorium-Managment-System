/**
 * 
 */

function showLoginForm(role) {
  // Hide all login forms
  var loginForms = document.querySelectorAll('.login-form');
  loginForms.forEach(function(form) {
    form.style.display = 'none';
  });

  // Show the selected login form
  var selectedForm = document.getElementById(role + '-login');
  if (selectedForm) {
    selectedForm.style.display = 'block';
  }
  
  // Prevent default link behavior
  event.preventDefault();
}


 document.getElementById('login-form').addEventListener('submit', function(event) {
  var username = document.getElementById('username').value.trim();
  var password = document.getElementById('password').value.trim();

  if (username === '' || password === '') {
    event.preventDefault(); // Prevent form submission
    document.getElementById('login-container').classList.add('shake');

    setTimeout(function() {
      document.getElementById('login-container').classList.remove('shake');
    }, 500); // Reset shake animation after 0.5s
  }
});

