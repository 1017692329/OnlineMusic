package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;

public class register extends ActionSupport{
	private String userName=null;
	private String userPwd=null;
	private String confirmPwd=null;
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
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String execute() throws SQLException,IOException{
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		if(Functions.isInvalid(userName)||Functions.isInvalid(userPwd)||Functions.isInvalid(confirmPwd))
		{
			out.println("用户名或密码输入错误");
		}
		if(userPwd.equals(confirmPwd))
		{
			out.println(Functions.PlutoJump("两次输入的密码不一致","new.jsp"));
		}
		DBConnection conn=new DBConnection();
		ResultSet rs=conn.executeQuery("select * from admin where name='"+userName+"'");
		if(rs.next())
		{
			out.println(Functions.PlutoJump("用户名已存在！", "new.jsp"));
		}
		else
		{
			boolean insert=conn.execute("insert into admin(name,pwd) values('"+userName+"'+'"+Functions.MD5Encode(userPwd)+"')");
			if(insert)
			{
				out.println(Functions.PlutoJump("注册成功", "new.jsp"));
			}
			else
			{
				out.println(Functions.PlutoJump("注册失败", "new.jsp"));
			}
				
		}
		return null;

	}

}
