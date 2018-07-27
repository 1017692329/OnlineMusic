<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'link.jsp' starting page</title>

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
	<form action="admin_link" method="post">

		<table>
			<td>添加友情链接</td>
			<td>网站名称</td>
			<input type="text" name=title maxlength="16" />
			<td>网站地址</td>
			<input type="text" name="value" />
			<td>*网站地址必须以http://开头</td>
			<td><input id=Login type=submit value="确定"> <input
				type="reset" value="取消" /></td>
		</table>
	</form>
	<table>
	<td> 
	<span>网站名称</span>
	<span>删除</span>
	<span>网站名称</span>
	</td>
	<%
		DBConnection conn=new DBConnection();
	   ResultSet rs=conn.executeQuery("Select * from link order by id DESC")
	   while(rs.next())
	   {
	   String id=rs.getString("id");
	   String name=rs.getString("title");
	   String pwd=rs.getString("value");
	   out.println("<tr align=\center\">");
	   out.println("<td>"+title+"</td>");
	   out.println("<td>"+value+"</td>");
	   out.println("<td><a href=\"admin_deluser?id="+id+"\">删除</a></td>");
	   out.println("</tr>");
	   }
	%>
	</table>
</body>
</html>
