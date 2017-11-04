package com.jcuadros.homework.three;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	private Connection conn;
	
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1:3306/csc322";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public MyConnection() throws SQLException, ClassNotFoundException{
		
		conn = DriverManager.getConnection(CONNECTION,USER, PASSWORD);
	};
	
	public Connection getConn(){
		return conn;
	}
	
	public void closeConn() throws SQLException{
		conn.close();
	}
	
	
	

}
