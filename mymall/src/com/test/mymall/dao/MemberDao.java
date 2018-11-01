package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원가입
	public void insertMember(Member member) {
		System.out.println("MemberDao.insertMember()");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("INSERT INTO member(id,pw) VALUES(?,?)");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.executeUpdate();
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(null, stmt, conn);
		}
	}
	
	// 로그인 (권한, 아이디)
	public Member login(Member member) {
		System.out.println("MemberDao.login()");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member memberCheck = new Member();
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT no,id,level FROM member WHERE id=? AND pw=?");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				memberCheck.setNo(rs.getInt("no"));
				memberCheck.setId(rs.getString("id"));
				memberCheck.setLevel(rs.getInt("level"));
			}else {
				memberCheck.setId(null);
			}
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return memberCheck;
	}
	
	// 회원탈퇴(회원탈퇴되면 주문취소되야함->트랜잭션 Rollback)
	public void deleteMember(int no) {
		
	}
}
