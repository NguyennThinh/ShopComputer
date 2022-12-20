package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.User;

public class UserDao {
	Connection con = null;

	public List<User> getAllUsers() {
		List<User> arrUsers = new ArrayList<User>();
		String sql = "select * from Users";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				arrUsers.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrUsers;
	}

	// Tạo user mới
	public void insert(User u) {
		String sql = "insert into Users values(?,?,?,?,?,?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getId());
			ps.setString(2, u.getFullName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getId_Account());
			ps.setBoolean(7, u.isIs_delete());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tìm user theo id account dùng cho login
	public User findUserbyIdAcc(String id) {
		String sql = "Select * from Users where id_account = ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void main(String[] args) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + new Timestamp(10000));

	}
}
