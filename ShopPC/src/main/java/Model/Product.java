package Model;

import java.text.DecimalFormat;

public class Product {
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	private int id;
	private String productName;
	private String sale;
	private String price;
	private String idSuplier;
	private String description;
	private String photo;
	private int quantily;
	private int sold;
	private String idCategory;
	private String idProductDetail;
	private String total;
	private boolean delete;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSale() {
		double salee = Double.parseDouble(sale);
		return formatter.format(salee);
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getPrice() {
		double pricee = Double.parseDouble(price);
		return formatter.format(pricee);
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIdSuplier() {
		return idSuplier;
	}
	public void setIdSuplier(String idSuplier) {
		this.idSuplier = idSuplier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantily() {
		return quantily;
	}
	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getIdProductDetail() {
		return idProductDetail;
	}
	public void setIdProductDetail(String idProductDetail) {
		this.idProductDetail = idProductDetail;
	}
	public String getTotal() {
		double salee = Double.parseDouble(sale);
		double pricee = Double.parseDouble(price);
		
		return formatter.format(pricee- pricee*salee/100);
	}
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product( int id, String productName, String sale, String price, String idSuplier,
			String description, String photo, int quantily, int sold, String idCategory, String idProductDetail,
			 boolean delete) {
		super();
	
		this.id = id;
		this.productName = productName;
		this.sale = sale;
		this.price = price;
		this.idSuplier = idSuplier;
		this.description = description;
		this.photo = photo;
		this.quantily = quantily;
		this.sold = sold;
		this.idCategory = idCategory;
		this.idProductDetail = idProductDetail;
	
		this.delete = delete;
	}
	public Product(String productName, String sale, String price, String idSuplier,
			String description, String photo, int quantily, int sold, String idCategory, String idProductDetail,
			 boolean delete) {
		super();
	
	
		this.productName = productName;
		this.sale = sale;
		this.price = price;
		this.idSuplier = idSuplier;
		this.description = description;
		this.photo = photo;
		this.quantily = quantily;
		this.sold = sold;
		this.idCategory = idCategory;
		this.idProductDetail = idProductDetail;
	
		this.delete = delete;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", sale=" + getSale() + ", price=" + getPrice()
				+ ", idSuplier=" + idSuplier + ", description=" + description + ", photo=" + photo + ", quantily="
				+ quantily + ", sold=" + sold + ", idCategory=" + idCategory + ", idProductDetail=" + idProductDetail
				+ ", total=" + getTotal()+ ",delete=" + delete + "]";
	}
	
	
	
}
