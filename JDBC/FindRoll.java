
//program to find marks by roll number in student2 table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindRoll {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner (System.in);
			System.out.println("Enter Roll Number To Get Marks");
			int rollno = s.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" ,"tiger");
			java.sql.PreparedStatement psmt=con.prepareStatement("select marks from student2 where rollno=?");
			psmt.setInt(1,rollno);
			ResultSet res= psmt.executeQuery();
			res.next();
			int marks=res.getInt(1);
			System.out.println(marks);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
