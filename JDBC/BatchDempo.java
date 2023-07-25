// program to Insert,update,Delete in single program with the help of batch  (rollNo,name,marks)in student2 table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDempo {

	public static void main(String[] args) {
		
      try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "tiger");
		  Statement stmt=con.createStatement();
		  stmt.addBatch("insert into student2 values (8,'ansul',17)");
		  stmt.addBatch("update student2 set marks=11 where rollno=3");
		  stmt.addBatch("delete student2 where marks=21");
		  stmt.executeBatch();
		  System.out.println("ALL QUERY WORKING SUCESSFULLY");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	}

}
