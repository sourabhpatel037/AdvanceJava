// Program to Demonstrate SavePoint;

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		con.setAutoCommit(false);
		Statement stmt= con.createStatement();
		stmt.executeUpdate("update student2 set marks=12 where rollno=3");
		Savepoint s= con.setSavepoint();
		stmt.executeUpdate("delete from student2 where rollno=8");
		con.rollback(s);
		stmt.executeUpdate("insert into student2 values(9,'shubham',91)");
		con.commit();
		System.out.println("program working properly");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
