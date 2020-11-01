package com.libraryservice.model;

public class RegistrationModel {
	private String name;
	private String password;
	public RegistrationModel(String name, String password, String bookPriv, String userPriv) {
		this.name = name;
		this.password = password;
		this.bookPriv = bookPriv;
		this.userPriv = userPriv;
	}
	private String bookPriv;
	private String userPriv;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBookPriv() {
		return bookPriv;
	}
	public void setBookPriv(String bookPriv) {
		this.bookPriv = bookPriv;
	}
	public String getUserPriv() {
		return userPriv;
	}
	public void setUserPriv(String userPriv) {
		this.userPriv = userPriv;
	}
}
