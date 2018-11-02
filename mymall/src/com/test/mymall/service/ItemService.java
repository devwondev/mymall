package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	// 상품 리스트
	public ArrayList<Item> itemSelect(HashMap<String, Object> map){
		System.out.println("ItemService.itemSelect()");
		Connection conn = null;
		ArrayList<Item> itemList = null;
		try {
			conn = DBHelper.getConnection();
			itemDao = new ItemDao();
			// 페이지 당 보여줄 글 목록
			int rowPerPage = 5;
			map.put("rowPerPage", rowPerPage);
			// 현재 페이지 1 이면, 0행부터, 2이면 10행부터
			int startRow = ((int)map.get("currentPage")-1)*rowPerPage;
			map.put("startRow", startRow);
			// 상품리스트 처리 메서드 호출
			itemList = itemDao.itemSelect(conn, map);
			// 전체 갯수 세는 메서드 호출
			int itemCount = itemDao.getItemCount(conn);
			// 마지막 페이지 : 전체글 수를 rowPerPage로 나누어서 구함
			int lastPage = itemCount/rowPerPage;
			// 나누어 떨어지지 않으면(전체글이 101개이고 10개로 나누면 마지막페이지는 11페이지)
			if(itemCount%rowPerPage!=0) {
				lastPage++;
			}
			map.put("lastPage", lastPage);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
		}
		return itemList;
	}
	
}
