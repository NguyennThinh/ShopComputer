package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.Category;
import Model.Supplier;

public class Category_SuplierDao {
	Connection con= null;
	
	//Lấy danh sách category

	public List<Category> getCategory (){
		List<Category> arrCategory = new ArrayList<Category>();
		String sql = "Select * from Category ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				arrCategory.add(new Category(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrCategory;
	}
	
	//Lấy danh sách supplier
	public List<Supplier> getSupplier (){
		List<Supplier> arrSupplier = new ArrayList<Supplier>();
		String sql = "Select * from Supplier ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				arrSupplier.add(new Supplier(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrSupplier;
	}
//Thêm một nhà sản xuất mới
	public boolean addSupplier(Supplier s) {
		String sql = "insert into Supplier values(?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getId());
			ps.setString(2, s.getsName());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Thêm một Loại sản phẩm mới
		public boolean addCategory(Category c) {
			String sql = "insert into Category values(?,?)";
			try {
				con = new DBContext().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, c.getId());
				ps.setString(2, c.getcName());
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
		}
		public boolean deleteSupplier(String id) {
			String sql = "delete from Supplier where id =?";
			try {
				con = new DBContext().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
		}
		public boolean deleteCategory(String id) {
			String sql = "delete from Category where id =?";
			try {
				con = new DBContext().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
		}
	public static void main(String[] args) {
	
	}
}
