package com.test.mymall.service;


import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	// 회원정보수정
	public void modifyMember(Member member) {
		System.out.println("MemberService.modifyMember()");
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao = new MemberDao();
			memberDao.modifyMember(sqlSession, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	// 한명의 회원정보조회
	public Member selectMember(String id) {
		System.out.println("MemberService.selectMember()");
		SqlSession sqlSession = null;
		Member member = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao = new MemberDao();
			member = memberDao.selectMember(sqlSession, id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member;
	}
	// 회원탈퇴
	public void removeMember(int no) {
		System.out.println("MemberService.removeMember()");
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(sqlSession, no);
			memberDao = new MemberDao();
			memberDao.deleteMember(sqlSession, no);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		
	}
	// 회원가입
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	// 로그인
	public Member login(Member member) {
		System.out.println("MemberService.login()");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		Member memberCheck = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberCheck = memberDao.login(sqlSession, member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return memberCheck;
	}
}
