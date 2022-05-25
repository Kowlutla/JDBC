package preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPreparedStatement {

	public static void main(String[] args) {
		
		Connection con=null;
		try {
			con=JDBCUtil.createConnection();
			String query="insert into employees values(?,?,?)";
			Scanner sc=new Scanner(System.in);
			PreparedStatement pst=con.prepareStatement(query);
			while(true)
			{
				System.out.print("Enter Id: ");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name: ");
				String name=sc.nextLine();
				System.out.print("Enter Salary: ");
				double salary=sc.nextDouble();
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setDouble(3, salary);
				pst.executeUpdate();
				System.out.println("Data Successfully inserted");
				System.out.print("\nDo you want to insert one more record[Yes/No]:");
				String option=sc.next();
				if(option.equalsIgnoreCase("no"))
				{
					break;
				}
			}
			sc.close();
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
