// program for cursor moving i absolute place (rollno,name,marks)in student2 table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CmoveDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			java.sql.Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("Select * from student2");
			rs.absolute(2);
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
