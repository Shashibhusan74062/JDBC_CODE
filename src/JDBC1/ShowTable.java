package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowTable
{
	public static void main(String[] args) throws SQLException 
	{
	  	Connection conn = null;
	   	try{
	   	  Class.forName("com.mysql.cj.jdbc.Driver");
	   	  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root",  "root");
	   	    if(conn == null)   {
	   		  System.out.println("Unable to connect to mysql database");
	   	  }
	   	  else  	  {
	   		  System.out.println("Successfully connected to mysql database");
	   	  }
	   	  System.out.println("Displaying all the all the tables");
  		   PreparedStatement ps = conn.prepareStatement("show tables");
  		   ResultSet rs  =  ps.executeQuery();
  		   while(rs.next())  
  		   {
  	         System.out.println(rs.getString(1));
  		   }
	   	   
	     	}
	   	catch(Exception ex)  
	   	{
	   		ex.printStackTrace(); 	
	   	}
	   	conn.close();
	}
}
