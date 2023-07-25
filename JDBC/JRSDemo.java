 // program OracleJDBCRowSet to see meta data(rollNo,name marks) only select query runs in RowSet (select * from student2);

package jdbc;
	
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JRSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	try (JdbcRowSet jrs = new OracleJDBCRowSet()) {
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		  jrs.setUsername("system");
		  jrs.setPassword("tiger");
		  jrs.setCommand("select * from student2");
		  jrs.execute();
		  ResultSetMetaData rm= jrs.getMetaData();
		  int n= rm.getColumnCount();
		  for (int i=1; i<=n;i++)
		  {
		  System.out.print(rm.getColumnName(i)+"\t");
		  }
		   System.out.println();
		   while(jrs.next())
		   {
			   System.out.print(jrs.getInt(1)+"\t");
			   System.out.print(jrs.getString(2)+"\t");
			   System.out.print(jrs.getInt(3));
		   }
		   
		   System.out.println("program working properly");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
