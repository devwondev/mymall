package com.test.mymall.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	// 상품 리스트
	public List<Item> selectItemList(HashMap<String, Object> map) {
		System.out.println("ItemService selectItemList");
		SqlSession sqlSession=null;
		List<Item> list=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			// 페이지 당 보여줄 글 목록
			int rowPerPage=10;
			// 현재 페이지 1 이면, 0행부터, 2이면 10행부터
			int startRow = ((int)map.get("currentPage")-1)*rowPerPage;
			map.put("startRow", startRow);
			map.put("pagePerRow", rowPerPage);
			this.itemDao=new ItemDao();
			// 상품리스트 처리 메서드 호출
			list=itemDao.itemSelect(sqlSession, map);
			// 전체 갯수 세는 메서드 호출
			int count=itemDao.getItemCount(sqlSession);
			// 마지막 페이지 : 전체글 수를 rowPerPage로 나누어서 구함
			int lastPage=count/rowPerPage;
			// 나누어 떨어지지 않으면(전체글이 101개이고 10개로 나누면 마지막페이지는 11페이지)
			if(count % rowPerPage!=0) {
				lastPage++;
			}
			map.put("lastPage", lastPage);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
		return list;
	}
	
}
