package Pluto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import view.Functions;

public class uploadmusic extends ActionSupport{
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String execute() throws Exception{
	ServletActionContext.getResponse().setCharacterEncoding("GB2312");
	PrintWriter out=ServletActionContext.getResponse().getWriter();
	ServletActionContext.getResponse().setDateHeader("Expires", 0);
	String fileType=getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	Date dt=new Date();
	Random rd=new Random();
	setUploadFileName(sdf.format(dt)+rd.nextInt(9999)+fileType);
	if("audio/mp3".equals(getUploadContentType()))
	{
		FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
		FileInputStream fis=new FileInputStream(getUpload());
		byte[] buffer=new byte[10240];
		int len=0;
		while((len=fis.read(buffer))>0)
		{
			fos.write(buffer,0,len);
		}
	System.out.println(getUploadContentType());

		String filePath="upload\\\\"+getUploadFileName();
		out.println(Functions.PlutoJump("上传成功,请认真填写歌曲内容!", "upload.jsp?path="+filePath));
	}
	else
	{
		
		out.println(Functions.PlutoJump("文件类型必须为mp3!","uploadmusic.jsp"));
	}
	
	
	return null;

	}

}
