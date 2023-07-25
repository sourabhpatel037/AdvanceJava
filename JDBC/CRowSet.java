 // program OracleJDBCRowSet to see meta data(rollNo,name marks) only select query runs in RowSet (select * from student2);

package jdbc;
	
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CRowSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	try (CachedRowSet crs = new OracleCachedRowSet()) {
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		  crs.setUsername("system");
		  crs.setPassword("tiger");
		  crs.setCommand("select * from student2");
		  crs.execute();
		  ResultSetMetaData rm= crs.getMetaData();
		  int n= rm.getColumnCount();
		  for (int i=1; i<=n;i++)
		  {
		  System.out.print(rm.getColumnName(i)+"\t");
		  }
		   System.out.println();
		   while(crs.next())
		   {
			   System.out.print(crs.getInt(1)+"\t");
			   System.out.print(crs.getString(2)+"\t");
			   System.out.print(crs.getInt(3));
		   }
		   
		   System.out.println("program working properly");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
