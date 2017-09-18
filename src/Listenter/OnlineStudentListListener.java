package Listenter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import POJO.Student;

public class OnlineStudentListListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 创建在线学生列表集合
		// 每当用户登录时候，就往集合中添加。
		List<Student> onlineStudentList = new ArrayList<Student>();
		// 放到ServletContext域对象中
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onlineStudentList", onlineStudentList);

	}

}
