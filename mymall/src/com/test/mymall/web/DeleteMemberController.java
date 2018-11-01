package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;


@WebServlet("/DeleteMemberController")
public class DeleteMemberController extends HttpServlet {
	MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제가 안됨....세션종료 후 인덱스로는 잘간다
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMemberNo") != null) {
			memberService = new MemberService();
			int memberNo = (int)request.getSession().getAttribute("loginMemberNo");
			memberService.removeMember(memberNo);
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
	}
}
