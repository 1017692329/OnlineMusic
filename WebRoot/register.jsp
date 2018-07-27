<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="keywords" content="Custom Login Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- fonts -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">  
<!-- /fonts -->        
<!-- css files -->
<link href="css/style.css" rel="stylesheet" type='text/css' media="all" />
<!-- /css files -->   

  </head>
  
  <body>
<!--  <form action="register.action" method="post">
		<table>

			
				<th >用户注册</th>
				<td>用户名
                <input type="text" name="userName" maxlength="16"/>
                </td>
				<td>用户密码:
				<input type="password" name="userPwd" maxlength="16"/>
				</td>
				<td>确认密码:
				<input type="password" name="confirmPwd" maxlength="16"/>
				</td>
				<td >
				<input id="Login" type="submit" value="注册"/>
				<input type="reset" value="取消"/>
				</td>
				</Tbody>
		</table>


	</form> -->
	<h1 class="w3ls">Customer Signup Form</h1>
<div id="main">
    <form class="w3l" action="register.action" method="post">
		<div class="row email w3layouts">
	    	<input type="text" id="email"  name="userName" placeholder="邮箱" required/>
        </div>
		<div class="row pass w3layouts">
        	<input type="password" id="password1" name="userPwd" placeholder="密码" required/>
        </div>
        <div class="row pass agileits">
			<input type="password" id="password2" name="confirmPwd" placeholder="确认密码" disabled="true" required/>
        </div>
        <!-- The rotating arrow -->
		<img src="images/dial.png" alt="" class="dial-agileits agileinfo">
        <div class="arrowCap agileinfo"></div>
        <div class="arrow agile"></div>
        <p class="meterText agileits">Password Meter</p>
        <input type="submit" value="注册" />
    </form>
</div>
<p class="copyright wthree">© 2017 Customer Signup Form. All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">w3layouts</a></p>
<!-- js files -->
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery.complexify.js"></script>
<script src="js/script.js"></script>
  </body>
</html>
