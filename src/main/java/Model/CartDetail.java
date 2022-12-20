package Model;

public class CartDetail {
		private String id;
		private String idCart;
		private int idProduct;
		private String price;
		private int quantily;
		private String total;
		public CartDetail() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CartDetail(String id, String idCart, int idProduct, String price, int quantily, String total) {
			super();
			this.id = id;
			this.idCart = idCart;
			this.idProduct = idProduct;
			this.price = price;
			this.quantily = quantily;
			this.total = total;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIdCart() {
			return idCart;
		}
		public void setIdCart(String idCart) {
			this.idCart = idCart;
		}
		public int getIdProduct() {
			return idProduct;
		}
		public void setIdProduct(int idProduct) {
			this.idProduct = idProduct;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
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
		@Override
		public String toString() {
			return "CartDetail [id=" + id + ", idCart=" + idCart + ", idProduct=" + idProduct + ", price=" + price
					+ ", quantily=" + quantily + ", total=" + total + "]";
		}
		
		
}
