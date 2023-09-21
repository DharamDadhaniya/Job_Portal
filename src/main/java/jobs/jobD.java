package jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import model.Jobs;

public class jobD {

	private Connection conn;

	public jobD(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addjobs(Jobs j) {

		boolean f = false;

		try {
			String sql = "insert into jobs(title, description, category, status, location) value(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Jobs> getAllJobs() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try {
			String str = "select * from jobs order by id desc";

			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public Jobs getJobByID(int id) {

		Jobs j = null;
		try {
			String str = "select * from jobs where id=?";

			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return j;

	}

	public boolean UpdateJob(Jobs j) {

		boolean f = false;

		try {
			String sql = "update jobs set title=?, description=?, category=?, status=?, location=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public boolean deletejobs(int id) {

		boolean f = false;
		try {

			String str = "delete from jobs where id=?";

			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				f = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}
	
	public List<Jobs> getAllJobsForUser() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;
		try {
			String str = "select * from jobs where status=? order by id desc";

			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
