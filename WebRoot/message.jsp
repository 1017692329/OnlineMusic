<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    
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
  <h2>发送短消息!</h2>
  <form id="form1" name="form1" method="post" action="message" class="niceform">
  <label>收件人：
  <input type="text" name="to" id="textfield" maxlength="16"/>
  </label>
    <label>标题：
  <input type="text" name="title" id="textfield" maxlength="16"/>
  </label>
   <label>内容：
  <input type="hidden"/>
  <textarea name="value" id="textarea" cols="30" row="5">
  </label>
  <label>
  <input type="submit" name="button" id="button" value="提交"/>
  </label>
  </form>
  </body>
</html>
