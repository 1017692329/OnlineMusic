package Pluto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Sqlconnect.DBConnection;
import view.Functions;

public class MusicBox extends ActionSupport{
	private String music_id;

	public String getMusic_id() {
		return music_id;
	}

	public void setMusic_id(String music_id) {
		this.music_id = music_id;
	}
	public String execute() throws IOException,SQLException{
		ServletActionContext.getResponse().setCharacterEncoding("GB2312");
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setDateHeader("Expires", 0);
		String userName=ServletActionContext.getContext().getSession().get("PlutoUser").toString();
		DBConnection conn=new DBConnection();
		ResultSet rs=conn.executeQuery("select music_box from user where name='"+userName+"'");
		if(rs.next())
		{
			String playList=rs.getString("music_box");
			if(playList==null)
			{
				if(conn.execute("update user set music_box='"+music_id+"' where name='"+userName+"'"))
				{
					out.println("添加成功!");
				}
				else
				{
					out.println("出现错误!");
				}
			}
			else
			{
				String[] playListArr=playList.split(",");
				for(int i=0;i<playListArr.length;i++)
				{
					if(music_id.equals(playListArr[i]))
					{
						out.println("抱歉，您的音乐盒已经存在此歌曲!");
						return null;
					}
				}
				if((Functions.isInvalid(playList)))
				{
					if(conn.execute("update user set music_box='"+music_id+"' where name='"+userName+"’"))
					{
						out.println("添加成功!");
					}
					else
					{
						out.println("出现错误!");
					}
				}
				else
					
				{
					if(conn.execute("update user set music_box=CONCAT(music_box,',"+music_id+"') where name='"+userName+"'"))
					{
						out.println("添加成功!");
					}
					else
					{
						out.println("出现错误!");
					}
				}
			}
		}
		else
		{
			out.println("请先登录!");
			return null;
		}
		return null;
	}
	}
