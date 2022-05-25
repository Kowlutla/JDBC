package CRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectParticularRows {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";

		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection(url, user, password);

		Statement st = con.createStatement();

		String query = String.format("select ename,esalary from employees");
		boolean haverecords = false;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			haverecords = true;
			System.out.println(rs.getString(1) + " " + rs.getDouble(2));
		}

		if (!haverecords) {
			System.out.println("No recors in between range");
		}
		con.close();
		sc.close();
	}

}
