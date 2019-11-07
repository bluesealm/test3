package com.wf.DaoImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
  public Connection connect(String port,String database){
	  Connection conn = null;
	  try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch(ClassNotFoundException e){
	    	e.printStackTrace();
	    }
	    		
	    try {
			conn=DriverManager.getConnection("jdbc:mysql://192.168.136.219:"+port+"/"+database,"dev","dev@2016");
			System.out.println("database connection successfully");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");  
			e.printStackTrace();
		}
	    return conn;
  }
 
}