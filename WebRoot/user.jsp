<%@page import="Sqlconnect.DBCollection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <Table>
   <span>用户名</span>
   <span>密码(MD5加密)</span>
   <span>删除</span>
   <%
   DBCollection conn=new DBCollection();
   ResultSet rs=conn.executeQuery("Select * from user order by id DESC")
   while(rs.next())
   {
   String id=rs.getString("id");
   String name=rs.getString("name");
   String pwd=rs.getString("pwd");
   out.println("<tr align=\center\">");
   out.println("<td>"+name+"</td>");
   out.println("<td>"+pwd+"</td>");
   out.println("<td><a href=\"admin_deluser.action?id="+id+"\">删除</a></td>");
   out.println("</tr>");
   }
    %>
   </Table>
  </body>
</html>
