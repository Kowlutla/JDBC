package storedProcedureAndCallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/*
 * delimiter //
	mysql> create procedure addTwoNumbers(IN num1 int,IN num2 int,OUT sum int)
    -> BEGIN
    -> SET sum=num1+num2;
    -> END//

 */
public class AddTwoNumbers {

	public static void main(String[] args) throws SQLException {

		Connection con=JDBCUtil.createConnection();
		CallableStatement cst=con.prepareCall("{call addTwoNumbers(?,?,?)}");
		cst.setInt(1, 10);
		cst.setInt(2, 20);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		System.out.println("Result is: "+cst.getInt(3));
		con.close();
	}

}
