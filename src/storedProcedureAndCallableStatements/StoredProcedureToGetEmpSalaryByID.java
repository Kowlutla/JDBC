/**
 * DELIMITER ?
	mysql> CREATE PROCEDURE getEmpSalById(IN id int,OUT salary double)
    -> BEGIN
    -> select esalary into salary from employees where eno=id;
    -> END ?

 */
package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

/**
 * @author apiiit-rkv
 *
 */
public class StoredProcedureToGetEmpSalaryByID {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Connection con = JDBCUtil.createConnection();
		CallableStatement cst = con.prepareCall("{call getEmpSalById(?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee number: ");
		int num = sc.nextInt();
		cst.setInt(1, num);
		cst.registerOutParameter(2, Types.INTEGER);
		cst.execute();
		System.out.println("Salary of " + num + " id employee is: " + cst.getDouble(2));
		con.close();
		sc.close();

	}

}
