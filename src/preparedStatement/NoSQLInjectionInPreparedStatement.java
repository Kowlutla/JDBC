package preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NoSQLInjectionInPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst=null;
		Scanner sc=null;
		try {
			con = JDBCUtil.createConnection();
			sc=new Scanner(System.in);
			pst=con.prepareStatement("select count(*) from users where name=? and password=?");
			System.out.print("Enter Name: ");
			String name=sc.nextLine();
			System.out.print("Enter Password: ");
			String password=sc.nextLine();
			pst.setString(1, name);
			pst.setString(2, password);
			rs=pst.executeQuery();
			int count=0;
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count==0)
			{
				System.out.println("Invalid Credential");
			}
			else
			{
				System.out.println("Valid Credential");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
					pst.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
