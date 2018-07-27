package Pluto;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class message extends ActionSupport {
	private String to;
	private String value;
	private String title;
	public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	HttpSession session=ServletActionContext.getRequest().getSession();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	String userName=ServletActionContext.getContext().getSession().get("PlutoUser").toString();
	if(Functions.isInvalid(to))
	{
		out.println(Functions.PlutoJump("�������ռ�������!", "message.jsp"));
	}
	if(Functions.isInvalid(value))
	{
		out.println(Functions.PlutoJump("��������Ϣ����!", "message.jsp"));
	}
	DBConnection conn=new DBConnection();
	ResultSet rs=conn.executeQuery("select id,name from user where name='"+to+"'");
	if(rs.next())
	{
		String to_name=rs.getString("name");
		if(userName.equals(to_name))
		{
			out.println(Functions.PlutoJump("�Բ��𣬲��ܸ��Լ�������!", "message.jsp"));
		}
		else
		{
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
				out.println(Functions.PlutoJump("���Ͷ���Ϣ�ɹ�!", "message.jsp"));
			}
			else
			{
				out.println(Functions.PlutoJump("���Ͷ���Ϣʧ��!", "message.jsp"));
			}
				
		}
	}
	else
	{
		out.println(Functions.PlutoJump("�û�������!", "message.jsp"));
	}
	return null;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
