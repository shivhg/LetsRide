package com.web.handlers;

import java.util.Date;
import java.util.HashMap;

import com.model.Car;
import com.model.Location;
import com.model.Ride;
import com.model.Time;

public class Setup {
	static HashMap<Car, Ride> fuber = new HashMap<Car, Ride>();;

	public static HashMap<Car, Ride> startService() {
		fuber.put(createCar(10, "pink", "Indica"), new Ride(null, new Location(
				"btm", 0), null, new Time(new Date()), null, 0));
		fuber.put(createCar(11, "white", "Indica"), new Ride(null, new Location(
				"btm", 0), null, new Time(new Date()), null, 0));
		fuber.put(createCar(12, "blue", "Indica"), new Ride(null, new Location(
				"mejestic", 15), null, new Time(new Date()), null, 0));
		fuber.put(createCar(13, "blue", "Indica"), new Ride(null, new Location(
				"mejestic", 15), null, new Time(new Date()), null, 0));
		fuber.put(createCar(14, "blue", "Indica"), new Ride(null, new Location(
				"koramangala", 9), null, new Time(new Date()), null, 0));
		fuber.put(createCar(15, "pink", "Indica"), new Ride(null, new Location(
				"koramangala", 9), null, new Time(new Date()), null, 0));
		fuber.put(createCar(16, "blue", "Indica"), new Ride(null, new Location(
				"indiranagar", 20), null, new Time(new Date()), null, 0));
		fuber.put(createCar(17, "pink", "Indica"), new Ride(null, new Location(
				"indiranagar", 20), null, new Time(new Date()), null, 0));
		fuber.put(createCar(18, "blue", "Indica"), new Ride(null, new Location(
				"gandhibazar", 12), null, new Time(new Date()), null, 0));
		fuber.put(createCar(19, "white", "Indica"), new Ride(null, new Location(
				"gandhibazar", 12), null, new Time(new Date()), null, 0));
		fuber.put(createCar(20, "blue", "Indica"), new Ride(null, new Location(
				"southend", 8), null, new Time(new Date()), null, 0));
		fuber.put(createCar(21, "blue", "Indica"), new Ride(null, new Location(
				"southend", 8), null, new Time(new Date()), null, 0));
		fuber.put(createCar(22, "white", "Indica"), new Ride(null, new Location(
				"lalbagh", 10), null, new Time(new Date()), null, 0));
		fuber.put(createCar(23, "blue", "Indica"), new Ride(null, new Location(
				"lalbagh", 10), null, new Time(new Date()), null, 0));
		fuber.put(createCar(24, "white", "Indica"), new Ride(null, new Location(
				"kengeri", 18), null, new Time(new Date()), null, 0));
		return fuber;
	}

	public static Car createCar(int regNum, String color, String model) {
		return new Car(regNum, color, model);
	}
}
