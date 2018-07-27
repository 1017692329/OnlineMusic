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
    
    <title>My JSP 'showmessage.jsp' starting page</title>
    
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
<%
String message_id=request.getParameter("id");
ResultSet rs=conn.executeQuery("select title,value from message where id="+message_id+"");
rs.next();
String title=rs.getString("title");
String value=rs.getString("value");
conn.execute("update message set new=0 where id="+message_id+"");
 %>
 <table width="80%" align="center" class="mytable">
 <td class="odd">
 <th scope=col><%=title %></th>
 </td>
 <td><%=value %></td>
 </table>
  </body>
</html>
