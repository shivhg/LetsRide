package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	
	@Test
	public void equalsFalse() {
		Car cr = new Car(11, "red", "audi");
		Car cr2 = new Car(44);
		assertFalse(cr2.equals(cr));
	}

	@Test
	public void equals() {
		Car cr = new Car(11, "red", "audi");
		Car cr2 = new Car(11);
		assertTrue(cr2.equals(cr));
	}

}
