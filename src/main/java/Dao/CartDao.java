package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.BillDetail;
import Model.Cart;
import Model.CartDetail;
import Model.JoinCartDeatil;
import Model.Order;

public class CartDao {
	Connection con = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	// Tạo một cart mới
	public void createCart(Cart c) {
		String sql = "insert into Cart values(?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getId());
			ps.setString(2, c.getIdUser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Cart findCart(String id) {
		String sql = "Select * from Cart where id_user = ?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Cart(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Thêm sản phẩm vào giở hàng
	public boolean addtoCart(CartDetail cd) {
		String sql = "insert into Cart_detail values (?,?,?,?,?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cd.getId());
			ps.setString(2, cd.getIdCart());
			ps.setInt(3, cd.getIdProduct());
			ps.setString(4, cd.getPrice());
			ps.setInt(5, cd.getQuantily());
			ps.setString(6, cd.getTotal());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// Lấy danh chi tiết giỏ hàng
	public List<JoinCartDeatil> getCartDetail(String idCart) {
		List<JoinCartDeatil> arrDetail = new ArrayList<JoinCartDeatil>();
		String sql = "SELECT Product.id, Product.photo,Product.product_name, Cart_detail.price, Product.sale, Cart_detail.quantily, Cart_detail.total,Cart_detail.id\r\n"
				+ "			FROM Product, Cart_detail\r\n"
				+ "			WHERE Product.id=Cart_detail.id_product and Cart_detail.id_cart =?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idCart);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				arrDetail.add(new JoinCartDeatil(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrDetail;
	}

//Lấy danh sách checkout
	public JoinCartDeatil getListCheckout(String idDetail) {
		List<JoinCartDeatil> arrDetail = new ArrayList<JoinCartDeatil>();
		String sql = "SELECT Product.id, Product.photo,Product.product_name, Cart_detail.price, Product.sale, Cart_detail.quantily, Cart_detail.total,Cart_detail.id\r\n"
				+ "				FROM Product, Cart_detail\r\n"
				+ "					WHERE Product.id=Cart_detail.id_product and Cart_detail.id =?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idDetail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				return new JoinCartDeatil(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Checkout
	public void Checkout(List<BillDetail> bi) {
		String sql = "insert into Bill_detail values(?,?,?,?,?,?,?,?,?)";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			for (BillDetail b : bi) {
				ps.setString(1, b.getId());
				ps.setInt(2, b.getIdProductl());
				ps.setInt(3, b.getQuantily());
				ps.setString(4, b.getPrice());
				ps.setTimestamp(5, b.getOrderDate());
				ps.setString(6, b.getStatus());
				ps.setString(7, b.getAddress());
				ps.setString(8, b.getPayment());
				ps.setString(9, b.getIdUser());
				ps.executeUpdate();
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	// Lấy dach sách đơn hàng
	public List<Order> getOrder(String id, String date) {
		List<Order> arrOrder = new ArrayList<Order>();
		String sql = "SELECT Product.id, Product.photo,Product.product_name,  Bill_detail.quantily, Bill_detail.price,Bill_detail.order_date,Bill_detail.status, Bill_detail.address, Bill_detail.payment\r\n"
				+ "				FROM Product, Bill_detail\r\n"
				+ "				WHERE Product.id=Bill_detail.id_product and Bill_detail.id_user =?  and Bill_detail.order_date=? ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				arrOrder.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrOrder;
	}

	// Lấy ngày order
	public List<String> getDateOrder(String id) {
		List<String> arrDate = new ArrayList<String>();
		String sql = "select DISTINCT order_date from Bill_detail where id_user =? ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				arrDate.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrDate;
	}

	// Xóa sản phẩm trong cart
	public boolean delete(String[] id) {
		String sql = "DELETE FROM Cart_detail where id=?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			for (String i : id) {
				ps.setString(1, i);
				ps.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public void deleteone(String id) {
		String sql = "DELETE FROM Cart_detail where id=?";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**Admin
	 **/
	//Lấy danh sách đơn hàng
	public List<Order> getAllOrder() {
		List<Order> arrOrder = new ArrayList<Order>();
		String sql = "SELECT Bill_detail.id, Product.id, Product.photo,Product.product_name,  Bill_detail.quantily, Bill_detail.price,Bill_detail.order_date,Bill_detail.status, Bill_detail.address, Bill_detail.payment\r\n"
				+ "		FROM Product, Bill_detail\r\n"
				+ "		WHERE Product.id=Bill_detail.id_product ";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrOrder.add(new Order(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrOrder;
	}
	public void updateBillStatus(String id, String status) {
		String sql = "UPDATE Bill_detail SET status = ? WHERE id = ?";

		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
	
				ps.setString(1, status);
				ps.setString(2, id);
				
		
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void updateBillPayment(String id, String payment) {
		String sql = "UPDATE Bill_detail SET payment = ? WHERE id = ?";

		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
	
				ps.setString(1, payment);
				ps.setString(2, id);
				
		
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		String[] id = { "961ee15a-c040-46c5-8cc9-84a361ae6ac5", "87f381a7-2fa4-4bd8-824e-1ab74eb1a927" };
		System.out.println(new CartDao().delete(id));
		List<String> arrStatus = new ArrayList<String>();
	
	}
}
