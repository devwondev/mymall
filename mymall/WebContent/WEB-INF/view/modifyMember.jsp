<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMember</title>
</head>
<body>
	<h1>modifyMember</h1>
	<form action="${pageContext.request.contextPath}/ModifyMemberController" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="${member.id}" readonly></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>권한</th>
				<td><input type="text" name="level" value="${member.level}" readonly></td>
			</tr>
		</table>
			<input type="submit" value="비밀번호변경">
	</form>
</body>
</html>