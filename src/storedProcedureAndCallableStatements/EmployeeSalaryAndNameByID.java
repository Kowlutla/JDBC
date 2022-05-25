package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
/**
 * 
 * DELIMITER //
	mysql> create procedure getEmpNameSalary(IN id int,OUT salary double,OUT name varchar(20))
    -> begin
    -> select esalary,ename into salary,name from employees where eno=id;
    -> end //

 * @author apiiit-rkv
 *
 */

//STEP1:Make Sure Stored Procedure available in Database
public class EmployeeSalaryAndNameByID {

	public static void main(String[] args) {

		Connection con=null;
		CallableStatement cst=null;
		Scanner sc=new Scanner(System.in);
		try {
			con=JDBCUtil.createConnection();
			String query="{call getEmpNameSalary(?,?,?)}";
			//STEP2:Create CallableStatement with procedural Call
			cst=con.prepareCall(query);
			
			System.out.print("Enter employee Id: ");
			//STEP3:Provide values for every IN Parameter
			int id=sc.nextInt();
			cst.setInt(1, id);
			
			//STEP4:register evrey OUT parameter with JDBC Types
			cst.registerOutParameter(2, Types.DOUBLE);
			cst.registerOutParameter(3, Types.VARCHAR);
			
			//STEP5:Execute the procedural Call
			cst.execute();
			System.out.println("Employee Id: "+id);
			System.out.println("Employee Name: "+cst.getString(3));
			System.out.println("Employee Salary: "+cst.getDouble(2));
			
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
