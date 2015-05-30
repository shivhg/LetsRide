package com.model;

public class Ride {
	Customer cust;
	Location curLoc;
	Location dropLoc;
	Time picTime;
	Time dropTime;
	float cost;

	public Ride() {
		super();
	}

	public Ride(Customer cust, Location curLoc, Location dropLoc,
			Time picTime, Time dropTime, float cost) {
		super();
		this.cust = cust;
		this.curLoc = curLoc;
		this.dropLoc = dropLoc;
		this.picTime = picTime;
		this.dropTime = dropTime;
		this.cost = cost;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Location getCurLoc() {
		return curLoc;
	}

	public void setCurLoc(Location curLoc) {
		this.curLoc = curLoc;
	}

	public Location getDropLoc() {
		return dropLoc;
	}

	public void setDropLoc(Location dropLoc) {
		this.dropLoc = dropLoc;
	}

	public Time getPicTime() {
		return picTime;
	}

	public void setPicTime(Time picTime) {
		this.picTime = picTime;
	}

	public Time getDropTime() {
		return dropTime;
	}

	public void setDropTime(Time dropTime) {
		this.dropTime = dropTime;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
}
