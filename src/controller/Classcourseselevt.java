package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO.ClassCourse;
import serivices.IClassCouesrServers;
import serviceImpl.ClassCourseServiceImpl;

public class Classcourseselevt extends BaseServlet{
	
	IClassCouesrServers ClassCouserServers = new ClassCourseServiceImpl();
	
	private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<ClassCourse> list = ClassCouserServers.selectALL();
		req.setAttribute("list", list);  
		req.getRequestDispatcher("/jsp/ClassCourse_list.jsp").forward(req, resp);
	}

     
}
