package com.test.mymall.commons;

/*import java.io.IOException;
import java.io.InputStream;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;*/

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
	// mybatis close는 sqlsession을 클로즈하면 되기 때문에 close()메서드 필요없음..
	/*public static SqlSession getSqlSession(){
		InputStream inputStream = null;
		try {
		   String resource = "mybatis-config.xml";
		   inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
		   e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.commit();
		sqlSession.rollback();
		sqlSession.close();
		return sqlSession;

	 }*/
	 
}
