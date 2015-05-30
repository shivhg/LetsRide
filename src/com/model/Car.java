package com.model;

public class Car {
	private int regNum;
	private String color;
	private String brand;

	public Car() {
		super();
	}

	public Car(int regNum, String color, String brand) {
		super();
		this.regNum = regNum;
		this.color = color;
		this.brand = brand;
	}

	public int getRegNum() {
		return regNum;
	}

	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
