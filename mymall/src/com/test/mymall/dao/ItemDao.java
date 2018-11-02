package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	//mybatis select
	/*public List<Item> selectItemList(SqlSession sqlSession){
	 * sqlSession.selectList(id명,매개변수);	//매개변수없으면 안적어도됨..
	 * sqlSession.selectList("com.test.mymall.dao.ItemMapper.selectItemList");
	 * return list;
	 * */
	//mybatis insert
	/*public int insertItem(SqlSession sqlSession, Item item) {
		return sqlSession.insert("",item);
	}*/
	// 상품리스트
	public ArrayList<Item> itemSelect(Connection conn, HashMap<String, Object> map) throws SQLException{
		System.out.println("ItemDao.itemSelect()");
		ArrayList<Item> itemList = new ArrayList<Item>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		stmt = conn.prepareStatement("SELECT no, name, price FROM item ORDER BY no LIMIT ?,?");
		stmt.setInt(1, (int)map.get("startRow"));
		stmt.setInt(2, (int)map.get("rowPerPage"));
		rs = stmt.executeQuery();
		while(rs.next()) {
			Item item = new Item();
			item.setNo(rs.getInt("no"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getInt("price"));
			itemList.add(item);
		}
		stmt.close();
		rs.close();
		return itemList;
	}
	// 전체카운트
	public int getItemCount(Connection conn) throws SQLException {
		System.out.println("ItemDao.getItemCount()");
		int count = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		stmt = conn.prepareStatement("SELECT COUNT(*) FROM item");
		rs = stmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		stmt.close();
		rs.close();
		return count;
	}
		
}
	

