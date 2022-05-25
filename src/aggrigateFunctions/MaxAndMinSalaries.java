package aggrigateFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxAndMinSalaries {

	public static void main(String[] args) throws Exception
	{

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select max(esalary) from employees");
		
		if(rs.next())
		{
			System.out.println("Maximum Salary is "+rs.getDouble(1));
		}
		
		rs=st.executeQuery("select min(esalary) from employees");
		if(rs.next())
		{
			System.out.println("Minimum Salary is "+rs.getDouble(1));
		}
		con.close();
	}

}
