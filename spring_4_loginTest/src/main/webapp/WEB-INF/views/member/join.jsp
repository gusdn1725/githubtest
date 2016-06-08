<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkId").click(function(){
			$.ajax({
				url : "idcheck",
				type : "POST",
				data:{
					id : $("#id").val()
				},
				success:function(result){
					alert(result);
				}
			});
		});
	});
</script>
</head>
<body>
<form action="./join" method="post">
	아이디 : <input type="text" id="id" name="id"><input type="button" id="checkId" value="ID중복확인"><br>
	비밀번호 :<input type="password" name="pw"><br>
	이름 : <input type="text" name="name"><br>
	나이 :<input type="text" name="age"><br>
	<input type="submit" value="Join">
</form>
</body>
</html>