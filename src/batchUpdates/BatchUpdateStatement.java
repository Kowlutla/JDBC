package batchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateStatement {

	public static void main(String[] args) {

		Connection con=null;
		try {
			
			con=DriverManager.getConnection("jdbc:mysql:///student", "root", "");
			Statement st=con.createStatement();
			st.addBatch("insert into employees values(1129,'sudeep',55000)");
			st.addBatch("delete from employees where eno=1337");
			st.addBatch("update employees set esalary=70000 where eno=1344");
			
			int []count=st.executeBatch();
			int updateCount=0;
			for(int c:count)
			{
				updateCount+=c;
			}
			System.out.println("No of rows Effected: "+updateCount);
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}

}
