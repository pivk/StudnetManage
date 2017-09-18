package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import utils.DBUtil;

public class initServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
			DBUtil.init(servletContext);
	}
}
