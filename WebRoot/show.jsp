<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
<h2>我要留言</h2>

<form action="addcomments.action?id=<%=request.getParameter("id")%>" method="post"  class="niceform">
<label>
呢称：
<input type="text" name="name" id="textfield" maxlength="16"/>
</label>
<label>留言：
<input type="hidden"/>
<textarea name="comments" id="valueid" rows="5" cols="20"></textarea>
</label>
<input type="submit" name="button" id="button" value="提交"/>
<h2 class="title">最近留言</h2>
</form>
  </body>
</html>
