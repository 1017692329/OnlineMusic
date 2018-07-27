package Sqlconnect;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class DBConnection {
	
  static private String strDriver="com.mysql.cj.jdbc.Driver";
  static private String strUrl="jdbc:mysql://localhost:3306/onlinemusic?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
  static private String strUser="root";
  static private String strPwd="123";
  private Connection conn=null;
  private Statement stmt=null;
  private PreparedStatement pstmt=null;
  private ResultSet rs=null;
  static{
	  try{
		  Class.forName(strDriver);
	  }
	  catch(ClassNotFoundException ex)
	  {
		  System.out.println("Error Load"+strDriver);
	  }
	  
  }
  public DBConnection()
  {
	  
  }
  private Connection getConnection()
  {
	  try{
		  if(conn==null||conn.isClosed())
			  conn=DriverManager.getConnection(strUrl,strUser,strPwd);
	  }
	  catch(Exception ex)
	  {
		  ex.printStackTrace();
		  return null;
	  }
	  return conn;
  }
  public void close()
  {
	  try
	  {
		  if(rs!=null)
		  {
			  rs.close();
			  rs=null;
		  }
		  if(pstmt!=null)
		  {
			  pstmt.close();
			  pstmt=null;
		  }
		  if(conn!=null)
		  {
			  conn.close();
			  conn=null;
		  }
	  }
	  catch(Exception ex)
	  {
		  System.err.println("close error:"+ex.getMessage());
	  }
  }
  public ResultSet executeQuery(String sql)  //查找方法
  {
	  try {
		pstmt=getConnection().prepareStatement(sql);
		rs=pstmt.executeQuery();
	} catch (SQLException ex) {
		// TODO: handle exception
		System.err.println("query error"+ex.getMessage());
	}
	return rs;
	  
  }
  public boolean execute(String sql) //执行方法
  {
	  try{
		 pstmt=getConnection().prepareStatement(sql);
		 if(pstmt.execute())
			 return true;
	  }
	  catch(SQLException ex)
	  {
		System.err.println("query error"+ex.getMessage());
		return false;
	  }
	  return true;
  }
  public int executeUpdate(String sql)//更新方法
  {
	  int ResultNum=0;
	  try
	  {
		  pstmt=getConnection().prepareStatement(sql);
		  ResultNum=pstmt.executeUpdate();
	  }
	  catch(SQLException ex)
	  {
		  System.err.println("update error:"+ex.getMessage());
	  }
	  finally
	  {
		  
	  }
	  return ResultNum;
  }
 
}