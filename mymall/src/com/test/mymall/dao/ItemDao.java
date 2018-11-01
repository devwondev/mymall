package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	// 상품리스트
	public ArrayList<Item> itemSelect(){
		System.out.println("ItemDao.itemSelect()");
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement("SELECT no, name, price FROM item ORDER BY no");
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
	
}
