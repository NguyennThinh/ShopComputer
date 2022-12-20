package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ConnectCSDL.DBContext;
import Model.StatisticalCustomer;
import Model.StatisticalProduct;
import Model.StatisticalUser;

public class StatisticalDao {
	Connection con = null;
	
	//Thống kê các người mua  nhiều nhất trong tháng
	
	public List<StatisticalCustomer> getCustomerinMonth(String month) {
		
		List<StatisticalCustomer> arrStatistical = new ArrayList<StatisticalCustomer>();
		String sql = "SELECT   b.id_user, u.full_name,u.email, u.phone, sum(b.price) AS Tong\r\n"
				+ "			FROM Bill_detail b INNER JOIN Users u\r\n"
				+ "				ON b.id_user = u.id \r\n"
				+ "				where MONTH(order_date) = ?\r\n"
				+ "				GROUP BY b.id_user, u.full_name,u.email, u.phone\r\n"
				+ "				ORDER BY Tong DESC";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, month);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrStatistical.add(new StatisticalCustomer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrStatistical;
	}
	//Thống kê các sản phẩm đưuọc mua nhiều nhất trong tháng
	
	public List<StatisticalProduct> getProductinMonth(String month) {
		
		List<StatisticalProduct> arrStatistical = new ArrayList<StatisticalProduct>();
		String sql = "SELECT u.product_name, u.id , sum(b.quantily) AS Soluong, sum(b.price) AS Tong\r\n"
				+ "			FROM Bill_detail b INNER JOIN Product u\r\n"
				+ "				ON b.id_product = u.id \r\n"
				+ "				where MONTH(order_date) = ?\r\n"
				+ "				GROUP BY u.product_name, u.id\r\n"
				+ "				ORDER BY Tong DESC";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, month);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrStatistical.add(new StatisticalProduct(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4)));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrStatistical;
	}
	//Lấy danh sách khách hàng đã mua sản phẩm
	public List<StatisticalUser> getUsersbuy() {
		
		List<StatisticalUser> arrStatistical = new ArrayList<StatisticalUser>();
		String sql = "SELECT o.id_user, c.full_name,c.address,c.email,c.phone, o.order_date,o.price\r\n"
				+ "FROM Bill_detail As o, Users AS c\r\n"
				+ "WHERE o.id_user=c.id\r\n"
				+ "ORDER BY o.order_date DESC";
		try {
			con = new DBContext().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrStatistical.add(new StatisticalUser(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrStatistical;
	}

}
