<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/IndexController">메인화면</a>
	</div>
	<h1>Item List</h1>
	<table>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품가격</td>
			<td>주문</td>
		</tr>
		<c:forEach var="itemList" items="${itemList}">
			<tr>
				<td>${itemList.no}</td>
				<td>${itemList.name}</td>
				<td>${itemList.price}</td>
				<td>
					<c:if test="${loginMemberNo != null}">
						<a href="${pageContext.request.contextPath}/OrderController?itemNo=${itemList.no}">주문하기</a>
					</c:if>
					<c:if test="${loginMemberNo == null}">
						<a href="${pageContext.request.contextPath}/LoginController">로그인하기</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</table>
		<c:if test="${pageAction.currentPage > 1}">
			<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${pageAction.currentPage-1}">[이전]</a>
		</c:if>
		<c:if test="${pageAction.currentPage < pageAction.lastPage}">
			<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${pageAction.currentPage+1}">[다음]</a>
		</c:if>
		
</body>
</html>