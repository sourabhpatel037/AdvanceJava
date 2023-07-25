package jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleWebRowSet;
public class WebRowSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
		OracleWebRowSet wrs = new OracleWebRowSet(); 
			wrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			 wrs.setUsername("system");
			 wrs.setPassword("tiger");
			 wrs.setCommand("select * from student2");
			 wrs.execute();
			 FileOutputStream fos = new FileOutputStream("student.Xml");
			 wrs.writeXml(fos);
	} catch (FileNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}
	}
