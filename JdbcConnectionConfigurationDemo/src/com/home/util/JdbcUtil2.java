package com.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil2 {
	
	private static final String DB_DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";
	private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdb";
	private static Connection connection=null;
	
	static {
		try {
			Class.forName(DB_DRIVER_CLASS);
			Properties info=new Properties();
			info.put("user", DB_USERNAME);
			info.put("password", DB_PASSWORD);
			connection=DriverManager.getConnection(DB_URL, info);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
