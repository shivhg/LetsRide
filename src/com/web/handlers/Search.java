package com.web.handlers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Car;
import com.model.Ride;
import com.mvc.HttpRequestHandler;

public class Search implements HttpRequestHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pick = request.getParameter("pick");
		if(pick == "on") {
			displayCars(request,response);
		}
		else {
			bookCab(request,response);
		}
	}

	private void bookCab(HttpServletRequest request,
			HttpServletResponse response) {
		
	}

	private void displayCars(HttpServletRequest request,
			HttpServletResponse response) {
		
	}
}