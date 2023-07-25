// program to upload image in database with the help of BLOB in Image table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileInputStream;

import java.io.IOException;

public class BlobDemo {

	public static void main (String []args)  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			PreparedStatement pstmt=con.prepareStatement("insert into images values(?,?)");
			pstmt.setString(1,args[0]);
			FileInputStream fis=new FileInputStream(args[1]);
			pstmt.setBinaryStream(2,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("One Image Inserted SuccesFully");
		} catch (ClassNotFoundException | SQLException | IOException e) {
	
			e.printStackTrace();
		}
		
	}
}
