<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <form action="admin_login.action" method="post">
	<table>
		
			<td>管理员登录</td>
			<td>用户名:</td>
			<input type="text" name="adminName" maxlength="16"/>
			<td>用户密码:</td>
			<input type="password" name="adminPwd" maxlength="16"/>
			<td colspan="2">
			<div align="center">
		<input id="Login" type="submit" value="登录"/>
		<input type="reset" value="取消"/>
		</div>
		</td>
	</table>
	</form>
</body>
</html>
