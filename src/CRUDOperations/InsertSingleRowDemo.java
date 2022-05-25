package CRUDOperations;

import java.sql.*;
public class InsertSingleRowDemo {

	public static void main(String[] args)throws Exception
	{
		
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		String query="insert into employees values(101,'kowlutla',50000)";
		Connection con=DriverManager.getConnection(url,user,password);
		Statement st=con.createStatement();
		int updateCount=st.executeUpdate(query);
		System.out.println("Number of rows effected: "+updateCount);
		con.close();
		
	}

}
