package Model;

public class Category {
	private String id;
	private String cName;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String cName) {
		super();
		this.id = id;
		this.cName = cName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", cName=" + cName + "]";
	}
	
}
