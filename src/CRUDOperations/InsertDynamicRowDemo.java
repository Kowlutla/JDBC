package CRUDOperations;

import java.sql.*;
import java.util.Scanner;

public class InsertDynamicRowDemo {

	public static void main(String[] args) throws Exception
	{

		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
	
		Statement st=con.createStatement();
		
		System.out.print("Enter employee id: ");
		int eid=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter employee name: ");
		String ename=sc.nextLine();
		System.out.print("Enter employee salary: ");
		double esalary=sc.nextDouble();
		
		//String query="insert into employees values("+eid+",'"+ename+"',"+esalary+")";
		String query=String.format("insert into employees values(%d,'%s',%f)",eid,ename,esalary);
		st.executeUpdate(query);
		System.out.println(eid+" "+ename+" "+esalary+" inserted to database");
		con.close();
		sc.close();
	}

}
