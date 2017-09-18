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
		// ��������ѧ���б���
		// ÿ���û���¼ʱ�򣬾�����������ӡ�
		List<Student> onlineStudentList = new ArrayList<Student>();
		// �ŵ�ServletContext�������
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("onlineStudentList", onlineStudentList);

	}

}
