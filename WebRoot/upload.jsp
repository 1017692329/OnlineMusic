<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
    <h2>上传音乐</h2>
    <form id="form1" name="form1" method="post" action="upload.action?path=<%=request.getParameter("path")%>">
    <input type="hidden" name="path" value="<%=request.getParameter(path) %>"/>
    <td>您的音乐已经上传成功，您可以点击下面的播放器进行试听！</td>
    <td height="23" align="center">
    <object type="application/x-shockware-flash" data="player/audioplayer.swf" width="290" height="24" id="audioplayer7643">
    <param name="movie" value="player/audioplayer.swf"/>
    <param name="FlashVars" value="playerID=7643&soundfile=<%=request.getParameter("path")%>"/>
    <param name="quality" value="high"/>
    <param name="menu" value="false"/>
    <param name="wmode" value="tranparent"/>
    </object>
    </td>
     <td>
    歌曲名称：
    <input type="text" name="title" id="singer" size="15"> 
    </td>
    <td>
    歌手：
    <input type="text" name="singer" id="singer" size="15"> 
    </td>
     <td>
    所属专辑：
    <input type="text" name="special" id="special" size="15"/> 
    </td>
    <td>
    简介：
    <input type="hidden"/>
    <textarea rows="6" cols="25" name="value" id="value"></textarea>
    </td>
    <td>
    <input type="submit" name="button" id="button" value="提交"/>
    </td>
    </form>
  </body>
</html>
