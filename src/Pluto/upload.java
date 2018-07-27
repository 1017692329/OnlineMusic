package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Sqlconnect.DBConnection;
import view.Functions;

public class upload {
	private String title;
	private String singer;
	private String special;
	private String path;
	private String value;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String execute() throws SQLException,IOException{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	String filePath=ServletActionContext.getRequest().getParameter("path");
	HttpServletRequest request=ServletActionContext.getRequest();
	if(Functions.isInvalid(title)||Functions.isInvalid(singer)||Functions.isInvalid(special)||Functions.isInvalid(path))
	{
		out.println(Functions.PlutoJump("任何一项都不能为空", "upload.jsp?path="+filePath));
		
	}
	else
	{
		filePath=filePath.replace("upload", "upload\\");
		DBConnection conn=new DBConnection();
		long time=new Date().getTime();
		boolean insert=conn.execute("insert into music(title,singer,special,value,time,click,url)values('"+title+"','"+singer+"','"+special+"','"+value+"','"+time+"',0,'"+filePath+"')");
		System.out.print("");
		if(insert&&request.getSession()!=null)
				{
			
			String tip="["+request.getSession().getAttribute("PlutoUser").toString()+"]"+"分享了歌曲"+"["+title+"]";
			conn.execute("insert into tip(value) values('"+tip+"')");
			out.println(Functions.PlutoJump("提交成功!", "index.jsp"));
				}
		else
		{
			out.println(Functions.PlutoJump("提交失败", "upload.jsp?path="+filePath));
		}
	}
	return null;
	}


}
