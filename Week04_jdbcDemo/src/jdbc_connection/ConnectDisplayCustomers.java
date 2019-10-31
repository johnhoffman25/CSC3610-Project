//Connecting to a database, querying the database,
package jdbc_connection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectDisplayCustomers {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost:3306/saleco_mysql?serverTimezone=UTC";
		final String SELECT_QUERY = "SELECT CUS_CODE, CUS_LNAME, CUS_FNAME, CUS_INITIAL, CUS_AREACODE, CUS_PHONE, CUS_BALANCE FROM CUSTOMER";
		// Use try-catch resources to connect to and query the database
		try {
			Connection conn = DriverManager.getConnection(DB_URL, "jhoffman", "lacrosse123");

			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery((SELECT_QUERY));

			// Retrieve ResultSet's meta data
			ResultSetMetaData mData = rset.getMetaData();
			int numberOfColumns = mData.getColumnCount();
			System.out.printf("A table of Customers in saleco_mysql DBase:%n%n");

			// Display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.printf("%-10s\t", mData.getColumnName(i));
			}
			System.out.println();
			// Display the query results
			while (rset.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.printf("%-10s\t", rset.getObject(i));
				}
				System.out.println();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
