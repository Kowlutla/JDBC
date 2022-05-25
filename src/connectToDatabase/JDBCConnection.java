package connectToDatabase;

import java.sql.*;
public class JDBCConnection {

	public static void main(String[] args) throws Exception {
		
//		Class.forName("com.mysql.jdbc.Driver");
		final String url="jdbc:mysql://localhost:3306/student";
		final String uname="root";
		final String pass="";
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from students");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+".Full Name is: "+rs.getString(2)+" "+rs.getString(3));
		}
		con.close();
	}

}
