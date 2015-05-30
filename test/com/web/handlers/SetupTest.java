package com.web.handlers;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.model.Car;
import com.model.Ride;

public class SetupTest {

	@Test
	public void testStartService() {
		HashMap<Car, Ride> fuber = Setup.startService();
		assertNotNull(fuber);
	}
	
	@Test
	public void testStartServiceeq() {
		HashMap<Car, Ride> fuber = Setup.startService();
		assertEquals(new Car(11),fuber.get(new Car(11)));
	}

}
