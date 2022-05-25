package CRUDOperations;

import java.sql.*;
public class CreateTableDemo {

	public static void main(String[] args) throws SQLException {
		
		//final String url="jdbc:mysql://localhost:3306/student";
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="";
		String query="create table employees(eno int,ename varchar(20),esalary double(10,2))";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		st.executeUpdate(query);
		System.out.println("Table created");
		con.close();
		
	}

}
