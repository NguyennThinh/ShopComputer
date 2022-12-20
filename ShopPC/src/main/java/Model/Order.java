package Model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private String idBill;

	private int idProduct;
	private String photo;
	private String nameProduct;
	private int quantily;
	private String total;
	private String dateOrder;
	private String status;
	private String address;
	private String payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int idProduct, String photo, String nameProduct, int quantily, String total, String dateOrder,
			String status, String address, String payment) {
		super();
		this.idProduct = idProduct;
		this.photo = photo;
		this.nameProduct = nameProduct;
		this.quantily = quantily;
		this.total = total;
		this.dateOrder = dateOrder;
		this.status = status;
		this.address = address;
		this.payment = payment;
	}


	public Order(String idBill, int idProduct, String photo, String nameProduct, int quantily, String total,
			String dateOrder, String status, String address, String payment) {
		super();
		this.idBill = idBill;
		this.idProduct = idProduct;
		this.photo = photo;
		this.nameProduct = nameProduct;
		this.quantily = quantily;
		this.total = total;
		this.dateOrder = dateOrder;
		this.status = status;
		this.address = address;
		this.payment = payment;
	}
	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantily() {
		return quantily;
	}

	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}

	public String getTotal() {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		double tatol = Double.parseDouble(total);
		return formatter.format(tatol);
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDateOrder() {
		
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
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

	@Override
	public String toString() {
		return "Order [idBill=" + idBill + ", idProduct=" + idProduct + ", photo=" + photo + ", nameProduct="
				+ nameProduct + ", quantily=" + quantily + ", total=" + total + ", dateOrder=" + dateOrder + ", status="
				+ status + ", address=" + address + ", payment=" + payment + "]";
	}

	
	
}
