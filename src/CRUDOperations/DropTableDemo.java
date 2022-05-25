package CRUDOperations;

import java.sql.*;

public class DropTableDemo {

	public static void main(String[] args)throws Exception
	{
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		st.executeUpdate("drop table employees");
		System.out.println("Successfully Table deleted");
		con.close();
	}

}
