package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	public void deleteMemberItem(Connection conn, int no) {
		//PreparedStatement stmt = conn.prepareStatement("");
	}
	// 주문 입력 처리
	public void insertMemberItem(MemberItem memberItem) {
		System.out.println("MemberItemDao.insertMemberItem()");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("INSERT INTO member_item(member_no, item_no, order_date) VALUES(?,?,now())");
			stmt.setInt(1, memberItem.getMemberNo());
			stmt.setInt(2, memberItem.getItemNo());
			stmt.executeUpdate();
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(null, stmt, conn);
		}
	}
	// 주문리스트
	// MemberItem INNER JOIN item 
	public ArrayList<HashMap<String, Object>> MemberItemList(int memberNo){
		System.out.println("MemberItemDao.MemberItemList()");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT mi.no, mi.item_no, i.name, i.price, mi.order_date FROM member_item mi INNER JOIN item i ON mi.item_no = i.no WHERE mi.member_no=?");
			stmt.setInt(1, memberNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("memberItemNo", rs.getInt("no"));
				map.put("itemNo", rs.getInt("item_no"));
				map.put("itemName", rs.getString("name"));
				map.put("itemPrice", rs.getInt("price"));
				map.put("orderDate", rs.getString("order_date"));
				list.add(map);
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
}
