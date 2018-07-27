<%@page import="Sqlconnect.DBConnection"%>
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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="music.css" rel="stylesheet" type="text/css" />
	
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
  </head>
  
  <body>
<!--   <form  action="login.action" method="post"  class="form-horizontal" >
				<div class="control-group" >
					 <label class="control-label" for="inputEmail">用户名</label>
					<div class="controls">
					 <input type="text" id="textinput" name="userName" size="15" maxlength="16"/><br/>
					</div>
				</div>
				<div class="control-group" >
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						  <input type="password" id="passwordinput" name="userPwd" size="15" maxlength="16"/><br/>
					</div>
				</div>
				<div class="control-group" >
					<div class="controls">
						  <a href="register.jsp?height=175&width=300&modal=true class="thickbox" title="我要注册">我要注册</a>
  <input type="submit" value="登录"/>
					</div>
				</div>
			</form> -->
		
  <%
  if(session.getAttribute("PlutoUser")==null)
  {
   %>
<form name="login_form" action="login.action" method="post" >
  <div id="main-container">
  <div id="container">
    <div class="side">
      <div class="logo"><img src="images/logo.gif" width="229" height="105" alt="Logo" /></div>
      <div class="side-image"><img src="images/but-play.gif" width="229" height="70" alt="play" /></div>
      <div class="side-login"><img src="images/top-col.gif" width="201" height="19" alt="top" />
        <div class="side-login-content">
          
          <input type ="image" class="login" onclick="login_form.submit()" src="images/but-go.gif" width="41" height="41" alt="go" /></div>
          <div class="login-input">
           <input type="text" id="textinput" name="userName" size="20" maxlength="20"  placeholder="用户名"/><br/>
            <input type="password"  id="passwordinput" name="userPwd" size="20" maxlength="20"  placeholder="密码"/><br/>
           
            <!-- <label>
              <input type="checkbox" name="checkbox" id="checkbox"  />
            </label>
            Remember Me  --></div>
          <div class="line"><img src="images/pg1-main_24.gif" width="169" height="9" alt="line" /></div>
          <input class="button"  type ="image"  onclick="login_form.submit()" src="images/but-submit.gif" width="69" height="29" alt="submit" />
          <a href="register.jsp?height=175&width=300&modal=true" ><img class="button" src="images/but-joinus.gif" width="68" height="29" alt="submit" /></a>
          <br class="clearboth" />
        </div>
        <img src="images/bot-col.gif" width="201" height="21" alt="bot-col" /></div>
    </div>
    </form>
  
   <!-- main -->
     <div class="nav" >
          <ul>
            <li><a href="index.jsp"><img src="images/but01.gif" width="148" height="29" alt="button" /></a></li><li><a href="Musicbox.jsp"><img src="images/but02.gif" width="115" height="29" alt="button" /></a></li><li><a href="message.jsp"><img src="images/but03.gif" width="105" height="29" alt="button" /></a></li><li><a href="uploadmusic.jsp"><img src="images/but04.gif" width="100" height="29" alt="button" /></a></li><li><a href="Musicbox.jsp"><img src="images/but05.gif" width="137" height="29" alt="button" /></a></li>
          </ul>
        </div>
<div class="audio-main">
	 
      
     
    
	<div class="audio-record-list">
					<div id="jquery_jplayer_1" class="jp-jplayer"></div>
						<div id="jp_container_1" class="jp-audio" role="application" aria-label="media player">
							<div class="jp-type-playlist">
								<div class="jp-gui jp-interface">
									<div class="jp-controls">	
										<button class="jp-play" role="button" tabindex="0">play</button>
									</div>
									<div class="jp-progress">
										<div class="jp-seek-bar">
											<div class="jp-play-bar"></div>
										</div>
									</div>
									<div class="jp-volume-controls">
										<button class="jp-mute" role="button" tabindex="0">mute</button>
										<button class="jp-volume-max" role="button" tabindex="0">max volume</button>
										<div class="jp-volume-bar">
											<div class="jp-volume-bar-value"></div>
										</div>
									</div>
									<div class="jp-time-holder">
										<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
										<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
									</div>
									
								</div>
								<div class="jp-playlist">
									<ul>
										<li>&nbsp;</li>
									</ul>
								</div>
								<div class="jp-no-solution">
									<span>Update Required</span>
									To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
								</div>
							</div>
						</div>
	</div>
	<div class="footer">
		<div class="copy-right">
			<p> &copy; 2015 Audio List Player Widget. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p>
		</div>
	</div>
</div>
<!-- //main -->
<!-- script for play-list -->
<link href="css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jplayer.playlist.min.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function() {
 /* 先用 $.get 方法载入 XML 文件 */
 $.get("playlist.xml", function(xmlData) {
 /* 我们要讲得到的数据放入一个表格里面，这里定义一个表格字符窜 */
 
 /* 找到 Person 元素，然后用 each 方法进行遍历 */
 $(xmlData).find("Person").each(function() {
 /* 将当前元素复制给 Person */
 var json = new JSONObject();  
 
  var root = Person.attr("annotation"); /* 获取 Person 的 FullName 属性 */
 json.put(root.getName(), iterateElement(root));
 
  
 });
  


 });
 new jPlayerPlaylist({
		jPlayer: "#jquery_jplayer_1",
		cssSelectorAncestor: "#jp_container_1"
	}, [
		{
			title:"",
			mp3:"http://www.jplayer.org/audio/mp3/TSP-01-Cro_magnon_man.mp3",
			oga:"http://www.jplayer.org/audio/ogg/TSP-01-Cro_magnon_man.ogg"
		},
		{
			title:"Your Face",
			mp3:"http://www.jplayer.org/audio/mp3/TSP-05-Your_face.mp3",
			oga:"http://www.jplayer.org/audio/ogg/TSP-05-Your_face.ogg"
		},
		{
			title:"Cyber Sonnet",
			mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3",
			oga:"http://www.jplayer.org/audio/ogg/TSP-07-Cybersonnet.ogg"
		},
		{
			title:"Tempered Song",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-01-Tempered-song.mp3",
			oga:"http://www.jplayer.org/audio/ogg/Miaow-01-Tempered-song.ogg"
		},
		{
			title:"Hidden",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3",
			oga:"http://www.jplayer.org/audio/ogg/Miaow-02-Hidden.ogg"
		},
		{
			title:"Lismore",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-04-Lismore.mp3",
			oga:"http://www.jplayer.org/audio/ogg/Miaow-04-Lismore.ogg"
		},
		{
			title:"The Separation",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-05-The-separation.mp3",
			oga:"http://www.jplayer.org/audio/ogg/Miaow-05-The-separation.ogg"
		},
		{
			title:"Thin Ice",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-10-Thin-ice.mp3",
			oga:"http://www.jplayer.org/audio/ogg/Miaow-10-Thin-ice.ogg"
		}
	], {
		swfPath: "../../dist/jplayer",
		supplied: "oga, mp3",
		wmode: "window",
		useStateClassSkin: true,
		autoBlur: false,
		smoothPlayBar: true,
		keyEnabled: true
	});
});
$(document).ready(function(){

 
	
});
//]]>
</script>
<!-- //script for play-list -->
<% 
}
else
{
%>
<div class="nav-bar">
        <div class="top-newsbar"><img src="images/topnewsbar.gif" width="238" height="16" alt="news" /></div>
        <div class="nav">
          <ul>
            <li><a href="index.jsp"><img src="images/but01.gif" width="148" height="29" alt="button" /></a></li><li><a href="Musicbox.jsp"><img src="images/but02.gif" width="115" height="29" alt="button" /></a></li><li><a href="message.jsp"><img src="images/but03.gif" width="105" height="29" alt="button" /></a></li><li><a href="uploadmusic.jsp"><img src="images/but04.gif" width="100" height="29" alt="button" /></a></li><li><a href="Musicbox.jsp"><img src="images/but05.gif" width="137" height="29" alt="button" /></a></li>
          </ul>
        </div>
      </div>
      <div class="main-img"></div>
      <div class="main-col"></div>
      <div class="main-col-center"></div>
      <div class="main-butchat"><img src="images/but-chat.jpg" width="224" height="148" alt="chat" /></div>
   
<p>
<%=session.getAttribute("PlutoUser").toString()%>,欢迎你回来！
</p>
 <%
 String userName=session.getAttribute("PlutoUser").toString();
 DBConnection conn=new DBConnection();
 ResultSet user_rs=conn.executeQuery("select id from user where name='"+userName+"'");
 user_rs.next();
 String  id=user_rs.getString("id");
 ResultSet message_rs=conn.executeQuery("select count(id) as count from message where 'to'='"+id+"' and 'new'=1");
 message_rs.next();
 
 int myMessage=message_rs.getInt("count");
 
  %>
 
  <p>
  欢迎来到本系统，你可以
  退出请点<a href="logout.action" style="color:#FF0000">[注销登录]</a>!
  </p>
 </div>
  <%} %>
  
</body>
</html>
