package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/**
 * DELIMITER ?
CREATE FUNCTION getEmpInRange(first INT,last INT)RETURNS CURSOR
BEGIN
DECLARE empCursor
CURSOR FOR SELECT * FROM employees WHERE eno>=first and eno<=last;
CLOSE empCursor;
END ?

 */

/**
 * @author apiiit-rkv
 * create function getAvg(id1 int,id2 int)RETURNS DOUBLE(10,2)
    -> BEGIN
    -> DECLARE sal1 DOUBLE;
    -> DECLARE sal2 DOUBLE;
    -> select esalary into sal1 from employees where eno=id1;
    -> select esalary into sal2 from employees where eno=id2;
    -> return (sal1+sal2)/2;
    -> END ?
 *
 */
public class EmployeesAverageUsingFunctions {

	public static void main(String[] args) {
	
		Connection con=null;
		CallableStatement cst=null;
		Scanner sc=new Scanner(System.in);
		try {
			con=JDBCUtil.createConnection();
			String query="{?=call getAvg(?,?)}";
			//STEP2:Create CallableStatement with procedural Call
			cst=con.prepareCall(query);
			System.out.print("Enter ID1: ");
			int id1=sc.nextInt();
			System.out.print("Enter ID2: ");
			int id2=sc.nextInt();
			
			cst.setInt(2, id1);
			cst.setInt(3, id2);
			
			cst.registerOutParameter(1,Types.DOUBLE);
			cst.execute();
			System.out.println("Average Salary is: "+cst.getDouble(1));
			

			
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
