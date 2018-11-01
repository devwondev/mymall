<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.mymall.vo.Item"%>

<%
ArrayList<Item> itemList = (ArrayList<Item>)request.getAttribute("itemList");
int listCount = ((Integer)request.getAttribute("listCount")).intValue();
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
int startPage = ((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Item List</h1>
	<table>
<%
if(listCount > 0){
%>
		<tr>
			<td>상품 리스트</td>
			<td>상품수 : ${listCount}</td>
		</tr>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품가격</td>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr>
				<td>${item.no}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td><a href="${pageContext.request.contextPath}/OrderController?itemNo=${item.no}">주문하기</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${currentPage<=1}">
					[이전]
				</c:if>
				<c:if test="${currentPage>1}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${currentPage-1}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<c:if test="${currentPage == i}">
						${i}
					</c:if>
					<c:if test="${currentPage != i}">
						<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${currentPage>=maxPage}">
					[다음]
				</c:if>
				<c:if test="${currentPage<maxPage}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${currentPage+1}">[다음]</a>
				</c:if>
			</td>
		</tr>
<%
}else{
%>	
		<tr>
			<td>상품 리스트</td>
			<td>등록된 상품이 없습니다.</td>
		</tr>
<%
}
%>
	</table>
</body>
</html>