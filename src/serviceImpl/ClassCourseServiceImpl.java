package serviceImpl;

import java.util.List;

import DAO.ClassCourseDaoMysqlImpl;
import DAO.IClassCouesrDao;
import POJO.ClassCourse;
import serivices.IClassCouesrServers;

public class ClassCourseServiceImpl implements IClassCouesrServers{
	private IClassCouesrDao classDao=new ClassCourseDaoMysqlImpl();
	@Override
	public List<ClassCourse> selectALL() {
		return classDao.selectAll();
	}

}
