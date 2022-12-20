package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.Account;

public class AccountDao {
	Connection con =null;
	//Laays danh sacsh account
	public List<Account> GetAllAccount(){
		List<Account> arrAccount = new ArrayList<Account>();
		String sql = "select * from account";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 arrAccount.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrAccount;
	}
	//Check login có trong sql hay không-->Trả về Account khi tìm thấy và null khi ko có
	public Account CheckExitsLogin(String  email, String pass) {
		Account a = new Account();
		String sql = "Select * from Account where user_name = ? and password =?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getString(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setIs_admin(rs.getBoolean(4));
				a.setIs_delete(rs.getBoolean(5));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//Check Đăng ký gamil có trong sql hay không-->Trả về Account khi tìm thấy và null khi ko có
	public boolean CheckExitsRegister(String  email) {
		Account a = new Account();
		String sql = "Select * from Account where user_name = ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getString(1));
				a.setUsername(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setIs_admin(rs.getBoolean(4));
				a.setIs_delete(rs.getBoolean(5));
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//Tạo tài khaonr mới
	public void Register(Account acc) {
		String sql = "insert into Account values(?,?,?,?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, acc.getId());
			ps.setString(2, acc.getUsername());
			ps.setString(3, acc.getPassword());
			ps.setBoolean(4, acc.isIs_admin());
			ps.setBoolean(5, acc.isIs_delete());
			ps.executeUpdate();
		} catch (Exception e) {
		
		}
	}
	//Xóa tài khoản
	public boolean Delete(String aid, String uid) {
		String sql = "update Account set isDelete = ? where id = ?";
		String sql1 = "update Users set is_delete = ? where id = ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps.setBoolean(1, true);
			ps.setString(2, aid);
			ps1.setBoolean(1, true);
			ps1.setString(2, uid);
			ps.executeUpdate();
			ps1.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(new AccountDao().GetAllAccount());
	}
}
