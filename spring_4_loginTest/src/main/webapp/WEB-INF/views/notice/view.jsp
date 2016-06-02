<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr><td>작성자</td><td>${view.id}</td></tr>
		<tr><td>제   목</td><td>${view.title}</td></tr>
		<tr><td>내   용</td><td>${view.contents}</td></tr>
	</table>
</body>
</html>