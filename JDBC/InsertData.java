// program to Insert data (rollno,name,marks)in student2 table

package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main (String[]args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "tiger");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select rollno,name,marks from student2");
			rs.moveToInsertRow();
			rs.updateInt(1,8);
			rs.updateString(2,"Ansu");
			rs.updateInt(3, 100);
			rs.insertRow();
			System.out.println("One Record Inserted Successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
