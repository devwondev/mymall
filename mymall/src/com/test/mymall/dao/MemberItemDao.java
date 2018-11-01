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
	// MemberItem INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo){
		System.out.println("MemberItemDao.getMemberItemList()");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no WHERE mi.member_no=?");
			stmt.setInt(1, memberNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("memberItemNo", rs.getInt(1));
				map.put("itemNO", rs.getInt(2));
				map.put("itemName", rs.getString(3));
				map.put("itemPrice", rs.getInt(4));
				map.put("orderDate", rs.getString(5));
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
