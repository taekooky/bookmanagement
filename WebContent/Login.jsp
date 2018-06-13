<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<center><title>登录页面</title></center>  
</head>  
<body background="img/1.jpg">   
<center><h1>管理员登录</h1></center>  
<center>  
<%  
request.setCharacterEncoding("UTF-8");  
%>   
</center>  
<center>  
<form action="LoginServlet" method="post" onSubmit="return validate(this)">  
用户名:<input type="text" name="name"><br>  
 密 码：<input type="password" name="password"><br>  
 <input type="submit" value="登录">  
 <input type="reset" value="重置">  
</form>  
</center>  
</body>  
</html>