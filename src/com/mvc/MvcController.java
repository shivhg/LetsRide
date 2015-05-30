package com.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Car;
import com.model.Ride;
import com.web.handlers.Setup;

public class MvcController extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static HashMap<Car, Ride> fuber;
	private Map handlers;
	static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String mvcProps = getServletContext().getRealPath(
				"WEB-INF/mvc.properties");

		try {
			handlers = MvcUtility.buildHandlers(mvcProps);
			fuber = Setup.startService();
		} catch (MvcException e) {
			throw new ServletException(
					"Unable to Configure Controller Servlet", e);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();

		String key = path.substring(1, path.lastIndexOf("."));
		System.out.println(key);
		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(key);
		request.setAttribute("fuber", fuber);
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