package Pluto.admin;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import Sqlconnect.DBConnection;
import view.Functions;

public class link {
private String title;
private String value;
public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	if(Functions.isInvalid(title)||Functions.isInvalid(value))
	{
		out.println(Functions.PlutoJump("请输入网站名称和地址！", "link.jsp"));
		
	}
	DBConnection conn=new DBConnection();
	boolean insert=conn.execute("insert into link(title,value) values('"+title+"','"+value+"')");
	if(insert)
	{
		out.println(Functions.PlutoJump("添加成功", "link.jsp"));
	}
	else
	{
		out.println(Functions.PlutoJump("添加失败", "link.jsp"));
	}
	return null;
}
}
