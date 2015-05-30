package com.model;

public class Car {
	private int regNum;
	private String color;
	private String model;

	public Car() {
		super();
	}

	public Car(int regNum) {
		super();
		this.regNum = regNum;
	}

	public Car(int regNum, String color, String brand) {
		super();
		this.regNum = regNum;
		this.color = color;
		this.model = brand;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.regNum == ((Car) obj).getRegNum();
	}
	
	public int hashCode() {
        return regNum;
    }

}
