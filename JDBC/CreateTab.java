 // program to Create table (rollno,name,marks)in student2 table

package jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateTab{
	public static void main(String []args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			java.sql.Statement smt =  con.createStatement();
			smt.execute("create table student3 (rollno number(3),name varchar2(10), marks number(3))");
			System.out.println("Table Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}