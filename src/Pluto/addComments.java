package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class addComments extends ActionSupport { //��ȡҳ��formֵ����̳�,Ȼ��дsetget��������
	private String name;
	private String comments;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String execute() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		if(name==null||Functions.isInvalid(comments)||Functions.isInvalid(id))
		{
			out.println("�Ƿ�����!");
			return null;
		}
		else
			if("".equals(name))
			{
				name="�ο�";
			}
		long time=new Date().getTime();
		DBConnection conn=new DBConnection();
		boolean insert=conn.execute("insert into comments(value,name,music_id,time) values('"+comments+"','"+name+"','"+id+"','"+time+"')");
		if(insert)
		{
			out.println("������۳ɹ�!");
		}
		else
		{
			out.println("�������ʧ��!");
		}
	
				return null;
	}
}
