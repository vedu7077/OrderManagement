package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/orderdb";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";
	
	
	// CONNECTION INTERFACE 
	
	static Connection conn = null;
	
	public static Connection getConnect() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			System.out.println("*************************************************");
System.out.println();
			System.out.println("..................Driver Loaded..................");
			System.out.println();
			System.out.println("*************************************************");

			
	//conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		
    conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	public static void main(String[] args) {
		getConnect();
	}

			

}
