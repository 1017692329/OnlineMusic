package Pluto.admin;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Sqlconnect.DBConnection;
import view.Functions;

public class changepwd {
	private String oldpwd;
	private String newpwd;
	private String confirmpwd;
	public String getOldPwd() {
		return oldpwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldpwd = oldPwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public String execute() throws Exception
	{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		HttpSession session=ServletActionContext.getRequest().getSession();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		String adminName=ServletActionContext.getContext().getSession().get("PlutoAdmin").toString();
	if(Functions.isInvalid(oldpwd)||Functions.isInvalid(newpwd)||Functions.isInvalid(confirmpwd))
	{
		out.println(Functions.PlutoJump("请填写密码！","changepwd.jsp"));
	}
	if(newpwd.equals(confirmpwd))
	{
		DBConnection conn=new DBConnection();
		ResultSet rs=conn.executeQuery("select pwd from admin where name='"+adminName+"'");
		rs.next();
		if(Functions.MD5Encode(newpwd).equals(rs.getString("pwd")))
		{
			boolean update=conn.execute("update admin set pwd='"+Functions.MD5Encode(newpwd)+"' where name='"+adminName+"'");
			if(update)
			{
				out.println(Functions.PlutoJump("修改成功", "changepwd.jsp"));
			}
			else
				out.println(Functions.PlutoJump("修改失败", "change.jsp"));
			
		}
		else
		{
			out.println(Functions.PlutoJump("旧密码不对!", "changepwd.jsp"));
		}
	}
	else
	{
		out.println(Functions.PlutoJump("两次输入的密码不一致!", "changepwd.jsp"));
	}
	
return null;
}
}
