package Model;

import java.sql.Timestamp;
import java.util.Date;

public class BillDetail {
	private String id;

	private int idProductl;
	private int quantily;
	private String price;
	private Timestamp orderDate;
	private String status;
	private String address;
	private String payment;
	private String idUser;
	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillDetail(String id, int idProductl, int quantily, String price, Timestamp orderDate,
			String status, String address, String payment, String idUser) {
		super();
		this.id = id;

		this.idProductl = idProductl;
		this.quantily = quantily;
		this.price = price;
		this.orderDate = orderDate;
		this.status = status;
		this.address = address;
		this.payment = payment;
		this.idUser = idUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getIdProductl() {
		return idProductl;
	}
	public void setIdProductl(int idProductl) {
		this.idProductl = idProductl;
	}
	public int getQuantily() {
		return quantily;
	}
	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", idProductl=" + idProductl + ", quantily=" + quantily
				+ ", price=" + price + ", orderDate=" + orderDate + ", status=" + status + ", address=" + address
				+ ", payment=" + payment + ", idUser=" + idUser + "]";
	}
	
	
	
}
