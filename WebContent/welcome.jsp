<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head> 
  <title>图书管理主页</title> 
  </head> 
</style> 
</head> 
  <body background="img/1.jpg"> 

<center>

<h1>图书管理系统</h1> 

                  
                       <h2><a href=Add.jsp>添加图书</h2>   
         
         
                        <h2><a href="FindServlet">查询图书</a>  
                         </h2> 
                 
           
                        <h2><a><a href="FindServlet1">分页查询图书</a>  
                        </h2>
                          <a href="Login.jsp">返回</a>
      </center>       
             
 
    </table>
  
  
</body>  
</html>  