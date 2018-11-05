<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderList</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/IndexController">메인화면</a>
	</div>
	<h1>orderList</h1>
	<table>
		<tr>
			<td>주문번호</td>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품가격</td>
			<td>주문일자</td>
		</tr>
		<c:forEach var="order" items ="${memberItemList}">
		<tr>
			<td>${order.memberItemNo}</td>
			<td>${order.itemNo}</td>
			<td>${order.itemName}</td>
			<td>${order.itemPrice}</td>
			<td>${order.orderDate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>