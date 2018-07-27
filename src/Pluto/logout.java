package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import view.Functions;

public class logout extends ActionSupport{
	public String execute() throws SQLException,IOException{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	HttpSession session=ServletActionContext.getRequest().getSession();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	session.removeAttribute("PlutoUser");
	out.println(Functions.PlutoJump("×¢Ïú³É¹¦", "index.jsp"));
	return null;
}
}
