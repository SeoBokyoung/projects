package kr.co.jboard1.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {


	// DB정보
	private static final String HOST = "jdbc:mysql://192.168.0.178:3306/sbk";
	private static final String USER = "sbk";
	private static final String PASS = "1234";
	
	public static Connection getConnect() throws Exception {
		
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn;
		
	}
	
}
