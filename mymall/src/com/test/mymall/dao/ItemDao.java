package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	// 상품리스트
	public ArrayList<Item> itemSelect(int currentPage, int rowPerPage){
		System.out.println("ItemDao.itemSelect()");
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT no, name, price FROM item ORDER BY no LIMIT ? , ?");
			stmt.setInt(1, (currentPage-1)*rowPerPage);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setNo(rs.getInt("no"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				itemList.add(item);
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return itemList;
	}
	// 전체 카운트
	public int getItemCount() {
		System.out.println("ItemDao.getItemCount()");
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT COUNT(*) FROM item");
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
