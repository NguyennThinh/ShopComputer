package Model;

public class User {
	private String id;
	private String fullName;
	private String address;
	private String email;
	private String phone;
	private String id_Account;
	private boolean is_delete;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getId_Account() {
		return id_Account;
	}
	public void setId_Account(String id_Account) {
		this.id_Account = id_Account;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String fullName, String address, String email, String phone, String id_Account,
			boolean is_delete) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.id_Account = id_Account;
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", id_Account=" + id_Account + ", is_delete=" + is_delete + "]";
	}
		
}
