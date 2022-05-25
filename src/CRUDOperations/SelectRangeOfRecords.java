package CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectRangeOfRecords {

	public static void main(String[] args)throws Exception
	{

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection(url,user,password);
		
		Statement st=con.createStatement();
		System.out.println("Enter minimum Salary: ");
		double min=sc.nextDouble();
		System.out.println("Enter maxumum Salary: ");
		double max=sc.nextDouble();
		
		String query=String.format("select *from employees where esalary>=%f and esalary<=%f", min,max);
		boolean haverecords=false;
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			haverecords=true;
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		}
		
		if(!haverecords)
		{
			System.out.println("No recors in between range");
		}
		con.close();
		sc.close();
	}

}
