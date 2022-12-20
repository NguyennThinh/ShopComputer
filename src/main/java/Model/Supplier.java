package Model;

public class Supplier {
	private String id;
	private String sName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(String id, String sName) {
		super();
		this.id = id;
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", sName=" + sName + "]";
	}
	
}
