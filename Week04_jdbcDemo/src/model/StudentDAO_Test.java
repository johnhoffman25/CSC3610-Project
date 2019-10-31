package model;

import java.sql.*;

/**
 * Student database access object.
 *
 */

public class StudentDAO_Test extends BaseDAO {

	public StudentDAO_Test() {
		System.out.println("StudentDAO_Test Instantiated");
	}

	/**
	 * Create table if it does not exist.
	 */
	public void createIfNone() {

		boolean createTable = false;
		final String DATABASE_NAME = "au_patient";
		final String CREATE_TABLE = "create table patients ";
		final String patientID = "(patientID integer not null auto_increment, ";
		final String fname = "fname varchar(255), ";
		final String lname = "lname varchar(255), ";
		final String email = "email varchar(255), ";
		final String address = "address varchar(255), ";
		final String phone = "phone varchar(255), ";
		final String dob = "dob varchar(255)";

		try (Connection connection = this.getConnection()) {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("Checking metaData for table.");
			System.out.print("\n\n");

			// Find a list of all table contained on the MySQL database server using
			// catalogs
			ResultSet resultSet = databaseMetaData.getCatalogs();
			System.out.println("Result Set returned.");
			System.out.println("Looping through Result Set.");
			System.out.print("\n\n");

			// Search for the name of table
			while (resultSet.next()) {
				String catalogs = resultSet.getString(1);
				if (DATABASE_NAME.equals(catalogs)) {
					System.out.print("\nDatabase exists.\n");
					createTable = false;
				} else {
					System.out.print("\nNo table of that name.\n");
					createTable = true;
					System.out.print("Variable createTable set: true");
				}
			}

			System.out.print("\n\n");
			if (createTable) {
				PreparedStatement preparedStatement = connection
						.prepareStatement(CREATE_TABLE + patientID + fname + lname + email + address + phone + dob);
				preparedStatement.execute();
				System.out.print("\nPrepared Statement executed..");
				System.out.print("\nCreated new table.\n");
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

	}

	public void addNewPatient(String patientID, String fname, String lname, String email, String address, String phone,
			String dob) {

		try (Connection connection = this.getConnection()) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO au_patient(patientID, fname, lname, email, address, phone, dob)"
							+ " VALUES ('" + patientID + "', '" + fname + "', '" + lname + "', '" + email + "', '"
							+ address + "', '" + phone + "', '" + dob + "' )");
			preparedStatement.execute();
			System.out.print("\nConnected to database!\nNew patient was added successfully\n");
			// lblDisplay.setText();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
}
