<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Musicbox.jsp' starting page</title>

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
	<h2>我的音乐盒</h2>
	<%
if(music_box !=null){
 %>
	<form method="post" name="form2" id="form2" action="setbox.action"></form>
	<th>TD</th>
	<th>歌曲</th>
	<th>歌手</th>
	<th>试听</th>
	<th><input type="checkbox" name="chkAll" value="" title="全选/取消"
		onclick="selectAll();" /></th>
	<%
    int maxSong=pagesize;
    for(int i=0;i<maxSong;i++)
    {
    try
    {
    ResultSet music_rs=conn.executeQuery("select title, singer,url from music where id='"music_box_arr[i]+"'");
    music_rs.next();
    String title=music_rs.getString("title");
    String singer=music_rs.getString("singer");
    String url=music_rs.getString("url");
    if(i%2==0)
    {
    out.println(<TBODY><TR>);
    }
    else
    {
    out.println(<TBODY><TR class=odd>");
    }
    out.println("<TD>"+music_box_arr[i]+"</TD>");
    out.println("<TD>"+title+"<TD>");
    out.println("<TD"+singer+"</TD>");
    Random rd=new Random();
    int rd_id=rd.nextInt(9999);
    String player="<object type='application/x-shockware-flash' data='player/audioplayer.swf' width=200 height=15 id='audioplayer7643'>"+
    "<param name='movie' value='player/audioplayer.swf'/>"+
    "<param name='FlashVars' value='playerID=''"+rd_id+"'&soundfile='"+url+"')'/>+
	"<param name='quality' value='high' />"+
	"<param name='menu' value='false' />"+
	"<param name='wmode' value='tranparent' />"+
	"</object>";
	 out.println("<TD>+player+</TD>);
	 out.println("<TD><input type='checkbox' name='list' id='list' '"+music_box_arr[i]+"' value='"+music_box_arr[i]+"'></TD>");
	} catch(Exception e) { } 
	} 
	out.println("</tbody></table>");
	 boolean noAjax=false; out.println("
	<div class='yahoo2'>
		function.page(maxPage,nowPage,pageSize,'Musicbox.jsp',noAjax)"+"</div>"); 
		out.println("<div align=center>"+
		"<label>选中项：<select name='select' id='select' class=width_100>"+
		"<option value='play'>播放</option>"+
				"<option value='del'>删除</option>"
				"</select></label> <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+"<input type='submit' value='提交'>"+
				"</label>"+
	"</div>"+
	"</form>"
	"); out.println("");
	
    }
    else
    {
    out.println("对不起，暂时你的音乐盒没有任何音乐！");
    }
     %>
</body>
</html>
