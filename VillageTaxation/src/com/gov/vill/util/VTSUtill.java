package com.gov.vill.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class VTSUtill {

	private static Connection conn;

	public static Connection getJDBCConnection() {
		if (null == conn) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.53.181:1521:real", "ezecash", "ezecash");
				System.out.println("Connected successfully");
				
			} catch (Exception e) {
				System.out.println("Exception while connecting to JDBC");
			}
		}
		return conn;
	}
}
