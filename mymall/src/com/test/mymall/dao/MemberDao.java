package com.test.mymall.dao;


import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원수정
	public void modifyMember(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.modifyMember()");
		sqlSession.update("com.test.mymall.dao.MemberMapper.modifyMember", member);
	}
	// 한명의 회원정보조회
	public Member selectMember(SqlSession sqlSession,  String id){
		System.out.println("MemberDao.selectMember()");
		// 한개만 리턴할 때 selectOne
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.selectMember", id);
	}
	// 회원탈퇴(회원탈퇴되면 주문취소되야함->트랜잭션 Rollback)
	public void deleteMember(SqlSession sqlSession, int no){
		System.out.println("MemberDao.deleteMember()");
		sqlSession.delete("com.test.mymall.dao.MemberMapper.deleteMember", no);
	}
	// 회원가입
	public void insertMember(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.insertMember()");
		sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
	// 로그인 (권한, 아이디)
	public Member login(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.login()");
		// 한개만 리턴할 때 selectOne
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);
	}
	
	
}
