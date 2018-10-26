package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원가입
	public void insertMember(Member member) throws Exception {
		System.out.println("MemberDao.insertMember()");
		DBHelper db = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("INSERT INTO member(id,pw) VALUES(?,?)");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.executeUpdate();
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			db.close(null, stmt, conn);
		}
	}
	
	// 로그인
	public boolean loginMember(Member member) {
		System.out.println("MemberDao.loginMember()");
		boolean isLogin = false;
		DBHelper db = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT id FROM member WHERE id=? AND pw=?");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				isLogin = true;
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			db.close(rs, stmt, conn);
		}
		return isLogin;
	}
}
