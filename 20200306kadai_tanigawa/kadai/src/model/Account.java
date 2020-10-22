package model;

public class Account {

	private String userId;
	private String pass;
	private String name;
	private int age;
	private String address;


	public Account(String userId, String pass, String name, int age, String address) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.address = address;
	}


	public String getUserId() {
		return userId;
	}


	public String getPass() {
		return pass;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getAddress() {
		return address;
	}






}
