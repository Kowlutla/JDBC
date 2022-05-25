package workingWithDateValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDateValues {

	public static void main(String[] args) throws SQLException, ParseException {

		Connection con=DriverManager.getConnection("jdbc:mysql:///student", "root", "");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement pst=con.prepareStatement("insert into proposals values(?,?)");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter Your Name: ");
			String name=sc.next();
			System.out.print("Enter Your Proposal Date: (YYYY-MM-DD)");
			String date=sc.next();
			java.util.Date udate=sdf.parse(date);
			long l=udate.getTime();
			java.sql.Date sdate=new java.sql.Date(l);
			pst.setString(1, name);
			pst.setDate(2, sdate);
			pst.addBatch();
			System.out.println("Do you want insert again(Yes/No):");
			String option=sc.next();
			if(option.equalsIgnoreCase("No"))
			{
				break;
			}
		}
		
		int count[]=pst.executeBatch();
		int temp=0;
		for(int i:count)
		{
			temp+=i;
		}
		System.out.println("Number of records inserted: "+temp);
		con.close();
	}

}
