package Pluto.admin;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class delmusic extends ActionSupport{
private String id;
public String getId()
{
	return id;
}
public void setId(String id)
{
	this.id=id;
}
public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	if(Functions.isInvalid(id))
	{
		out.println(Functions.PlutoJump("³öÏÖ´íÎó", "Music/music.jsp"));
		
	}
	DBConnection conn=new DBConnection();
	boolean del=conn.execute("delete from music where id='"+id+"' limit 1");
	if(del)
	{
		out.println(Functions.PlutoJump("É¾³ý³É¹¦", "Music/music.jsp"));
	}
	else
	{
		out.println(Functions.PlutoJump("É¾³ýÊ§°Ü", "Music/music.jsp"));
	}
	return null;
}
}