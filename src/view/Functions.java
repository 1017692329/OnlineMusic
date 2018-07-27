package view;

import java.io.File;
import java.security.MessageDigest;

import javax.activation.FileTypeMap;

public class Functions {
	public static boolean isInvalid(String value)//�жϲ����Ƿ�Ϊ��
	{
		return (value==null||value.length()==0);

	}
	private final static String[] hexDigits={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	public static String byteArrayToHexString(byte[] b)
	{
		StringBuffer resultSb=new StringBuffer();
		for(int i=0;i<b.length;i++)
		{
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	private static String byteToHexString(byte b)
	{
		int n=b;
		if(n<0)
			n=256+n;
		int d1=n/16;
		int d2=n%16;
		return hexDigits[d1]+hexDigits[d2];
	}
	public  static String MD5Encode(String origin)
	{
		String resultString=null;
		try
		{
			resultString=new  String(origin);
			MessageDigest md=MessageDigest.getInstance("MD5");
			resultString=byteArrayToHexString(md.digest(resultString.getBytes()));
		}
		catch(Exception ex)
		{
			
		}
		return resultString;
	}
	public static String fileType(File file)
	{
		FileTypeMap map=FileTypeMap.getDefaultFileTypeMap();
		return map.getContentType(file);
	}
	public static String PlutoJump(String errorStr,String jumpTo )//�������ڷ���
	{
		String str=null;
		try
		{
			str="<script charset='utf-8' language='javascript' type='text/javascript'>"
					+ "alert('"+errorStr+"');"
					+ "location.href='"+jumpTo+"';"
					+"</script>";

		}
		catch(Exception e)
		{
			str="<script charset='utf-8' language='javascript' type='text/javascript' >"
					+"alert(errorStr);"
					+"location.href='"+jumpTo+"';"
					+"<script>";

		}
		return str;

	}
}
