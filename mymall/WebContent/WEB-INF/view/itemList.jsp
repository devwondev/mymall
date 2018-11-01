<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>