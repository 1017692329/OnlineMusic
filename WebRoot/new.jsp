<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new .jsp' starting page</title>
    
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
    <form action="admin_register.action" method="post">
		<table>

			
				<td colspan="2"><div align="center">添加管理员</div></td>
				<td>用户名</td>
                <input type="text" name="userName" maxlength="16"/>
				<td>用户密码:</td>
				<input type="password" name="userPwd" maxlength="16"/>
				<td>确认密码:</td>
				<input type="password" name="confirmPwd" maxlength="16"/>
				<td colspan="2">
				<input id="Login" type="submit" value="注册"/>
				<input type="reset" value="取消"/>
				</td>
				</Tbody>
		</table>


	</form>
  </body>
</html>
