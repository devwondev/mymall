package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;


@WebServlet("/ModifyMemberController")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	// 수정폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController.doGet()");
		String id = request.getParameter("id");
		memberService = new MemberService();
		Member member = memberService.selectMember(id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}

	// 수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController.doPost()");
		memberService = new MemberService();
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setLevel(Integer.parseInt(request.getParameter("level")));
		memberService.modifyMember(member);
		System.out.println(member.getPw()+"<--member.getPw()");
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
