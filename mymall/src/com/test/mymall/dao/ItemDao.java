package com.test.mymall.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Item;

public class ItemDao {
	// 상품리스트 페이징
	public List<Item> itemSelect(SqlSession sqlSession, HashMap<String, Object> map){
		System.out.println("ItemDao.itemSelect()");
		// 여러개 리턴할 때 selectList
		return sqlSession.selectList("com.test.mymall.dao.ItemMapper.itemSelect", map);
	}
	// 전체카운트
	public int getItemCount(SqlSession sqlSession){
		System.out.println("ItemDao.getItemCount()");
		// 한개만 리턴할 때 selectOne
		return sqlSession.selectOne("com.test.mymall.dao.ItemMapper.getItemCount");
	}
		
}
	

