package serivices;

import java.util.Date;
import java.util.List;

import DIYexception.NameRepeatE;
import POJO.ClassCourse;
import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IClassCouesrServers {
     
	List<ClassCourse> selectALL();
     

}
