package aggrigateFunctions;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllRowsToHTMLPage {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";

		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery("select *from employees order by esalary desc");

		
		String data="<html><body bgcolor='blue' text='white'> <table border='2'>";
		data=data+"<tr><td>ENO</td><td>ENAME</td><td>ESALARY</td></tr>";
		while(rs.next())
		{
			data=data+"<tr><td>"+rs.getInt(1)+"<td>"+rs.getString(2)+"<td>"+rs.getDouble(3);
		}
		
		data=data+"</table></body></html>";
		
		FileOutputStream fos=new FileOutputStream("emp.html");
		byte[]b=data.getBytes();
		fos.write(b);
		fos.flush();
		System.out.println("Open emp.html to see employee data");
		fos.close();
		con.close();
	}

}
