package com.data;


import com.model.Admission;
import com.model.Doctor;
import com.model.Lab;
import com.model.Prescription;
import com.model.Reception;
import com.model.Triage;
import com.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/logindatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "gomugomu";
  
    public User getUserDetails(User user) {
        User retrievedUser = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM login WHERE specialization = ? AND username = ? AND password = ?")) {
            stmt.setString(1, user.getM_specialization());
            stmt.setString(2, user.getM_username());
            stmt.setString(3, user.getPassword());

             try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // User found in the database
                retrievedUser = new User();
                retrievedUser.setM_username(rs.getString("username"));
                retrievedUser.setPassword(rs.getString("password"));
                retrievedUser.setM_specialization(rs.getString("specialization"));
            }
        }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return retrievedUser;
    }
    public boolean AddUserDetails(User user)
    {
        boolean success = false;
        try 
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex)
        {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false if the driver is not found
        }
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO login (username, password, specialization) VALUES (?, ?, ?)")) {
        
             // Set parameters for the SQL statement
        stmt.setString(1, user.getM_username());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getM_specialization());

        // Execute the SQL statement
        int rowsAffected = stmt.executeUpdate();
        
        if (rowsAffected > 0) {
            success = true;
        }
        
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
        return success;
    }
     public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM login");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setM_username(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setM_specialization(rs.getString("specialization"));
                userList.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return userList;
    }
    
    public Prescription submitPrescription(Prescription prescription) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String insertQuery ="INSERT INTO prescription (DrugName, Dosage, PrescribingPhysician) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setString(1, prescription.getDrugName());
            insertStatement.setString(2, prescription.getDosage());
            insertStatement.setString(3, prescription.getPrescribingPhysician());
            insertStatement.executeUpdate(); 
            
            insertStatement.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
           
        return prescription;
    }
  
    public Reception submitReception(Reception reception) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO student (regNumber,FirstName, LastName, Gender) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, reception.getRegNumber());
            stmt.setString(2, reception.getFirstName());
            stmt.setString(3, reception.getLastName());
            stmt.setString(4, reception.getGender());
            
         

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record has been inserted into the student table.");
            } else {
                System.out.println("Failed to insert a new record into the student table.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return reception;
    }
  
    public Doctor submitDoctor(Doctor doctor,int AdmissionID) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO doctors (AdmissionID,observation, diagnosis, prescription) VALUES (?,?, ?, ?)")) {
            stmt.setInt(1, AdmissionID);
            stmt.setString(2, doctor.getObservation());
            stmt.setString(3, doctor.getDiagnosis());
            stmt.setString(4, doctor.getPrescription());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record has been inserted into the doctors table.");
            } else {
                System.out.println("Failed to insert a new record into the doctors table.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return doctor;
    }
  
    public Triage submitTriage(Triage triage, int admissionID) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO triage (AdmissionID, bodyTemp, BloodPressure, Heartrate, Respiratoryrate, Date) VALUES (?, ?, ?, ?, ?, NOW())")) {
        stmt.setInt(1, admissionID); // Set AdmissionID
        stmt.setFloat(2, triage.getBodyTemp());
        stmt.setFloat(3, triage.getBloodPressure());
        stmt.setFloat(4, triage.getHeartRate());
        stmt.setFloat(5, triage.getRespiratoryRate());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new record has been inserted into the triage table.");
        } else {
            System.out.println("Failed to insert a new record into the triage table.");
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }

    return triage;
}

  
    public Lab submitLab(Lab lab) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO labtests (AdmissionID, TestName, TestResults, TestDate) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1,    lab.getAdmissionId());
            stmt.setString(2, lab.getTestName());
            stmt.setString(3, lab.getTestResult());
            stmt.setString(4, lab.getTestDate());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record has been inserted into the labtests table.");
            } else {
                System.out.println("Failed to insert a new record into the labtests table.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return lab;
    }
     public boolean submitAdmission(String regNumber) {
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO admissions (regNumber, AdmissionDate) VALUES (?, NOW())")) {
            stmt.setString(1, regNumber);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return success;
    }
    
    //retrive data
 public List<Prescription> getPrescriptionsWithRegNumber() {
    List<Prescription> prescriptionList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
       PreparedStatement stmt = conn.prepareStatement("SELECT p.*, s.regNumber " +
                                                 "FROM prescription p " +
                                                 "JOIN admissions a ON p.admissionID = a.admissionID " +
                                                 "JOIN student s ON a.studentID = s.id");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Prescription prescription = new Prescription();
            prescription.setDrugName(rs.getString("DrugName"));
            prescription.setDosage(rs.getString("Dosage"));
            prescription.setPrescribingPhysician(rs.getString("PrescribingPhysician"));
            prescription.setRegNumber(rs.getString("regNumber"));
            prescriptionList.add(prescription);
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return prescriptionList;
}

    
public List<Reception> getReceptions() {
    List<Reception> receptionList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Reception reception = new Reception();
            reception.setRegNumber(rs.getString("RegNumber"));
            reception.setFirstName(rs.getString("FirstName"));
            reception.setLastName(rs.getString("LastName"));
            reception.setGender(rs.getString("Gender"));
            receptionList.add(reception);
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return receptionList;
}

public Reception getReceptionByRegNumber(String regNumber) {
    Reception reception = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE RegNumber = ?");
            ) {
        stmt.setString(1, regNumber);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                reception = new Reception();
                reception.setRegNumber(rs.getString("RegNumber"));
                reception.setFirstName(rs.getString("FirstName"));
                reception.setLastName(rs.getString("LastName"));
                reception.setGender(rs.getString("Gender"));
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return reception;
}
public List<Admission> getAdmissions() {
    List<Admission> admissions = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  admissions");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Admission admission = new Admission();
                admission.setAdmissionID(rs.getInt("AdmissionID"));
                admission.setStudentID(rs.getString("regNumber"));
                java.sql.Timestamp timestamp = rs.getTimestamp("AdmissionDate");
                if (timestamp != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String admissionDateString = dateFormat.format(timestamp);
                    admission.setAdmissionDate(admissionDateString);
                }
                admissions.add(admission);
            }
        }
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
    }
    return admissions;
}

public List<Doctor> getDoctors() {
    List<Doctor> doctorList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM doctors");
            ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Doctor doctor = new Doctor();
            doctor.setObservation(rs.getString("observation"));
            doctor.setExamination(rs.getString("examination"));
            doctor.setDiagnosis(rs.getString("diagnosis"));
            doctor.setRecommendations(rs.getString("recommendation"));
            doctor.setPrescription(rs.getString("prescription"));
            doctorList.add(doctor);
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return doctorList;
}
public List<Triage> getTriageRecords() {
    List<Triage> triageList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT t.*, a.regNumber, a.admissionDate FROM triage t JOIN admissions a ON t.admissionID = a.admissionID");
            ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Triage triage = new Triage();
            triage.setBodyTemp(rs.getFloat("bodyTemp"));
            triage.setBloodPressure(rs.getFloat("BloodPressure"));
            triage.setHeartRate(rs.getFloat("Heartrate"));
            triage.setRespiratoryRate(rs.getFloat("Respiratoryrate"));
            triage.setTriageDate(rs.getString("Date"));
            triage.setAdmissionID(rs.getInt("admissionID"));
            triage.setStudentID(rs.getString("regnumber"));
            triage.setTriageDate(rs.getString("admissionDate"));
            triageList.add(triage);
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return triageList;
}
public List<Lab> getLabTests() {
    List<Lab> labList = new ArrayList<>();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM labtests");
            ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Lab lab = new Lab();
            lab.setAdmissionId(rs.getInt("AdmissionID"));
            lab.setTestName(rs.getString("TestName"));
            lab.setTestResult(rs.getString("TestResults"));
            lab.setTestDate(rs.getString("TestDate"));
            labList.add(lab);
        }
    } catch (SQLException e) {
        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
    return labList;
}


    
}
