package aggrigateFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountRows {

	public static void main(String[] args) throws Exception
	{

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		String query="select count(*) from employees";
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next())
		{
			System.out.println("The Number of records: "+rs.getInt(1));
		}
		con.close();
	}

}
