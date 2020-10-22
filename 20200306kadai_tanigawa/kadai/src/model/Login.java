package model;

public class Login {

	private String userId;
	private String pass;


	public String getUserId() {
		return userId;
	}


	public String getPass() {
		return pass;
	}


	public Login(String userId, String pass) {
		super();
		this.userId = userId;
		this.pass = pass;
	}



}
