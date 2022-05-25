package executeMethodLoopholes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectQueries {

	public static void main(String[] args) throws Exception
	{

		String url="jdbc:mysql:///student";
		String user="root";
		String password="";
		Connection con=DriverManager.getConnection(url,user,password);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Query: ");
		String query=sc.nextLine();
		boolean b=st.execute(query);
		if(b)
		{
			ResultSet rs=st.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
		}
		else
		{
			int updateCount=st.getUpdateCount();
			System.out.println("No of rows Effected: "+updateCount);
		}
		con.close();
		sc.close();
	}

}
