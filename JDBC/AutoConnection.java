package jdbc;

import java.sql.*;

class Demo{
public static void main(String[] args)
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery("select * from sourabh");		
		ResultSetMetaData rm = rs.getMetaData();	
		int n = rm.getColumnCount();
		for(int i=1;i<=n;i++) {
			System.out.print(rm.getColumnName(i)+ "\t");
		}

		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+ rs.getInt(3));
		}
		
	} catch (Exception e) 
	{
		e.printStackTrace();
	}
	
}
}
