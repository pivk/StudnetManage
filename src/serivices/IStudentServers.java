package serivices;

import java.util.Date;
import java.util.List;

import DIYexception.NameRepeatE;
import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IStudentServers {

	List<Student> selectAll();

	int deleteById(int id);

	boolean add(Student student) throws NameRepeatE;

	List<Student> selectById(int id);

	List<Student> selectByName(String name);

	int update(Student student);

	List<Student> selectByBirthday(Date startbirthday, Date endbirthday);

	List<Manager> selectAll_Manager();


	List<Student> selectByAddress(String address);

	List<Student> searchByCondition(selectCondition searchCondition);

	PageBean getPageBean(int pageIndex, int pageSize);

	void deleteAll(String[] ids);

	Manager selectBynamePassword(String name, String password);

}
