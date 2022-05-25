package CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteSingleRowDemo {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		String query=String.format("delete from employees where eno=1337");
		
		int updateCount=st.executeUpdate(query);
		System.out.println("Number of rows deleted: "+updateCount);
		con.close();
		sc.close();
	}

}
