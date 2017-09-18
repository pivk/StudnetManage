package Listenter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session´´½¨ SessionID: " + se.getSession().getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	       System.out.println("SessionÏú»Ù");

	}

}
