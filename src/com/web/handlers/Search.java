package com.web.handlers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Car;
import com.model.Customer;
import com.model.Location;
import com.model.Ride;
import com.mvc.HttpRequestHandler;

public class Search implements HttpRequestHandler {
	HttpSession session = null;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String pick = request.getParameter("pick");
		if (pick == "on") {
			displayCars(request, response);
		} else {
			bookCab(request, response);
		}
	}

	private void bookCab(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String location = request.getParameter("areafrom");
		System.out.println(location);
		int dist = 0;
		HashMap<Car, Ride> fuber = (HashMap<Car, Ride>) session
				.getAttribute("fuber");
		Set<Car> cars = fuber.keySet();
		Set<Ride> ride = new HashSet<Ride>();

		for (Car cr : cars) {
			Ride value = fuber.get(cr);
			ride.add(value);
		}
		List<Location> loc = (List<Location>) session.getAttribute("location");
		
		for (Location locat : loc) {

			if (locat.getName().equals(location)) {
				dist = locat.getDistFromCent();
			}
		}

		Map<Integer, String> distance = new TreeMap<Integer, String>();
		for (Location locat : loc) {
			if(locat.getName().equals(location)) {
				distance.put(0, locat.getName());
				continue;
			}
			int dis = dist(dist, locat.getDistFromCent());
			distance.put(dis, locat.getName());
		}
		int min = 50;
		boolean done = false;
		print(fuber);
		for (int i : distance.keySet()) {
			String nearLoc = distance.get(i);
			for (Car cr : fuber.keySet()) {
				Ride rid = fuber.get(cr);
				if(rid.getCust()!=null) 
					continue;
				if(rid.getCurLoc().getName() == nearLoc) {
					String name = request.getParameter("name");
					int num = Integer.valueOf(request.getParameter("number"));
					String dropLoc = request.getParameter("areato");
					Customer cust = new Customer(name, num);
					System.out.println(cust.getName()+" print "+name);
					int ddist = 0;
					for (Location locat : loc) {
						if (locat.getName().equals(dropLoc)) {
							ddist = locat.getDistFromCent();
						}
					}
					Location dropLocat = new Location(dropLoc, ddist);

					Ride bok = new Ride(cust, rid.getCurLoc(), dropLocat, new Date(), new Date(), i+1.1);
					fuber.put(cr, bok);
					RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
					rd.forward(request, response);
					done = true;
					break;
				}
			}
			if(done == true) {
				break;
			}
		}
		print(fuber);
	}

	private void print(HashMap<Car, Ride> fuber) {
		System.out.println();
		System.out.println();
		for(Car cr : fuber.keySet()) {
			if(fuber.get(cr).getCust()==null)
				System.out.println(cr.getRegNum()+" "+fuber.get(cr).getCust()+" "+fuber.get(cr).getCurLoc().getName());

			else
				System.out.println(cr.getRegNum()+" "+fuber.get(cr).getCust().getName()+" "+fuber.get(cr).getCurLoc().getName());
		}
	}

	// always assumed to be 90degree and pythagoras theorem is used
	public int dist(int a, int b) {
		int Hypotenuse1 = (int) ((Math.pow(a, 2)) + (Math.pow(b, 2)));
		Hypotenuse1 = (int) Math.sqrt(Hypotenuse1);
		return Hypotenuse1;
	}

	private void displayCars(HttpServletRequest request,
			HttpServletResponse response) {

	}
}