package Pluto;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import Sqlconnect.DBConnection;
import view.Functions;

public class delmessage {
	private String[] list;
	public String[] getList() {
		return list;
	}
	public void setList(String[] list) {
		this.list = list;
	}
	public String execute() throws Exception{
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		String userName=ServletActionContext.getContext().getSession().get("PlutoUser").toString();
		if(list==null)
		{
			out.println(Functions.PlutoJump("��ѡ�����Ϣ!", "message.jsp"));
		}
		else
		{
			DBConnection conn=new DBConnection();
			if(list.length==1)
			{
				boolean del=conn.execute("delete from message where id='"+list[0]+"' limit 1");
				if(del)
				{
					out.println(Functions.PlutoJump("ɾ���ɹ�!", "message.jsp"));
				}
				else
				{
					out.println(Functions.PlutoJump("ɾ��ʧ��!", "message.jsp"));
				}
					
			}
		}
		return null;
	}
}
