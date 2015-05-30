package com.model;

public class Customer {
	private String name;
	private int phoneNum;

	public Customer() {
		super();
	}

	public Customer(String name, int phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

}
