package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author apiiit-rkv
 DELIMITER ?
mysql> create procedure getEmployeeByIntial(IN initial VARCHAR(10))
    -> BEGIN
    -> select *from employees where ename like initial;
    -> END ?


 */
public class EmployeeByInitialCharacter {

	public static void main(String[] args) {

		Connection con = null;
		ResultSet rs = null;
		Scanner sc=new Scanner(System.in);
		CallableStatement cst=null;
		try {
			con=JDBCUtil.createConnection();
			String query="{call getEmployeeByIntial(?)}";
			System.out.print("Enter Initial Character: ");
			String initial=sc.next()+"%";
			cst=con.prepareCall(query);
			cst.setString(1, initial);
			
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
