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
		out.println(Functions.PlutoJump("��������վ���ƺ͵�ַ��", "link.jsp"));
		
	}
	DBConnection conn=new DBConnection();
	boolean insert=conn.execute("insert into link(title,value) values('"+title+"','"+value+"')");
	if(insert)
	{
		out.println(Functions.PlutoJump("��ӳɹ�", "link.jsp"));
	}
	else
	{
		out.println(Functions.PlutoJump("���ʧ��", "link.jsp"));
	}
	return null;
}
}
