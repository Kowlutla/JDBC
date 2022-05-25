/**
 * 
 */
package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author apiiit-rkv CREATE PROCEDURE getEmpSalById(IN id int,OUT salary
 *         double) BEGIN select esalary into salary from employees where eno=id;
 *         END?
 */
public class EmployeesHigherThanSalary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection con = null;
		ResultSet rs = null;
		Scanner sc=new Scanner(System.in);
		CallableStatement cst=null;
		try {
			con=JDBCUtil.createConnection();
			String query="{call getEmployeeBySalary(?)}";
			System.out.print("Enter Min Salary: ");
			double min=sc.nextDouble();
			cst=con.prepareCall(query);
			cst.setDouble(1, min);
			
			rs=cst.executeQuery();
			boolean have=false;
			while(rs.next())
			{
				have=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			if(!have) {
				System.out.println("No Records found");
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally {
			try {
				if(rs!=null)
				{
					rs.close();
					cst.close();
					con.close();
				}
				sc.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}
