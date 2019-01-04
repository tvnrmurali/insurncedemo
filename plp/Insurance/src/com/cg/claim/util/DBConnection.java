package com.cg.claim.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	static Connection connection = null;
	
	public static Connection getConnection() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("resources/db.properties");
		
		properties.load(fis);
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		fis.close();
		
		return connection;
	}
	
}
