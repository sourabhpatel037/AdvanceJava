
// program to update data (rollno,name,marks)in student2 table
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		 java.sql.Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 ResultSet rs=stmt.executeQuery("select rollno,name,marks from student2");
		 rs.absolute(3);
		 rs.updateInt(3,10);
		 rs.updateRow();
		 System.out.println("One Record updated");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

}
