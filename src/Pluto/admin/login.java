package Pluto.admin;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class login extends ActionSupport{//ActionsupportֻҪʵ��getseet�����Ϳ��Ի�ȡҳ��ؼ�ֵ
private String adminName;
private String adminPwd;
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminPwd() {
	return adminPwd;
}
public void setAdminPwd(String adminPwd) {
	this.adminPwd = adminPwd;
}
public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	HttpSession session=ServletActionContext.getRequest().getSession();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	if(Functions.isInvalid(adminName)||Functions.isInvalid(adminPwd))
	{
		out.println(Functions.PlutoJump("�û��������벻��Ϊ��","index.jsp"));
	}
	else
	{
		session.setAttribute("PlutoAdmin", adminName);
		adminPwd=Functions.MD5Encode(adminPwd);
		DBConnection conn=new DBConnection();
		ResultSet rs=conn.executeQuery("Select * from admins where name='"+session.getAttribute("PlutoAdmin").toString()+"'and pwd='"+adminPwd+"'");
		if(rs.next())
		{
			out.println("<script language='javascript'>location.href='frame.jsp'</script>");
		}
		else
		{
			session.removeAttribute("PlutoAdmin");
			out.println(Functions.PlutoJump("�û������������", "index.jsp"));
		}
	}
	return null;
	
}


}
