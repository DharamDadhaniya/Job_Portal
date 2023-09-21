package jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserD {
	
	private Connection conn;

	public UserD(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean AddUser(User u) {
		
		boolean f = false;
		try {
			
			String str = "insert into users(name, qualification, email, password, role) value(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getRole());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	public User login(String em, String ps) {
		
		User u = null;
		try {
		String str = "select * from users where email=? and password=?";
		
			PreparedStatement ps1 = conn.prepareStatement(str);
			ps1.setString(1, em);
			ps1.setString(2, ps);
			
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()) {
				
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setQualification(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setRole(rs.getString(6));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
	}

}
