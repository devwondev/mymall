package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	// 주문목록 삭제
	public void deleteMemberItem(Connection conn, int no) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM member_item WHERE member_no=?");
		stmt.setInt(1, no);
		stmt.executeUpdate();
		stmt.close();
	}
	// 주문 입력 처리
	public void insertMemberItem(Connection conn, MemberItem memberItem) throws SQLException {
		System.out.println("MemberItemDao.insertMemberItem()");
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement("INSERT INTO member_item(member_no, item_no, order_date) VALUES(?,?,now())");
		stmt.setInt(1, memberItem.getMemberNo());
		stmt.setInt(2, memberItem.getItemNo());
		stmt.executeUpdate();
		stmt.close();
	}
	// 주문리스트
	// MemberItem INNER JOIN item 
	public ArrayList<HashMap<String, Object>> MemberItemList(Connection conn, int memberNo) throws SQLException{
		System.out.println("MemberItemDao.MemberItemList()");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
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
		rs.close();
		stmt.close();
		return list;
	}
}
