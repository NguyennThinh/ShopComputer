package Model;

import java.text.DecimalFormat;

public class StatisticalProduct {
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	private String productName;
	private String idProduct;
	private String quantily;
	private String total;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getQuantily() {
		return quantily;
	}
	public void setQuantily(String quantily) {
		this.quantily = quantily;
	}
	public String getTotal() {
		double tong = Double.parseDouble(total);
		return formatter.format(tong);
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public StatisticalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StatisticalProduct(String productName, String idProduct, String quantily, String total) {
		super();
		this.productName = productName;
		this.idProduct = idProduct;
		this.quantily = quantily;
		this.total = total;
	}
	@Override
	public String toString() {
		return "StatisticalProduct [formatter=" + formatter + ", productName=" + productName + ", idProduct="
				+ idProduct + ", quantily=" + quantily + ", total=" + getTotal() + "]";
	}

	
	
}
