package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		memberItemDao = new MemberItemDao();
		int memberNo = (int) request.getSession().getAttribute("loginMemberNo");
		ArrayList<HashMap<String, Object>> memberItemList = memberItemDao.MemberItemList(memberNo);
		HttpSession session = request.getSession();
		request.setAttribute("memberItemList", memberItemList);
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}
}
