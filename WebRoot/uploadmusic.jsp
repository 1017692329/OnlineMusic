<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadmusic.jsp' starting page</title>
    
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
  <h2 class="title">
  上传音乐
  </h2>
  <form id="form1" name="form1" method="post" enctype="multipart/form-data" action="uploadmusic.action" class="niceform">
  <table>
  <td>
  请上传歌曲：
<input type="file" name="upload"/>
  </td>
  <td>
  <input type="submit" value="下一步"/>
  </td>
  </table>
  </form>
  </body>
</html>
