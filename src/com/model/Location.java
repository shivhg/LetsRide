package com.model;

public class Location {
	private String Name;
	private int distFromCent;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDistFromCent() {
		return distFromCent;
	}

	public void setDistFromCent(int distFromCent) {
		this.distFromCent = distFromCent;
	}

	public Location() {
		super();
	}

	public Location(String name, int distFromCent) {
		super();
		Name = name;
		this.distFromCent = distFromCent;
	}

}
