package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * @author apiiit-rkv
 * DELIMITER //
	mysql> create procedure getAllEmployees()
    -> begin
    -> select *from employees;
    -> end //

 *
 */
public class GetAllEmployees {
	public static void main(String[] args) {

		Connection con=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		try {
			con=JDBCUtil.createConnection();
			String query="{call getAllEmployees()}";
			//STEP2:Create CallableStatement with procedural Call
			cst=con.prepareCall(query);
			
			//STEP5:Execute the procedural Call
			rs=cst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					cst.close();
					con.close();
					rs.close();
					sc.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
