// Program to demonstrate setAutoCommit(), getAutoCommit() & Commit();

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoCommit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
	boolean b1= con.getAutoCommit();
	System.out.println(b1);
	con.setAutoCommit(false);
	Statement stmt= con.createStatement();
	stmt.executeUpdate("insert into student2 values (4,'shubham',91)");
	con.commit();
	System.out.println("One recod Inserted Succesfully");
	boolean b2=con.getAutoCommit();
	System.out.println(b2);
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
