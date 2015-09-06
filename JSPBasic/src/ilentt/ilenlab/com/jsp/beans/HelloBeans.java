package ilentt.ilenlab.com.jsp.beans;

public class HelloBeans {
	private String username;
	
	public HelloBeans() {
		// constructor
	}
	
	public String getName() {
		return this.username;
	}
	
	public void setName(String username) {
		this.username = username;
	}
	
	public String getHello() {
		if(username == null) {
			return "Hello every body!";
		}
		return "Hello " + username + "!!!";
	}
}
