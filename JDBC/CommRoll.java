// Program to Demonstrate Rollback

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommRoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update student2 set marks=15 where rollno=3");
			con.commit();
			stmt.executeUpdate("delete from student2 where rollno=4");
			con.rollback();
			stmt.executeUpdate("Insert into student2 values(10,'kana',88)");
			con.commit();
			System.out.println("program work properly");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
