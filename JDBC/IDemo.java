// program to insert Values (rollno,name,marks)in student2 table

package jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IDemo {

	public static void main(String[] args) {
     try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		java.sql. Statement stmt=con.createStatement();
		 stmt.executeUpdate("Insert into student2 values (3,'gaurav',24)");
		 System.out.println("One Rrecord Inserted Successfully");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}

}
