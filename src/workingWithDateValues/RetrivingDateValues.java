package workingWithDateValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrivingDateValues {

	public static void main(String[] args) throws SQLException {


		Connection con=DriverManager.getConnection("jdbc:mysql:///student", "root", "");
		PreparedStatement pst=con.prepareStatement("select *from proposals");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			String name=rs.getString(1);
			java.sql.Date date=rs.getDate(2);
			
			System.out.println(name+" . . . "+date);
			
		}
		
		con.close();
	}

}
