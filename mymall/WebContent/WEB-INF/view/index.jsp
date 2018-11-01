<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<c:if test="${loginMemberId == null}">
		<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
		<a href="${pageContext.request.contextPath}/LoginController">로그인</a>
	</c:if>
	<c:if test="${loginMemberId != null}">
		${loginMemberId}님 반갑습니다.
		<a href="${pageContext.request.contextPath}/LogoutController">로그아웃</a><br>
	<c:if test="${loginMemberLevel == 1}">
		관리자
		<a href="">회원리스트</a>
		<a href="">상품리스트</a>
	</c:if>
	<c:if test="${loginMemberLevel == 0}">
		회원
		<a href="${pageContext.request.contextPath}/ModifyMemberController?memberId=${loginMemberId}">회원정보수정</a>
		<a href="${pageContext.request.contextPath}/DeleteMemberController?memberNo=${loginMemberNo}">회원탈퇴</a>
		<a href="${pageContext.request.contextPath}/ItemListController">상품리스트</a>
		<a href="${pageContext.request.contextPath}/OrderListController?memberNo=${loginMemberNo}">주문리스트</a>
	</c:if>
	</c:if>
</body>
</html>