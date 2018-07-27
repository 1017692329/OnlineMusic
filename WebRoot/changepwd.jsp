<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changepwd.jsp' starting page</title>
    
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
<form action="admin_changepwd">
<label>
旧密码：
<input type="text" name="oldpwd" id="textfield"/>
</label>
<label>
新密码：
<input type="text" name="newpwd" id="textfield2"/>
</label>
<label>
确认密码：
<input type="text" name="confirmpwd" id="textfield3"/>
</label>
<label>
<input type="submit" name="button" id="button" value="提交"/>
<input type="reset" name="button2" id="button2" value="重置"/>
</label>
</form>
  </body>
</html>
