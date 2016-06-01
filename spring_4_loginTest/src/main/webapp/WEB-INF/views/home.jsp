<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${member.id == null }">
<p><a href="./member/login">Login</a></p>
<p><a href="./member/join">Join</a></p>
</c:if>
<c:if test="${member.id != null }">
${member.name}님 로그인중
<p><a href="./member/logout">Logout</a></p>
</c:if>
</body>
</html>
