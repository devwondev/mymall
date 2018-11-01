package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int memberNo = (int)request.getSession().getAttribute("loginMemberNo");
		memberItemDao = new MemberItemDao();
		MemberItem memberItem = new MemberItem();
		memberItem.setItemNo(itemNo);
		memberItem.setMemberNo(memberNo);
		memberItemDao.insertMemberItem(memberItem);
		response.sendRedirect(request.getContextPath()+"/OrderListController");
	}
}