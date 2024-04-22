
<!DOCTYPE html>
<html>
<head>
     <link rel="stylesheet" href="pharmacycss.css">
    <title>Doctor's Section</title> <!--===hero-section===-->
</head>
<body>
    <header>
        <h1>Doctor's Section</h1>
        
    </header>
    
     <section id="hero">
        <!--****nav-section****-->
        <nav class="navigation">
            <!--logo-->
            <a href="#" class="logo"><span>We Care</span></a>
            <!--menu-->
            <ul class="menu">
                <li><a href="#">Home</a></li>
                <li><a href="#">Our Services</a></li>
                <li><a href="#">Departments</a></li>
                
                
            </ul>
        </nav>
        <div class="hero content">
            
                  <div class="hero-img">
                <img src="Images\Doctors.jfif">
                  </div>
            </div>
    </section>
   
    <main>
        <section id="drug-form">
           <h2 style="text-align: center;">Medical examination</h2>
       <form action ="DoctorServlet" method="post">
    <label for="observation">Observation:</label>
    <textarea name="observation" id="observation"  rows="4"  required></textarea>

    <label for="examiation">Examination:</label>
    <textarea name="examination" id="examiation"  rows="4"  required></textarea>

    <label for="diagnosis">Diagnosis:</label>
    <input type="text" id="diagnosis" name="diagnosis" required>

    <label for="recommendations">Treatment recommendation:</label>
    <textarea name="recommendations" id="recommendations"  rows="4"  required></textarea>


    <label for="prescription">Prescription:</label>
    <textarea name="prescription" id="prescription"  rows="4"  required></textarea>


    <button type="submit">Submit</button>
</form>
        </section>
    </main>
    
    <footer>
       <p style="text-align: center;">&copy; 2024 Santorium Pharmacy. All rights reserved.</p>
    </footer>
</body>
</html>