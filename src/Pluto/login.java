package Pluto;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class login extends ActionSupport{
	private String userName;
	private String userPwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String execute() throws Exception{
		 
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setHeader("Pragma", "No-cache");
		ServletActionContext.getResponse().setHeader("Cache-Control", "No-cache");
		HttpSession session=ServletActionContext.getRequest().getSession();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		if(Functions.isInvalid(userName)||Functions.isInvalid(userPwd))
		{
			out.println(Functions.PlutoJump("用户名密码不能为空！","index.jsp"));
		}
		else
		{
			session.setAttribute("PlutoUser", userName);
			userPwd=Functions.MD5Encode(userPwd);
			DBConnection conn=new DBConnection();
			ResultSet rs=conn.executeQuery("Select * from user where name='"+session.getAttribute("PlutoUser").toString()+"'and pwd='"+userPwd+"'");
			if(rs.next())
			{
				out.println("<script language='javascript'> location.href='index.jsp'</script>");
			}
			else
			{
				session.removeAttribute("PlutoUser");
				out.println(Functions.PlutoJump("用户名密码错误", "index.jsp"));
			}
		}
		return null;
		
	}
	
}
