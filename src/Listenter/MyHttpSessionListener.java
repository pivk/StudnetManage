package Listenter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import POJO.Manager;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session创建 SessionID: " + se.getSession().getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession httpSession = se.getSession();
		ServletContext servletContext = httpSession.getServletContext();
		List<Manager> onLinrManageList = (List<Manager>) servletContext;
		Manager manage = (Manager) httpSession.getAttribute("manager");
		if (manage != null) {
			onLinrManageList.remove(manage);

		}

	}

}
