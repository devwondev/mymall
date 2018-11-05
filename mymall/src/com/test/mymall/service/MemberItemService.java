package com.test.mymall.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	SqlSession sqlSession;
	private MemberItem memberItem;
	private MemberItemDao memberItemDao;
	// 주문입력처리
	public void insertMemberItem(MemberItem memberItem) {
		System.out.println("MemberItemService.insertMemberItem()");
		memberItemDao = new MemberItemDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao.insertMemberItem(sqlSession, memberItem);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	// 주문리스트
	public List<HashMap<String, Object>> MemberItemList(int memberNo){
		System.out.println("MemberItemService.MemberItemList()");
		memberItemDao = new MemberItemDao();
		List<HashMap<String, Object>> memberItemList = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemList = memberItemDao.memberItemList(sqlSession, memberNo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return memberItemList;
	}
}
