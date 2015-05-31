package com.web.handlers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.model.Car;
import com.model.Customer;
import com.model.Location;
import com.model.Ride;
import com.mvc.HttpRequestHandler;

public class Search implements HttpRequestHandler {
	HttpSession session = null;
	public static final Logger LOG = Logger.getLogger(Search.class);

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

		LOG.info("------------------------------------------");
		String location = request.getParameter("areafrom");
		LOG.info(location);
		int dist = 0;
		@SuppressWarnings("unchecked")
		HashMap<Car, Ride> fuber = (HashMap<Car, Ride>) session
				.getAttribute("fuber");
		Set<Car> cars = fuber.keySet();
		Set<Ride> ride = new HashSet<Ride>();

		for (Car cr : cars) {
			Ride value = fuber.get(cr);
			ride.add(value);
		}
		List<Location> loc = (List<Location>) session.getAttribute("location");
		if (location.equals("none")
				|| request.getParameter("areato").equals("none")) {
			response.sendRedirect("index.html");
			return;
		}
		for (Location locat : loc) {
			if (locat.getName().equals(location)) {
				dist = locat.getDistFromCent();
			}
		}

		Map<Integer, String> distance = new TreeMap<Integer, String>();
		for (Location locat : loc) {
			if (locat.getName().equals(location)) {
				distance.put(0, locat.getName());
				continue;
			}
			int dis = dist(dist, locat.getDistFromCent());
			distance.put(dis, locat.getName());
		}

		String color = request.getParameter("carcolor");

		int min = 50;
		boolean done = false;
		for (int i : distance.keySet()) {
			String nearLoc = distance.get(i);
			for (Car cr : fuber.keySet()) {
				Ride rid = fuber.get(cr);
				if (rid.getCust() != null)
					continue;
				if (!color.equals("none") && !color.equals(cr.getColor()))
					continue;
				if (rid.getCurLoc().getName().equals(nearLoc)) {
					String name = request.getParameter("name");
					int num = Integer.valueOf(request.getParameter("number"));
					String dropLoc = request.getParameter("areato");
					Customer cust = new Customer(name, num);
					LOG.info(cust.getName() + " print " + name);
					int ddist = 0;
					for (Location locat : loc) {
						if (locat.getName().equals(dropLoc)) {
							ddist = locat.getDistFromCent();
						}
					}
					Location dropLocat = new Location(dropLoc, ddist);
					int cost = 0;
					for (int cst : distance.keySet()) {
						if (distance.get(cst).equals(dropLoc)) {
							cost = cst;
							break;
						}
					}
					Ride bok = new Ride(cust, rid.getCurLoc(), dropLocat,
							new Date(), new Date(), cost);
					fuber.put(cr, bok);
					session.setAttribute("regNum", cr.getRegNum());
					cost = 2 * cost + new Random().nextInt(10);
					if (cr.getColor() == "pink") {
						cost += 5;
					}
					request.setAttribute("cost", cost);
					RequestDispatcher rd = request
							.getRequestDispatcher("travelling.jsp");
					rd.forward(request, response);
					done = true;
					break;
				}
			}
			if (done == true) {
				break;
			}
		}
		if (!done) {
			if (!color.equals("none"))
				response.sendRedirect("sorry.html");
			else
				response.sendRedirect("busy.html");

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