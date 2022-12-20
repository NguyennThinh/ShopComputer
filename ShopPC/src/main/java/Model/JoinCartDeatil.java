package Model;

public class JoinCartDeatil {
	private int idProduct;
	private String photo;
	private String name;
	private String price;
	private String sale;
	private int quantily;
	private String total;
	private String id_Detail;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public int getQuantily() {
		return quantily;
	}
	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getId_Detail() {
		return id_Detail;
	}
	public void setId_Detail(String id_Detail) {
		this.id_Detail = id_Detail;
	}
	public JoinCartDeatil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinCartDeatil(int idProduct, String photo, String name, String price, String sale, int quantily,
			String total, String id_Detail) {
		super();
		this.idProduct = idProduct;
		this.photo = photo;
		this.name = name;
		this.price = price;
		this.sale = sale;
		this.quantily = quantily;
		this.total = total;
		this.id_Detail = id_Detail;
	}
	@Override
	public String toString() {
		return "JoinCartDeatil [idProduct=" + idProduct + ", photo=" + photo + ", name=" + name + ", price=" + price
				+ ", sale=" + sale + ", quantily=" + quantily + ", total=" + total + ", id_Detail=" + id_Detail + "]";
	}
	
	
}
