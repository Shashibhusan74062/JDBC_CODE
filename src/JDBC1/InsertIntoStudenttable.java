package JDBC1;

import java.sql.*;
import java.util.Scanner;
public class InsertIntoStudenttable 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");
			if(conn == null){	System.out.println("Unable to connect to mysql");}
			else{
				System.out.println("Connection successfull");
				System.out.println("Displaying everthing from student table");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the studentid");
				String id = sc1.next();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter the fname");
				String first_name = sc2.next();
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Enter the lname");
				String last_name = sc3.next();
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Enter the email");
				String email = sc4.next();
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Enter the gender");
				String gender = sc5.next();
	PreparedStatement ps = conn.prepareStatement("insert into student(id, first_name, last_name, email, gender) values ('"+id+"','"+first_name+"','"+last_name+"','"+email+"','"+gender+"')");
				int result = ps.executeUpdate();
				if(result > 0){
				    PreparedStatement ps1 = conn.prepareStatement("select * from student");
				    ResultSet rs =  ps1.executeQuery();
				    while(rs.next())   {
				      System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ rs.getString(4) + " " + rs.getString(5));
				    }
				}
				else{System.out.println("Unable to insert records");}
			}
		}
		catch(Exception ex)
		{	
			ex.printStackTrace();	
		}
	}
}
				
	





	
