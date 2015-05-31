package com.web.handlers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.model.Car;
import com.model.Location;
import com.model.Ride;
import com.mvc.HttpRequestHandler;

public class Pay implements HttpRequestHandler {
	public static final Logger LOG = Logger.getLogger(Pay.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String admin = request.getParameter("regnum");
		int num = 0;
		if (admin == null) {
			num = (int) session.getAttribute("regNum");
		} else {
			num = Integer.parseInt(admin);
		}
		LOG.info("huuuuuu " + num);

		HashMap<Car, Ride> fuber = (HashMap<Car, Ride>) session
				.getAttribute("fuber");

		for (Car cr : fuber.keySet()) {
			if (cr.getRegNum() == num) {
				LOG.info("Hurray!!");
				Location checkCur = fuber.get(cr).getCurLoc();
				if (fuber.get(cr).getDropLoc() != null) {
					checkCur = fuber.get(cr).getDropLoc();
				}
				Ride release = new Ride(null, checkCur, null, fuber.get(cr)
						.getPicDate(), new Date(), 0);
				fuber.put(cr, release);
				LOG.info(fuber.get(cr).getCust());
				response.sendRedirect("bye.html");
			} else
				System.out.println("not there");
		}
	}

}
