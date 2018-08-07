package com.springboot.redis4.entity;

public class User {
	private String email;
	private String name1;
	private String password;
	private String name2;
	private String password2;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public User() {
		
	}
	public User(String email, String name1, String password, String name2, String password2) {
		super();
		this.email = email;
		this.name1 = name1;
		this.password = password;
		this.name2 = name2;
		this.password2 = password2;
	}

}
