<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3 align="center"><a href="./write">글쓰기</a></h3>
  <table align="center">
  <tr><td>번호</td><td>제목</td><td>글쓴이</td><td>날짜</td></tr>
  <c:forEach items="${list}" var="ar">
  	<tr><td>${ar.num}</td><td>${ar.title}</td><td>${ar.id}</td><td>${ar.reg_date }</td></tr>	
  </c:forEach>
  
  </table>

	
</body>
</html>