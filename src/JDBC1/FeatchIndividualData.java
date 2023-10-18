package JDBC1;

import java.sql.*;
import java.util.Scanner;

public class FeatchIndividualData 
{

	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");
			if(conn == null)
			{
				System.out.println("Unable to connect to mysql");
				}
			else
			{
				System.out.println("Connection successfull");
				System.out.println("Displaying everthing from employee table");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the id of the user you want to see");
				int EMPNO = sc1.nextInt();
				PreparedStatement ps = conn.prepareStatement("select * from emp where EMPNO = '"+EMPNO+"' ");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					System.out.println(rs.getInt(1) + "||" + rs.getString(2) + "|| " + rs.getString(3)+"|| "+rs.getInt(4)+"|| "+rs.getInt(5)+"|| "+rs.getInt(6)+" ||" +rs.getInt(7));
				}
			}
		}
		catch(Exception ex)	
		{
			ex.printStackTrace();	
			}

	}
}
