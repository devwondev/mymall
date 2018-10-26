package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	// 드라이버 로딩
	public static Connection getConnection() throws Exception{
		System.out.println("DBHelper.Connection");
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPassword = "java0000";
		Connection conn = null;
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPassword);
		return conn;
	}
	// 객체 종료
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
            try {rs.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(stmt != null) {
            try {stmt.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(conn != null) {
            try {conn.close();} catch(Exception exception){exception.printStackTrace();}
        }
	}
}
