package Model;

public class Cart {
	private String id;
	private String idUser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String id, String idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", idUser=" + idUser + "]";
	}
	
}
