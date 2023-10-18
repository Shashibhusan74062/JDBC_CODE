package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn
{
	public static void main(String[] args) throws SQLException 
	{
	  	Connection conn = null;
	   	try{
	   	  Class.forName("com.mysql.cj.jdbc.Driver");
	   	  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root",  "root");
	   	    if(conn == null)   {
	   		  System.out.println("Unable to connect to mysql database");
	   	  }
	   	  else  	  {
	   		  System.out.println("Successfully connected to mysql database");
	   	  }
	   	   
	   	}
	   	catch(Exception ex)  
	   	{
	   		ex.printStackTrace(); 	
	   	}
	   	conn.close();
	}

	}

