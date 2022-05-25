package aggrigateFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxAndMinSalaryEmployee {


	public static void main(String[] args) throws Exception
	{

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		System.out.println("Maximum Salary employee details:");
		ResultSet rs=st.executeQuery("select *from employees where esalary in (select max(esalary) from employees)");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		}
		
		con.close();
	}

}
