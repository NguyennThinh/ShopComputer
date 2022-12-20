package Model;

import java.text.DecimalFormat;

public class StatisticalUser {
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	private String id, fullname,address, email, phone, orderdate, price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getPrice() {
		double tong = Double.parseDouble(price);
		return formatter.format(tong);
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public StatisticalUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticalUser(String id, String fullname, String address, String email, String phone, String orderdate,
			String price) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.orderdate = orderdate;
		this.price = price;
	}

	@Override
	public String toString() {
		return "StatisticalUser [id=" + id + ", fullname=" + fullname + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + ", orderdate=" + orderdate + ", price=" + getPrice() + "]";
	}
	
	
}
