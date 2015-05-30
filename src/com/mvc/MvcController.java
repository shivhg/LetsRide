package com.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bg.ReleaseResource;
import com.model.Car;
import com.model.Location;
import com.model.Ride;
import com.web.handlers.Setup;

public class MvcController extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	HashMap<Car, Ride> fuber;
	List<Location> locat = null;
	private Map handlers;
	static final long serialVersionUID = 1L;
	private ScheduledExecutorService scheduler;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String mvcProps = getServletContext().getRealPath(
				"WEB-INF/mvc.properties");

		try {
			handlers = MvcUtility.buildHandlers(mvcProps);
			locat = Setup.locaDist();
			fuber = Setup.startService();
			scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.scheduleAtFixedRate(new ReleaseResource(), 1, 1,
					TimeUnit.HOURS);
		} catch (MvcException e) {
			throw new ServletException(
					"Unable to Configure Controller Servlet", e);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String key = path.substring(1, path.lastIndexOf("."));
		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(key);
		HttpSession session = request.getSession();
		session.setAttribute("fuber", fuber);
		session.setAttribute("location", locat);
		if (handler != null) {
			handler.handle(request, response);
		} else {
			throw new ServletException("No Matching Handler");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}