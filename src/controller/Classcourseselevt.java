package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassCourseDaoMysqlImpl;
import POJO.ClassCourse;
import POJO.Student;
import serivices.IClassCouesrServers;
import serivices.IStudentServers;
import serviceImpl.ClassCourseServiceImpl;
import serviceImpl.StudentServerImpl;

public class Classcourseselevt extends BaseServlet{
	IClassCouesrServers ClassCouserServers = new ClassCourseServiceImpl();

	
	// 查看全部学生信息
	private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<ClassCourse> list = ClassCouserServers.selectALL();
		req.setAttribute("list", list);  
		req.getRequestDispatcher("/jsp/ClassCourse_list.jsp").forward(req, resp);
	}

     
}
