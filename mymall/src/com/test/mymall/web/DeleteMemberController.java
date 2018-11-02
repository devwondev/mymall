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
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteMemberController.doGet()");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMemberNo") != null) {
			memberService = new MemberService();
			int memberNo = (int)request.getSession().getAttribute("loginMemberNo");
			System.out.println(memberNo+"<--memberNo DeleteMemberController");
			memberService.removeMember(memberNo);
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
	}
}
