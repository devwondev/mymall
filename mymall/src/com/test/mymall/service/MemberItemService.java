package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	private MemberItem memberItem;
	private MemberItemDao memberItemDao;
	// 주문입력처리
	public void insertMemberItem(MemberItem memberItem) {
		System.out.println("MemberItemService.insertMemberItem()");
		Connection conn = null;
		memberItemDao = new MemberItemDao();
		try {
			conn = DBHelper.getConnection();
			memberItemDao.insertMemberItem(conn, memberItem);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
	}
	// 주문리스트
	public ArrayList<HashMap<String, Object>> MemberItemList(int memberNo){
		System.out.println("MemberItemService.MemberItemList()");
		Connection conn = null;
		memberItemDao = new MemberItemDao();
		ArrayList<HashMap<String, Object>> memberItemList = null;
		try {
			conn = DBHelper.getConnection();
			memberItemList = memberItemDao.MemberItemList(conn, memberNo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
		return memberItemList;
	}
}
