package storedProcedureAndCallableStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	static String url="jdbc:mysql:///student";
	static String user="root";
	static String password="";
	public static Connection createConnection() throws SQLException
	{
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}
}
