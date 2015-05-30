package com.web.handlers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.model.Car;
import com.model.Location;
import com.model.Ride;

public class Setup {
	static HashMap<Car, Ride> fuber = new HashMap<Car, Ride>();;

	public static HashMap<Car, Ride> startService() {
		fuber.put(createCar(10, "pink", "Indica"), new Ride(null, new Location(
				"btm", 0), null,new Date(), null, 0));
		fuber.put(createCar(11, "white", "Indica"), new Ride(null, new Location(
				"btm", 0), null,new Date(), null, 0));
		fuber.put(createCar(12, "blue", "Indica"), new Ride(null, new Location(
				"mejestic", 15), null,new Date(), null, 0));
		fuber.put(createCar(13, "blue", "Indica"), new Ride(null, new Location(
				"mejestic", 15), null,new Date(), null, 0));
		fuber.put(createCar(14, "blue", "Indica"), new Ride(null, new Location(
				"koramangala", 9), null,new Date(), null, 0));
		fuber.put(createCar(15, "pink", "Indica"), new Ride(null, new Location(
				"koramangala", 9), null,new Date(), null, 0));
		fuber.put(createCar(16, "blue", "Indica"), new Ride(null, new Location(
				"indiranagar", 20), null,new Date(), null, 0));
		fuber.put(createCar(17, "pink", "Indica"), new Ride(null, new Location(
				"indiranagar", 20), null,new Date(), null, 0));
		fuber.put(createCar(18, "blue", "Indica"), new Ride(null, new Location(
				"gandhibazar", 12), null,new Date(), null, 0));
		fuber.put(createCar(19, "white", "Indica"), new Ride(null, new Location(
				"gandhibazar", 12), null,new Date(), null, 0));
		fuber.put(createCar(20, "blue", "Indica"), new Ride(null, new Location(
				"southend", 8), null,new Date(), null, 0));
		fuber.put(createCar(21, "blue", "Indica"), new Ride(null, new Location(
				"southend", 8), null,new Date(), null, 0));
		fuber.put(createCar(22, "white", "Indica"), new Ride(null, new Location(
				"lalbagh", 10), null,new Date(), null, 0));
		fuber.put(createCar(23, "blue", "Indica"), new Ride(null, new Location(
				"lalbagh", 10), null,new Date(), null, 0));
		fuber.put(createCar(24, "white", "Indica"), new Ride(null, new Location(
				"kengeri", 18), null,new Date(), null, 0));
		return fuber;
	}

	public static Car createCar(int regNum, String color, String model) {
		return new Car(regNum, color, model);
	}

	public static List<Location> locaDist() {
		List<Location> loc = new ArrayList<Location>();
		loc.add(new Location("btm", 0));
		loc.add(new Location("mejestic", 15));
		loc.add(new Location("koramangala", 9));
		loc.add(new Location("indiranagar", 20));
		loc.add(new Location("gandhibazar", 12));
		loc.add(new Location("southend", 8));
		loc.add(new Location("lalbagh", 10));
		loc.add(new Location("kengeri", 18));
		return loc;
	}
}
