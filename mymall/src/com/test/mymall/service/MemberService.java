package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	//회원정보수정해야함!!
	//DeleteMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		System.out.println("MemberService.removeMember()");
		Connection conn = null;
		try {
			// 처리할 connection 생성
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);// 자동 커밋하지않겠다..(이 부분 검색해보자)
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, no);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();	// 트랜잭션 공부..
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBHelper.close(null, null, conn);
		}
		
	}
	// 회원가입
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		Connection conn = null;
		memberDao = new MemberDao();
		try {
			conn = DBHelper.getConnection();
			memberDao.insertMember(conn, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
	}
	// 로그인
	public Member login(Member member) {
		System.out.println("MemberService.login()");
		Connection conn = null;
		System.out.println(member+"서비스member");
		memberDao = new MemberDao();
		Member memberCheck = null;
		try {
			conn = DBHelper.getConnection();
			memberCheck = memberDao.login(conn, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
		return memberCheck;
	}
}
