package com.web.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	@Test
	public void testDist() {
		Search serc = new Search();
		int a = serc.dist(3, 4);
		assertEquals(5, a);
	}
	
	@Test
	public void testDistZero() {
		Search serc = new Search();
		int a = serc.dist(0, 0);
		assertEquals(0, a);
	}

	@Test
	public void testDistfloat() {
		Search serc = new Search();
		int a = serc.dist(8, 12);
		assertEquals(14, a);
	}

}
