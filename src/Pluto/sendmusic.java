package Pluto;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class sendmusic extends ActionSupport{
	private String to;
	private String value;
	private String hidename;
	private String id;
	public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	HttpSession session=ServletActionContext.getRequest().getSession();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	String userName=ServletActionContext.getContext().getSession().get("PlutoUser").toString();
	if(Functions.isInvalid(to))
	{
		out.println(Functions.PlutoJump("你要发给谁呢?", "index.jsp"));
	}
	if(Functions.isInvalid(value))
	{
		value="这家伙很懒，什么也没留下!";
	}
	DBConnection conn=new DBConnection();
	ResultSet rs=conn.executeQuery("select id,name from user where name='"+to+"'");
	if(rs.next())
	{
		String to_name=rs.getString("name");
		if(userName.equals(to_name))
		{
			out.println(Functions.PlutoJump("不能给自己点歌!", "index.jsp"));
		}
		if("true".equals(hidename))
		{
			userName="匿名";
		}
		ResultSet music_rs=conn.executeQuery("select title,url from music where id="+id+"");
		music_rs.next();
		int rd_id=new Random().nextInt(9999);
		String  music_title=music_rs.getString("title");
		String music_url=music_rs.getString("url");
		music_url=music_url.replace("upload\\", "upload\\\\");
		String title="[" +userName+"]为您点播了一首["+music_title+"]";
		String message_value="<p>他（她）给你的留言"+value+"</p>";
		message_value+="<p>您可以点击下面的播放器进行试听！<br/>";
		message_value+="<object type='application/x-shockware-flash' data='player/audioplayer.swf' width='290' height='24' id='audioplayer'+rd_id>"+
	   " <param name='movie' value='player/audioplayer.swf'/>"
	    +"<param name='FlashVars' value='playerID=7643&soundfile='"+music_url+"''/>"
	    +"<param name='quality' value='high'/>"
	    +"<param name='menu' value='false'/>"
	    +"<param name='wmode' value='tranparent'/>"
	    +"</object>";
		
			long time=new Date().getTime();
			int to_id=rs.getInt("id");
			if(conn.execute("insert into message('from','to',title,value,time,new) values('"
					+ userName
					+"',"
					+to_id
					+",'"
					+title
					+"','"
					+value
					+"','"
					+time
					+"'"
					+ ",1)"
					))
			{
				out.println(Functions.PlutoJump("点播成功!", "index.jsp"));
			}
			else
			{
				out.println(Functions.PlutoJump("点播失败!", "index.jsp"));
			}
				
		
	}
	
	else
	{
		out.println(Functions.PlutoJump("你要发给谁呢?", "index.jsp"));
	}
	return null;
	}

}
