// program to see metadata column   (rollno,name,marks)in student2 table

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student2");
			ResultSetMetaData rm = rs.getMetaData();
			int n = rm.getColumnCount();
			for (int i = 1; i <= n; i++) {
				System.out.println(rm.getColumnName(i) + "/t");
			}
			System.out.println();
			while (rs.next())
				;
			{
				System.out.println(rs.getInt("rollno") + "/t");
				System.out.println(rs.getString("name") + "/t");
				System.out.println(rs.getInt("marks"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
