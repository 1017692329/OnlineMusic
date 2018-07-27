package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class addComments extends ActionSupport { //获取页面form值必须继承,然后写setget方法即可
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
			out.println("非法访问!");
			return null;
		}
		else
			if("".equals(name))
			{
				name="游客";
			}
		long time=new Date().getTime();
		DBConnection conn=new DBConnection();
		boolean insert=conn.execute("insert into comments(value,name,music_id,time) values('"+comments+"','"+name+"','"+id+"','"+time+"')");
		if(insert)
		{
			out.println("添加评论成功!");
		}
		else
		{
			out.println("评论添加失败!");
		}
	
				return null;
	}
}
