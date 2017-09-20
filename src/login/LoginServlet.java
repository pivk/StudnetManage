package login;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import POJO.Manager;
import serivices.IStudentServers;
import serviceImpl.StudentServerImpl;

public class LoginServlet extends HttpServlet {

	// 登录验证
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		IStudentServers service = new StudentServerImpl();
		Manager ma = service.selectBynamePassword(userName, password);

		String checkCode = req.getParameter("checkCode");
		String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");

		if (checkCode == null || checkCode.equals("")) {
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			return;
		}

		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			session.setAttribute("err2", "验证码错误");
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
			return;
		}

		
		if (ma != null) {
			session.setAttribute("userName", userName);
	/*		List<Manager> onLineAdminList = (List<Manager>) getServletContext().getAttribute("onLineAdminList");
			onLineAdminList.add(ma);*/
			resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
		} else {

			session.setAttribute("err1", "账户密码错误");
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
		}

	}

}
