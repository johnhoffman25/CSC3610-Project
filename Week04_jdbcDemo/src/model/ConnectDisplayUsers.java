//Connecting to a database, querying the database,
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectDisplayUsers {
	public static void main(String[] args) {

		ArrayList<User> userList = generateUserList();

		for (User user : userList) {
			System.out.println("UserID: " + user.getUserID());
			System.out.println("Password: " + user.getPassword());
		}
		
		ArrayList<Patient> patientList = generatePatientList();
		

		for (Patient patient : patientList) {
			System.out.println("PatientID: " + patient.getPATIENT_ID());
			System.out.println("Gender: " + patient.getGENDER());
			System.out.println("DOB: " + patient.getDOB());
			System.out.println("First Name: " + patient.getFNAME());
			System.out.println("Last Name: " + patient.getLNAME());
			System.out.println("Address: " + patient.getADDRESS());
			System.out.println("City: " + patient.getCITY());
			System.out.println("State: " + patient.getSTATE());
			System.out.println("Zipcode: " + patient.getZIPCODE());
			System.out.println("Email: " + patient.getEMAIL());
			System.out.println("Insurance: " + patient.getINSURANCE());
			System.out.println("Phone: " + patient.getPHONE());
			System.out.println("UserID: " + patient.getUSER_ID());			
		}
	}

	public static ArrayList<Patient> generatePatientList() {

		ArrayList<Patient> patientList = new ArrayList();

		final String DB_URL = "jdbc:mysql://localhost:3306/Spartan_Healthcare?serverTimezone=UTC";
		final String SELECT_QUERY = "SELECT PATIENT_ID, GENDER, DOB, FNAME, LNAME, ADDRESS, CITY, STATE, ZIPCODE, EMAIL, INSURANCE, PHONE, USER_ID FROM PATIENTS";

		// Use try-catch resources to connect to and query the database
		try {
			Connection conn = DriverManager.getConnection(DB_URL, "root", "lacrosse123");

			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery((SELECT_QUERY));

			// Retrieve ResultSet's meta data
			ResultSetMetaData mData = rset.getMetaData();
			int numberOfColumns = mData.getColumnCount();
			
			// Display the names of the columns in the ResultSet
//			for (int i = 1; i <= numberOfColumns; i++) {
//				System.out.printf("%-10s\t", mData.getColumnName(i));
//			}
//			System.out.println();

			while (rset.next()) {
				String patientID = rset.getString("PATIENT_ID");
				String gender = rset.getString("GENDER");
				String dob = rset.getString("DOB");
				String fname = rset.getString("FNAME");
				String lname = rset.getString("LNAME");
				String address = rset.getString("ADDRESS");
				String city = rset.getString("CITY");
				String state = rset.getString("STATE");
				String zipcode = rset.getString("ZIPCODE");
				String email = rset.getString("EMAIL");
				String insurance = rset.getString("INSURANCE");
				String phone = rset.getString("PHONE");
				String userID = rset.getString("USER_ID");
				
				Patient newPatient = new Patient(patientID, gender, dob, fname, lname, address, city, state, zipcode, email, insurance, phone, userID);
				patientList.add(newPatient);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return patientList;
	}

	public static ArrayList<User> generateUserList() {

		ArrayList<User> userList = new ArrayList();

		final String DB_URL = "jdbc:mysql://localhost:3306/Spartan_Healthcare?serverTimezone=UTC";
		final String SELECT_QUERY = "SELECT USER_ID, PASSWORD FROM USERS";

		// Use try-catch resources to connect to and query the database
		try {
			Connection conn = DriverManager.getConnection(DB_URL, "root", "lacrosse123");

			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery((SELECT_QUERY));

			// Retrieve ResultSet's meta data
			ResultSetMetaData mData = rset.getMetaData();
			int numberOfColumns = mData.getColumnCount();
			
			// Display the names of the columns in the ResultSet
//			for (int i = 1; i <= numberOfColumns; i++) {
//				System.out.printf("%-10s\t", mData.getColumnName(i));
//			}
//			System.out.println();

			while (rset.next()) {
				String userID = rset.getString("USER_ID");
				String password = rset.getString("PASSWORD");
				User newUser = new User(userID, password);
				userList.add(newUser);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return userList;
	}
}
