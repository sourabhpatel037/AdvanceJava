package mvc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {
ResultBean rb;

ResultBean getResult(int hno)
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		
		PreparedStatement pstmt=con.prepareStatement("select * from results where hno=?");
		pstmt.setInt(1, hno);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			rb=new ResultBean();
			rb.setHno(rs.getInt("hno"));
			rb.setName(rs.getString("name"));
			rb.setC(rs.getInt("c"));
			rb.setCpp(rs.getInt("cpp"));
			rb.setJava(rs.getInt("java"));
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rb;
}
}
