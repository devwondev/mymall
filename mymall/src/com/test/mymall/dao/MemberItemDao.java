package com.test.mymall.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	// 주문목록 삭제
	public void deleteMemberItem(SqlSession sqlSession, int no){
		System.out.println("MemberItemDao.deleteMemberItem()");
		sqlSession.delete("com.test.mymall.dao.MemberItemMapper.deleteMemberItem", no);
	}
	// 주문 입력 처리
	public void insertMemberItem(SqlSession sqlSession, MemberItem memberItem){
		System.out.println("MemberItemDao.insertMemberItem()");
		sqlSession.insert("com.test.mymall.dao.MemberItemMapper.insertMemberItemList", memberItem);
	}
	// 주문리스트
	// MemberItem INNER JOIN item 
	public List<HashMap<String, Object>> memberItemList(SqlSession sqlSession, int memberNo){
		System.out.println("MemberItemDao.MemberItemList()");
		return sqlSession.selectList("com.test.mymall.dao.MemberItemMapper.memberItemList", memberNo);
	}
}
