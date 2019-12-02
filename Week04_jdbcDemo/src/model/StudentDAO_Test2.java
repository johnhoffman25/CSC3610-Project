package model;

import java.sql.*;

/**
 * Student database access object.
 *
 */

public class StudentDAO_Test2 extends BaseDAO {

	public StudentDAO_Test2() {
		System.out.println("StudentDAO_Test2 Instantiated");
	}

	/**
	 * Create table if it does not exist.
	 */
	public void createIfNone() {

		boolean createTable = false;
		final String DATABASE_NAME = "Spartan_Healthcare";
		final String CREATE_TABLE = "create table USERS ";
		final String userID = "(USER_ID integer not null, ";
		final String password = "PASSWORD varchar(50));";

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
						.prepareStatement(CREATE_TABLE + userID + password);
				preparedStatement.execute();
				System.out.print("\nPrepared Statement executed..");
				System.out.print("\nCreated new table.\n");
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

	}

	public void addNewUser(String patientID, String password) {

		try (Connection connection = this.getConnection()) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO USERS(USER_ID, PASSWORD)"
							+ " VALUES ('" + patientID + "', '" + password + "' )");
			preparedStatement.execute();
			System.out.print("\nConnected to database!\nNew user was added successfully\n");
			// lblDisplay.setText();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
}
