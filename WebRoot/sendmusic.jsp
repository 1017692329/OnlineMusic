<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendmusic.jsp' starting page</title>
    
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
<form action="sendmusic?id=<%=id%>" method="post">
<td>
点播歌曲
</td>
<td>
用户名:
<input type="text" name="to" maxlength="16"/>
</td>
<td>
<input type="checkbox" name="hidename"  value="true" id="checkbox"/></td>
<td>留言：
<textarea name="value" id="textarea" rows="5" cols="45"></textarea>
</td>
<td>
<input id=Login type="submit" value="确定">
<input type="reset" onclick="tb_remove()" value="取消"/>
</td>
</form>
  </body>
</html>
