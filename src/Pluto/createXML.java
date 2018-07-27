package Pluto;

import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import Sqlconnect.DBConnection;




public class createXML {
	private String str="3,2,4,5,6,7";
	private String [] playListArr;
	private String Path;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String[] getPlayListArr() {
		return playListArr;
	}
	public void setPlayListArr(String[] playListArr) {
		this.playListArr = playListArr;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
public void buildXML(String [] id,HttpServletRequest request,String userName) throws Exception
{
	
	Element playList=new Element("playlist");
	Document Doc=new Document(playList);
	playList=Doc.getRootElement();
	playList.setAttribute("version","1");
	playList.setAttribute("xmln","http://xspf.org/ns/0/");
	Element title=new Element("title");
	title.setText("Pluto's Player");
	playList.addContent(title);
	Element trackList=new Element("trackList");
	playList.addContent(trackList);
	DBConnection conn=new DBConnection();
	for(int i=0;i<id.length;i++)
	{
		ResultSet rs=conn.executeQuery("select * from music where id='"+id[i]+"'");
		rs.next();
		String music_title=rs.getString("title");
		String music_singer=rs.getString("singer");
		String music_url=rs.getString("url");
		Element track=new Element("track");
		Element annotation=new Element("annotation");
		annotation.setText(music_title+"-"+music_singer);
		track.addContent(annotation);
		Element location=new Element("location");
		location.setText("../"+music_url);
		track.addContent(location);
		trackList.addContent(track);
	}
	ResultSet userRs=conn.executeQuery("select id from user where name='"+userName+"'");
	userRs.next();
	String user_id=userRs.getString("id");
	XMLOutputter XMLOut=new XMLOutputter();
	XMLOut.output(Doc, new FileOutputStream(request.getSession().getServletContext().getRealPath("/player/xml"+user_id+".xml")));
}
}
