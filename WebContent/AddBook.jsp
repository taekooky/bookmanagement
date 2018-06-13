<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加结果</title>
</head>
<body background="img/2.jpg">
	
	<jsp:useBean id="book" class="com.lyq.bean.Book"></jsp:useBean>
	<jsp:setProperty property="*" name="book"/>
	<%
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test1";

			String username = "root";
	
			String password = "000000";
			
			Connection conn = DriverManager.getConnection(url,username,password);
		
			String sql = "insert into tb_books(id,name,price,bookCount,author) values(?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, book.getId());
			System.out.println("id："+book.getId());

			ps.setString(2, book.getName());
			
			ps.setDouble(3, book.getPrice());

			ps.setInt(4,book.getBookCount());

			ps.setString(5, book.getAuthor());
		
			int row = ps.executeUpdate();
	
			if(row > 0){
		
				out.print("成功添加了 " + row + "条数据！");
			}
	
			ps.close();
	
			conn.close();
		} catch (Exception e) {
			out.print("图书信息添加失败！");
			e.printStackTrace();
		}
	%>
	<br>
	<a href="Add.jsp">返回</a>
</body>
</html>