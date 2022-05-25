package batchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdatePreparedStatement {

	public static void main(String[] args) {
		


		Connection con=null;
		Scanner sc = null;
		try {
			
			con=DriverManager.getConnection("jdbc:mysql:///student", "root", "");
			PreparedStatement pst=con.prepareStatement("insert into employees values(?,?,?)");
			sc=new Scanner(System.in);
			while(true)
			{
				System.out.print("Enter Employee Number: ");
				int eno=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Employee Name: ");
				String ename=sc.nextLine();
				System.out.print("Enter Employee Salary: ");
				double salary=sc.nextDouble();
				
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setDouble(3, salary);
				
				pst.addBatch();
				
				System.out.println("DO YOU WANT TO INSERT ONE MORE EMPLOYEE(YES/NO):");
				System.out.print("Your Choice: ");
				String choice=sc.next();
				if(choice.equalsIgnoreCase("no"))
				{
					break;
				}
			}
			
			int count[]=pst.executeBatch();
			
			int updateCount=0;
			for(int c:count)
			{
				updateCount+=c;
			}
			
			System.out.println("No Of Employees Recorded: "+updateCount);
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally {
			try {
				sc.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}

}
