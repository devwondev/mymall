package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private MemberDao memberDao;
	// 로그인폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doGet()");
		if(request.getSession().getAttribute("loginMember") == null) {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			System.out.println("로그인 중입니다");
			response.sendRedirect(request.getContextPath()+"/index");
		}
	}
	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doPost()");
		boolean isLogin = false;
		Member member = new Member();
		memberDao = new MemberDao();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		member.setId(id);
		member.setPw(pw);
		isLogin = memberDao.loginMember(member);
		
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member.getId());
			response.sendRedirect(request.getContextPath()+"/index");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}

}
