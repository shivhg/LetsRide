package com.model;

public class Customer {
	private String Name;
	private int age;

	public Customer() {
		super();
	}

	public Customer(String name, int age) {
		super();
		Name = name;
		this.age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
