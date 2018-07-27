<%@page import="Sqlconnect.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.sorted.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
  </head>
  
  <body>
     <form class="form-inline definewidth m20" action="user.jsp" method="post">  
    角色名称：
    <input type="text" name="rolename" id="rolename" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增角色</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
  <tr>
      <th>用户名</th>
        <th>密码</th>
   <th>操作</th> 
   </tr>;
</thead>
   <%
   DBConnection conn=new DBConnection();
   ResultSet rs=conn.executeQuery("Select * from user order by id DESC");
   while(rs.next())
   {
   String id=rs.getString("id");
   String name=rs.getString("name");
   String pwd=rs.getString("pwd");
  

  
	  out.println("<tr>"); 
       out.println("<td>'"+name+"'</td>");   
        out.println(" <td>'"+pwd+"'</td>");   
          out.println("<td>");        
            out.println("<a href='admin_deluser.action?id='"+id+"'>删除</a>");  
              out.println("</td>");          
            out.println("</tr>");   
              
           
       
   
   
   }
    %>
    </table>

   </body>
  </body>
</html>
