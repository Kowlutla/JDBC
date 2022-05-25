package CRUDOperations;

import java.sql.*;
import java.util.*;
public class InsertMultipleDynamicRows {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		while(true)
		{

			System.out.print("Enter employee id: ");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter employee name: ");
			String ename=sc.nextLine();
			System.out.print("Enter employee salary: ");
			double esalary=sc.nextDouble();
			
			String query=String.format("insert into employees values(%d,'%s',%f)",eid,ename,esalary);
			st.executeUpdate(query);
			System.out.println("* * * * Data recoreded successfully * * * *");
			System.out.println("Do you want to insert another record?[Yes/No]");
			String option=sc.next();
			if(option.equalsIgnoreCase("No"))
			{
				break;
			}
		}
		sc.close();
		con.close();
		
	}

}
