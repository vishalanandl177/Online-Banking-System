package com.project.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
	private static Connection connection=null;
	//For establishing connection with SQL
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","bhanu");
		return connection;
	}
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
