package org.mypack.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/mydbase";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Amu@0204";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		System.out.println("connection built");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}

//CREATE TABLE Users (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//	    username VARCHAR(50) NOT NULL,
//	    email VARCHAR(100) NOT NULL UNIQUE,
//	    password VARCHAR(255) NOT NULL
//	);
