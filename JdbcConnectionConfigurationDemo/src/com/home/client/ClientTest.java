package com.home.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.home.util.JdbcUtil;
import com.home.util.JdbcUtil2;
import com.home.util.JdbcUtil3;
import com.home.util.JdbcUtilWithDataSource;
import com.home.util.JdbcUtilWithProprtyFile;

public class ClientTest {

	public static void main(String[] args) {
		
		Connection connection=JdbcUtil.getConnection();
		if(connection != null)
			System.out.println("Connection created successfully by first way!!!");
		System.out.println("---------------------------------------");
		Connection connection2=JdbcUtil2.getConnection();
		if(connection2 != null)
			System.out.println("Connection created successfully by second way!!!");
		System.out.println("---------------------------------------");
		Connection connection3=JdbcUtil3.getConnection();
		if(connection3 != null)
			System.out.println("Connection created successfully  by third way!!!");
		System.out.println("---------------------------------------");
		Connection connection4=JdbcUtilWithProprtyFile.getConnection();
		if(connection4 != null)
			System.out.println("Connection created successfully  by property file way!!!");
		
		try(Connection connection5=JdbcUtilWithDataSource.getDataSource().getConnection();
				Statement statement=connection5.createStatement()){
			String SQL="select * from employee_table";	
			ResultSet rs = statement.executeQuery(SQL);
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name=rs.getString("employee_name");
				String email=rs.getString("email");
				Double salary=rs.getDouble("salary");
				Date joiningDate=rs.getDate("date_of_joining");
				BigDecimal bonus=rs.getBigDecimal("bonus");
				System.out.println("EmployeeId: "+employee_id);
				System.out.println("Employee name: "+employee_name);
				System.out.println("Email: "+email);
				System.out.println("Employee joining date: "+joiningDate);
				System.out.println("Bonus: "+bonus);
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
