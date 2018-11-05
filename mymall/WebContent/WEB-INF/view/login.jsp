<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="${pageContext.request.contextPath}/LoginController" method="post">
		id : <input type = "text" name = "id"><br>
		pw : <input type = "text" name = "pw"><br>
		<input type = "submit" value="로그인">
	</form>
</body>
</html>