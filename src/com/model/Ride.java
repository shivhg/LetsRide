package com.model;

import java.util.Date;

public class Ride {
	Customer cust;
	Location curLoc;
	Location dropLoc;
	Date picDate;
	Date dropDate;
	double cost;

	public Ride() {
		super();
	}

	public Ride(Customer cust, Location curLoc, Location dropLoc,
			Date picDate, Date dropDate, double cost) {
		super();
		this.cust = cust;
		this.curLoc = curLoc;
		this.dropLoc = dropLoc;
		this.picDate = picDate;
		this.dropDate = dropDate;
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

	public Date getPicDate() {
		return picDate;
	}

	public void setPicDate(Date picDate) {
		this.picDate = picDate;
	}

	public Date getDropDate() {
		return dropDate;
	}

	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
