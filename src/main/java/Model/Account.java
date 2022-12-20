package Model;

public class Account {
	private String id;
	private String username;
	private String password;
	private boolean is_admin;
	private boolean is_delete;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String id, String username, String password, boolean is_admin, boolean is_delete) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", is_admin=" + is_admin
				+ ", is_delete=" + is_delete + "]";
	}
	

	
	
}
