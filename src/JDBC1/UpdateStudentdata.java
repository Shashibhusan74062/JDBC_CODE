package JDBC1;

import java.sql.*;
import java.util.Scanner;
public class UpdateStudentdata 
{
 public static void main(String[] args)
 {
	 Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");
			if(conn == null){System.out.println("Unable to connect to mysql");}
			else{
				System.out.println("Connection successfull");
				Scanner sc9 = new Scanner(System.in);
				System.out.println("Enter the id of the user you want to update.");
				int id = sc9.nextInt();
				
				if (id <= 0)
				{
					System.out.println("id cannot be less than or equal to zero");
				}
				else {
					 PreparedStatement p1 = conn.prepareStatement("select * from student where id = '"+id+"'");
					 ResultSet onestudent = p1.executeQuery();
					 if(onestudent.next())
					 {
						 System.out.println("Connection successfull");
							System.out.println("Displaying everthing from student table");
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
							
							PreparedStatement ps5 = conn.prepareStatement("update student set first_name = '"+first_name+"' , last_name = '"+last_name+"' , email = '"+email+"' ,gender='"+gender+"' where id ='"+id+"' ");
							int result = ps5.executeUpdate();
							if(result > 0){
							      System.out.println("Records successfully Updated");
							      
							      PreparedStatement ps6 = conn.prepareStatement("select * from student where id = '"+id+"'");
							      ResultSet rs6 =  ps6.executeQuery();
							    while(rs6.next())   {
								System.out.println((rs6.getInt(1) + " " + rs6.getString(2) + " " + rs6.getString(3)+ rs6.getString(4) + " " + rs6.getString(5)));
							    }
							}
							else{System.out.println("Unable to update records");}
						}
					 
					 else {
						 System.out.println("Id : "+ id + " Not found in the database.");
					 }
				}
			}
		}
		catch(Exception ex)
	        {	
	            ex.printStackTrace();
	         }

 }
}
