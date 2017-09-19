package serviceImpl;

import java.util.Date;
import java.util.List;

import DAO.IStudentDao;
import DAO.StudentDaoMysqlImpl;
import DIYexception.NameRepeatE;
import POJO.Manager;
import POJO.Student;
import serivices.IStudentServers;
import vo.PageBean;
import vo.selectCondition;

public class StudentServerImpl implements IStudentServers {
	
	private IStudentDao studentDao = new StudentDaoMysqlImpl();

	public List<Student> selectAll() {
		return studentDao.selectAll();
	}

	public int deleteById(int id) {
		return studentDao.deleteById(id);
	}

	public boolean add(Student student) throws NameRepeatE {
		if (studentDao.checkName(student.getName())) {
			throw new NameRepeatE("已经存在");
		} else {
			return studentDao.add(student) > 0 ? true : false;
		}
	}

	public List<Student> selectById(int id) {
		return studentDao.selectById(id);
	}

	public List<Student> selectByName(String name) {
		return studentDao.selectByName(name);
	}

	public int update(Student student) {
		return studentDao.update(student);
	}

	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday) {
		return studentDao.selectByBirthday(startbirthday, endbirthday);
	}

	public List<Manager> selectAll_Manager() {
		return studentDao.selectAll_Manager();
	}

	public List<Student> selectByAddress(String address) {
		return studentDao.selectByAddress(address);
	}

	public List<Student> searchByCondition(selectCondition searchCondition) {
		return studentDao.searchByCondition(searchCondition);
	}

	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = studentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void deleteAll(String[] ids) {
		for (String string : ids) {
			studentDao.deleteById(Integer.parseInt(string));
		}
	}

	@Override
	public Manager selectBynamePassword(String name, String password) {
		return studentDao.selectBynamePassword(name, password);
	}




	

}
