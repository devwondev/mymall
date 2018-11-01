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
	<c:if test="${loginMember.id == null}">
		<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
		<a href="${pageContext.request.contextPath}/LoginController">로그인</a>
	</c:if>
	<c:if test="${loginMember.id != null}">
		${loginMember.id}님 반갑습니다.${loginMember.level}
		<a href="${pageContext.request.contextPath}/LogoutController">로그아웃</a><br>
	<c:if test="${loginMember.level == 1}">
		<a href="">회원리스트</a>
		<a href="${pageContext.request.contextPath}/ItemListController">상품리스트</a>
	</c:if>
	<c:if test="${loginMember.level == 0}">
		<a href="">마이페이지</a>
		<a href="${pageContext.request.contextPath}/ItemListController">상품리스트</a>
	</c:if>
	</c:if>
</body>
</html>