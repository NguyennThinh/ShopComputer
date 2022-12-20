package Model;

import java.text.DecimalFormat;

public class StatisticalCustomer {
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	private String idUser;
	private String fullName;
	private String email;
	private String phone;
	private String tong;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getTong() {
		double total = Double.parseDouble(tong);
		return formatter.format(total);
	}
	public void setTong(String tong) {
		
		this.tong = tong;
	}
	public StatisticalCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticalCustomer(String idUser, String fullName, String email, String phone, String tong) {
		super();
		this.idUser = idUser;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	
		this.tong = tong;
	}
	@Override
	public String toString() {
		return "Statistical [idUser=" + idUser + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", tong=" + getTong() + "]";
	}
	
	
	
}
