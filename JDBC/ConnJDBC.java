package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnJDBC {

	
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			System.out.println("connection established successfully");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}