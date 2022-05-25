package CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRowsBasedOnSortingOrder {

	public static void main(String[] args) throws SQLException {


		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		String query="select *from employees order by esalary asc";
		
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
