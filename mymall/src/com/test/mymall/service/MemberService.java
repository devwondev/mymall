package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	//MemberDao 호출
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	//RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		Connection conn = null;
		try {
			// 두개 function 묶어서 처리할 connection 생성
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);// 자동 커밋하지않겠다..트랜잭션하려면 무조건 커밋 잠궈놔야함.
			// 1. function
			memberDao = new MemberDao();
			//memberDao.deleteMember(conn, no);
			// 2. function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBHelper.close(null, null, conn);
		}
		
	}
	public void addMember(Member member) {
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
