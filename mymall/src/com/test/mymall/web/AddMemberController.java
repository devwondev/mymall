package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	// 1. 라우터
	// 2. 모델호출
	// 3. 뷰 랜더링
	//  컨트롤러가 필요로하는 dao는 무조건 위에..
	private MemberService memberService;
	private MemberDao memberDao;
	// 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	// 회원가입 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		memberService = new MemberService();
		memberDao = new MemberDao();
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		memberService.addMember(member);
		response.sendRedirect(request.getContextPath()+"/LoginController");
	}

}
