package com.home.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcUtilWithDataSource {
	
	private static final String DB_DRIVER_CLASS="driver.class.name";
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	private static final String DB_URL="db.url";
	private static MysqlDataSource dataSource=null;
	private static Properties properties=new Properties();
	
	static {
		try {
			properties.load(new FileInputStream("src/database.properties"));
			dataSource=new MysqlDataSource();
			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUser(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
