package Pluto.admin;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import Sqlconnect.DBConnection;
import view.Functions;

public class dellink {
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
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		if(Functions.isInvalid(id))
		{
			out.println(Functions.PlutoJump("³öÏÖ´íÎó", "link.jsp"));
			
		}
		DBConnection conn=new DBConnection();
		boolean del=conn.execute("delete from link where id='"+id+"'limit 1");
		if(del)
		{
			out.println(Functions.PlutoJump("É¾³ý³É¹¦", "link.jsp"));
		}
		else
		{
			out.println(Functions.PlutoJump("É¾³ýÊ§°Ü", "link.jsp"));
		}
		return null;
	}
}
