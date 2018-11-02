package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.MemberItem;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private MemberItemDao memberItemDao;
	private MemberItemService memberItemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		// 로그인 처리할때, 세션에 객체를 저장했는데 그렇게하면 나중에 불편하니까 보낼때부터 no, id, level 각자 보내자!!
		// 잘받았는지 콘솔에 확인 자주 하기!!
		int memberNo = (int)request.getSession().getAttribute("loginMemberNo");
		memberItemService = new MemberItemService();
		memberItemDao = new MemberItemDao();
		MemberItem memberItem = new MemberItem();
		memberItem.setItemNo(itemNo);
		memberItem.setMemberNo(memberNo);
		memberItemService.insertMemberItem(memberItem);
		response.sendRedirect(request.getContextPath()+"/OrderListController");
	}
}
