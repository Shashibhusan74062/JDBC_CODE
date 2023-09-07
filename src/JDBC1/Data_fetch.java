package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data_fetch 
{
	public static void main(String[] args) throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/test";
		String un="root";
		String pwd="root";
		Connection conn = DriverManager.getConnection(url, un, pwd);
		Statement stm = conn.createStatement();
		ResultSet res = stm.executeQuery("select *from Data");
		while(res.next())
		{
			String user=res.getString(1);
			String pwd1=res.getString(2);
			System.out.println(user+""+pwd1);
			System.out.println("connected sucessfully.........");
		}
	}
}
