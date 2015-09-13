package ilentt.ilenlab.com.beans;

public class Account {

	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";
	
	private String username;
	private String password;
	private String gender;
	private boolean active;
	
	public Account() {
		// TODO Auto-generated constructor stub
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
