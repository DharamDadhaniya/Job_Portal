package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;
	public static Connection GetConnection() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal","root","Dharam@706");
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}
