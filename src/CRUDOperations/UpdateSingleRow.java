package CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class UpdateSingleRow {

	public static void main(String[] args)throws Exception
	{
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		String query="update employees set esalary=55000 where ename='kowlutla swamy'";
		
		Connection con=DriverManager.getConnection(url,user,password);
		Statement st=con.createStatement();
		int updateCount=st.executeUpdate(query);
		System.out.println("Number of rows affected: "+updateCount);
		con.close();
	}

}
