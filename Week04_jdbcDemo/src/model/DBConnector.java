package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
	
	public static Connection getConnection() throws SQLException{
		final String DB_URL = "jdbc:mysql://localhost:3306/Spartan_Healthcare?serverTimezone=UTC";
		
		Connection connection = DriverManager.getConnection(DB_URL, "root", "lacrosse123");
		
		return connection;
	}
}
