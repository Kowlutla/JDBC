package CRUDOperations;

import java.sql.*;
public class SelectAllRows {

	public static void main(String[] args)throws Exception
	{
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		String query="select *from employees";
		
		ResultSet rs=st.executeQuery(query);
		boolean flag=false;;
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		}
		
		if(!flag)
		{
			System.out.println("No records in Database");
		}
		con.close();
	}

}
