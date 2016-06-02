<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	var x=0;
	for(;x<=20;x+=2){
		document.write(x);
	}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:if test="${msg != null }">
<p>${msg}</p>
</c:if>

<c:if test="${member == null }">
<p><a href="./member/login">Login</a></p>
<p><a href="./member/join">Join</a></p>
</c:if>
<c:if test="${member != null }">
${member.name}님 로그인중
<p><a href="./member/update">MemberUpdate</a></p>
<p><a href="./member/delete">MemberDelete</a></p>
<p><a href="./member/logout">Logout</a></p>
</c:if>
<h2><a href="./notice/list?curPage=1">게시판</a></h2>
</body>
</html>
