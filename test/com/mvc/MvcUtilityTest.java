package com.mvc;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.web.handlers.Search;

public class MvcUtilityTest {
	
	@Test
	public void testCheckInterfaceNull() throws ClassNotFoundException {
		Class handClazz = null;
		boolean test = MvcUtility.checkInterface(handClazz, "com.mvc.HttpRequestHandler");
		assertFalse(test);
	}

	@Test
	public void testCheckInterfaceFalse() throws ClassNotFoundException {
		Class handClazz = Class.forName("com.web.handlers.Search");
		boolean test = MvcUtility.checkInterface(handClazz, "SomeInterface");
		assertFalse(test);
	}
	
	@Test
	public void testCheckInterfaceTrue() throws ClassNotFoundException {
		Class handClazz = Class.forName("com.web.handlers.Search");
		boolean test = MvcUtility.checkInterface(handClazz, "com.mvc.HttpRequestHandler");
		assertTrue(test);
	}
	
	@Test(expected = MvcException.class)
	public void testBuildHandlersNull() throws ClassNotFoundException, MvcException {
		Class handClazz = null;
		MvcUtility.buildHandlers("someFile");
	}
	
	@Test
	public void testBuildHandlersfound() throws ClassNotFoundException, MvcException {
		Map listOfProperties = MvcUtility.buildHandlers("E:\\nilenso\\Fuber\\WebContent\\WEB-INF\\mvc.properties");
		assertNotNull(listOfProperties);
	}

}
