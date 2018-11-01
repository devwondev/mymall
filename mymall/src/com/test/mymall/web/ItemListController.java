package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

@WebServlet("/ItemListController")
public class ItemListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController.doGet()");
		Item item= new Item();
		ItemDao itemDao = new ItemDao();
		int currentPage = 1;
		int rowPerPage =5;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = itemDao.getItemCount();	// 총 리스트 수 받아온다.
		ArrayList<Item> itemList = itemDao.itemSelect(currentPage, rowPerPage);	// 리스트 받아온다.
		// 총 페이지 수
		int maxPage = (int)((double)listCount/rowPerPage+0.95);	// 0.95를 더해서 올림 처리
		// 현재 페이지에 보여줄 시작 페이지 수
		int startPage = (((int) ((double)currentPage / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수
		int endPage = startPage+10-1;
		
		if(endPage>maxPage) endPage = maxPage;
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCount", listCount);
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request,response);
	}
}
