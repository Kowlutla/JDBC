package aggrigateFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNthHighestSalaryEmployee {

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";

		Scanner sc=new Scanner(System.in);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		System.out.println("Enter N: ");
		int n=sc.nextInt();
		String query="select *from(select eno,ename,esalary,rank() over(order by esal DESC) ranking from employees) where ranking="+n;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
		}

		con.close();
		sc.close();
	}

}
