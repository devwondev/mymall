package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	// 상품리스트
	public ArrayList<Item> itemSelect(){
		System.out.println("ItemService.itemSelect()");
		Connection conn = null;
		ArrayList<Item> itemList = null;
		try {
			conn = DBHelper.getConnection();
			itemDao = new ItemDao();
			itemList = itemDao.itemSelect(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
		return itemList;
	}
}
