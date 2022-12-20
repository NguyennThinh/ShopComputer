package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.JoinCartDeatil;
import Model.Product;
import Model.ProductDetail;

public class ProductDao {
	Connection con = null;

//Lấy danh sách sản phẩm
	public List<Product> getListProduct() {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "SELECT*FROM Product ORDER BY id desc ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}

//Lấy top 10 sản phẩm SALE mới nhất
	public List<Product> getProductSale() {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "SELECT TOP(10)*FROM Product where sale >0 and is_delete != ? and quantily >0 ORDER BY id desc ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}

	// Lấy top 6 sản phẩm mới nhất
	public List<Product> getTop6Product() {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "SELECT TOP(6) *FROM Product where is_delete != ? and quantily >0 ORDER BY id desc  ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}

//Lấy 2 sản phẩm được bán nhiều nhất
	public List<Product> getProductSold() {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "SELECT TOP(2) *FROM Product WHERE is_delete != ? and quantily >0 ORDER BY sell_number desc ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}

	// Lấy chi tiết sản phẩm
	public Product findProductbyID(int id) {
		String sql = "select * from Product where id =?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getBoolean(12));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//Lấy tổng số sản phẩm
	public int totalProduct() {

		String sql = "select count (*) from Product where is_delete != ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// Lấy ds sản phảm theo trang
	public List<Product> getAllProductbyCategory(int Page, String id) {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "select * from Product where id_category =? and is_delete != ? order by id offset ? rows fetch next 9 rows only";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setBoolean(2, true);
			ps.setInt(3, (Page - 1) * 9);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}
	// Lấy ds sản phảm theo trang
	public List<Product> getAllProductbySupplier(int Page, String id) {

		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "select * from Product where id_supplier =? and is_delete != ? order by id offset ? rows fetch next 9 rows only";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setBoolean(2, true);
			ps.setInt(3, (Page - 1) * 9);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;
	}

	// Giảm số lượng sản phẩm sau khi checkout
	public void updateProductafterSale(List<JoinCartDeatil> list) {
		String sql = "UPDATE Product SET quantily -= ?,  sell_number += ? WHERE id = ?";

		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			for (JoinCartDeatil jc : list) {

				ps.setInt(1, jc.getQuantily());
				ps.setInt(2, jc.getQuantily());
				ps.setInt(3, jc.getIdProduct());
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Tìm kiếm sản phẩm
	public List<Product> searchProduct(String fullname) {
		List<Product> arrProduct = new ArrayList<Product>();
		String sql = "Select * from Product where product_name LIKE ? and is_delete != ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + fullname + "%");
			ps.setBoolean(2, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrProduct;

	}

	// Delete Sản phẩm
	public boolean deleteProduct(int id) {
		String sql = "update Product set is_delete = ? where id = ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
//Thêm sản phẩm
	public void addProduct(Product p) {
		String sql = "insert into  Product values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getSale());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getIdSuplier());
			ps.setString(5, p.getDescription());
			ps.setString(6, p.getPhoto());
			ps.setInt(7, p.getQuantily());
			ps.setInt(8, p.getSold());
			ps.setString(9, p.getIdCategory());
			ps.setString(10, p.getIdProductDetail());
			ps.setBoolean(11, p.isDelete());
	
			ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	/****************************
	 * ProductDetail
	 **************************************/

	public ProductDetail getDetailbyId(String id) {
		String sql = "select * from Product_detail where id =?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				return new ProductDetail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean addDetail(ProductDetail pd) {
			String sql = "insert into Product_detail values (?,?,?,?,?,?,?,?,?)";
			try {
				con=new DBContext().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pd.getId());
				ps.setString(2, pd.getCpu());
				ps.setString(3, pd.getMainboard());
				ps.setString(4, pd.getRam());
				ps.setString(5, pd.getRom());
				ps.setString(6, pd.getCard());
				ps.setString(7, pd.getPower());
				ps.setString(8, pd.getFrames());
				ps.setString(9, pd.getRadiators());
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(new ProductDao().getDetailbyId("1"));

	}
}
