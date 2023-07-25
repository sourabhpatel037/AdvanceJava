// program to insert record with the help of dynamic query (rollno,name,marks)in student2 table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Scanner;

public class DyDemo {

	public static void main(String[] args) {
      try {
		Scanner s=new Scanner (System.in);
		  System.out.println("Enter Roll Number");
		  int rollno=s.nextInt();
		  System.out.println("Enter Your Name");
		   String name=s.next();
		   System.out.println("Enter Your Marks");
		   int marks=s.nextInt();
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		   java.sql.CallableStatement cstmt=con.prepareCall("insert into student2 values (?,?,?)");
		   cstmt.setInt(1, rollno);
		   cstmt.setString(2, name);
		   cstmt.setInt(3, marks);
		   cstmt.executeUpdate();
		   System.out.println("One Record Inserted Successfully");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
       
	}

}
