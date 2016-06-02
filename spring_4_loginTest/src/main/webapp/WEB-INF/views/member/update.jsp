<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./update" method="post">
	아이디 : <input type="text" name="id" value="${member.id}" readonly="readonly"><br>
	비밀번호 :<input type="password" name="pw" value="${member.pw}" readonly="readonly"><br>
	이름 : <input type="text" name="name" value="${member.name}"><br>
	나이 :<input type="text" name="age" value="${member.age}"><br>
	<input type="submit" value="Update">
</form>
</body>
</html>