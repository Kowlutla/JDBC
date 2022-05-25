package blobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingImage {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		//Connection con=DriverManager.getConnection("jdbc:mysql:///student", "user", null);
		
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="";
		
		//String query="select count(*) from employees";
		Connection con=DriverManager.getConnection(url, user, password);
		
		System.out.println("Connection established..");
		File file=new File("/home/apiiit-rkv/Pictures/WhatsApp Image 2020-02-15 at 12.33.58.jpeg");
		FileInputStream fis=new FileInputStream(file);
		
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO person VALUES(?,?)");
	      pstmt.setString(1, "kowlutla");
	      pstmt.setBlob(2, fis);
	      //Executing the statement
	      pstmt.execute();
	      System.out.println("Record inserted......");

	}

}
