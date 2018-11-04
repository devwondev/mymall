package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원수정
	public void modifyMember(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao.modifyMember()");
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement("UPDATE member SET pw=? WHERE id=?");
		stmt.setString(1, member.getPw());
		stmt.setString(2, member.getId());
		stmt.executeUpdate();
		stmt.close();
	}
	// 한명의 회원정보조회
	public Member selectMember(Connection conn,  Member member) throws SQLException {
		System.out.println("MemberDao.selectMember()");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		stmt = conn.prepareStatement("SELECT id, level FROM member WHERE id=?");
		stmt.setString(1, member.getId());
		rs = stmt.executeQuery();
		Member memberSelect = new Member();
		if(rs.next()) {
			memberSelect.setId(rs.getString("id"));
			memberSelect.setLevel(rs.getInt("level"));
		}
		rs.close();
		stmt.close();
		return memberSelect;
	}
	// 회원탈퇴(회원탈퇴되면 주문취소되야함->트랜잭션 Rollback)
	public void deleteMember(Connection conn, int no) throws SQLException {
		System.out.println("MemberDao.deleteMember()");
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement("DELETE FROM member WHERE no=?");
		stmt.setInt(1, no);
		System.out.println(stmt+"<--stmt");
		stmt.executeUpdate();
		stmt.close();
	}
	// 회원가입
	public void insertMember(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao.insertMember()");
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement("INSERT INTO member(id,pw) VALUES(?,?)");
		stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.executeUpdate();
		stmt.close();
	}
	// 로그인 (권한, 아이디)
	public Member login(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao.login()");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member memberCheck = new Member();
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
		rs.close();
		stmt.close();
		return memberCheck;
	}
	
	
}
