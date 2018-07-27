package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class setbox extends ActionSupport{
List<String> array=null;
private String[] list;
private String select;
public List<String> getArray() {
	return array;
}
public void setArray(List<String> array) {
	this.array = array;
}
public String[] getList() {
	return list;
}
public void setList(String[] list) {
	this.list = list;
}
public String getSelect() {
	return select;
}
public void setSelect(String select) {
	this.select = select;
}

public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	String userName=ServletActionContext.getContext().getSession().get("PlutoUser").toString();
	if(list==null)
	{
		out.println(Functions.PlutoJump("请选择歌曲", "musicbox.jsp"));
	}
	else
	{
		if("del".equals(select))
		{
			DBConnection conn=new DBConnection();
			ResultSet rs=conn.executeQuery("select music_box from user where name='"+userName+"'");
			rs.next();
			String musicList=rs.getString("music_box");
			rs.close();
			if(list.length==1)
			{
				boolean update=conn.execute("update user set music_box=NULL where name='"+userName+"'");
				if(update)
				{
					out.println(Functions.PlutoJump("删除成功","musicbox.jsp"));
				}
				else
				{
					out.println(Functions.PlutoJump("出现错误","musicbox.jsp"));
				}
			}
			else
				
			{
				String[] musicBoxArr=musicList.split(",");
				if(musicBoxArr.length==list.length)
				{
					boolean update=conn.execute("update user set music_box=NULL where name='"+userName+"'");
					if(update)
					{
						out.println(Functions.PlutoJump("删除成功","musicbox.jsp"));
					}
					else
					{
						out.println(Functions.PlutoJump("出现错误","musicbox.jsp"));
					}
				}
				else
				{
					array=new ArrayList<String>();
					for(int i=0;i<musicBoxArr.length;i++)
					{
						array.add(musicBoxArr[i]);
					}
					for(int i=0;i<array.size();i++)
					{
						for(int j=0;j<list.length;j++)
						{
							if(array.get(i).toString().equals(list[j]))
							{
								array.remove(i);
							}
						}
					}
					Object[] newMusicBox=array.toArray();
					String newMusic=newMusicBox[0].toString()+",";
					for(int i=1;i<newMusicBox.length;i++)
					{
						newMusic+=newMusicBox[i].toString()+",";
					}
					newMusic=newMusic.substring(0,newMusic.length()-1);
					boolean update=conn.execute("update user set music_box='"+newMusic+"' where name='"+userName+"'");
					if(update)
					{
						out.println(Functions.PlutoJump("删除成功", "musicbox.jsp"));
					}
					else
					{
						out.println(Functions.PlutoJump("出现错误", "musicbox.jsp"));
					}
				}
			}
		}
		else
		{
			createXML xml=new createXML();
		}
}
	return null;
}
}
