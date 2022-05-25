package preparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionInStatement {

	public static void main(String[] args) throws SQLException {

		Connection con=JDBCUtil.createConnection();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name: ");
		String name=sc.nextLine();
		System.out.print("Enter password: ");
		String password=sc.nextLine();
		
		String query="select count(*) from users where name='"+name+"' and password='"+password+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		int count=0;
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		
		if(count==0)
		{
			System.out.println("Invalid Credential ");
		}
		else
		{
			System.out.println("valid Credential ");
		}
		con.close();
		sc.close();
	}

}
