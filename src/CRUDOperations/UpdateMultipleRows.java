package CRUDOperations;

import java.util.Scanner;
import java.sql.*;
public class UpdateMultipleRows {

	public static void main(String[] args) throws SQLException {

		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		System.out.print("Enter Increment salary: ");
		double increment=sc.nextDouble();
		System.out.print("Enter Range of salary: ");
		double range=sc.nextDouble();
		String query=String.format("update employees set esalary=esalary+%f where esalary<%f",increment,range);
		
		int updateCount=st.executeUpdate(query);
		System.out.println("Number of rows Affected: "+updateCount);
		con.close();
		sc.close();
	}

}
