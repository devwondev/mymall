package com.test.mymall.commons;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBHelper {
	public static Connection getConnection() throws Exception{
		return null;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		/*if(rs != null) {
			rs.close();
		}*/
	}
}
