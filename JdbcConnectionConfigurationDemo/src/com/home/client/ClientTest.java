package com.home.client;

import java.sql.Connection;

import com.home.util.JdbcUtil;
import com.home.util.JdbcUtil2;
import com.home.util.JdbcUtil3;
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
	}

}
