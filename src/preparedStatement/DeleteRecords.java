package preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecords {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con=JDBCUtil.createConnection();
		String query="delete from employees where ename=?";
		PreparedStatement pst=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.print("Employee Name to delete: ");
			String ename=sc.nextLine();
			pst.setString(1, ename);
			int updateCount=pst.executeUpdate();
			System.out.println("No of rows Effected: "+updateCount);
			System.out.println("\nDo you want to delete more records: ");
			String option=sc.next();
			sc.nextLine();
			if(option.equalsIgnoreCase("no"))
			{
				System.out.println("\nThank You For Using");
				break;
			}
		}
		sc.close();
		con.close();
	}

}
