package com.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/testdb";
		Connection connection = DriverManager.getConnection(url,"root","root");
		
		Statement statement = connection.createStatement();
		System.out.println("Successfully connected to the database: "+statement);
		ResultSet resultSet = statement.executeQuery("Select * from student");
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("name")+ " " + resultSet.getInt("marks"));
		}
		
		
		
	}

}
