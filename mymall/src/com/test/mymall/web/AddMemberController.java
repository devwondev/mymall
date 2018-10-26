package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	// 1. 라우터
	// 2. 모델호출
	// 3. 뷰 랜더링
	//  컨트롤러가 필요로하는 dao는 무조건 위에..
	private MemberDao memberDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
	}

}
