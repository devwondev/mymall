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

import com.test.mymall.service.MemberItemService;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		memberItemService = new MemberItemService();
		int memberNo = (int) request.getSession().getAttribute("loginMemberNo");
		ArrayList<HashMap<String, Object>> memberItemList = memberItemService.MemberItemList(memberNo);
		HttpSession session = request.getSession();
		request.setAttribute("memberItemList", memberItemList);
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}
}
