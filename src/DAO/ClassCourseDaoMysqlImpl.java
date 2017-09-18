package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POJO.ClassCourse;
import POJO.Student;
import utils.DBUtil;

public class ClassCourseDaoMysqlImpl implements IClassCouesrDao{
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	@Override
	public List<ClassCourse> selectAll() {
		List<ClassCourse> studentsList = new ArrayList<ClassCourse>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select class.name clname,course.name coname from class_course inner join class on class.id=class_course.class_id inner join course on course.id=class_course.course_id   ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String clname = resultSet.getString("clname");
					String coname = resultSet.getString("coname");

					ClassCourse cla=new ClassCourse(id,clname,coname);
					studentsList.add(cla);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

}
