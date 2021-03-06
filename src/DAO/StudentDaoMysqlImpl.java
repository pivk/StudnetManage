package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POJO.Manager;
import POJO.Student;
import utils.DBUtil;
import vo.PageBean;
import vo.selectCondition;

public class StudentDaoMysqlImpl implements IStudentDao {
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	@Override
	// **********************���ѧ��**********************
	public int add(Student student) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into Student(name,age,gender,address,birthday) values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return result;
	}

	@Override
	// **********************ɾ��ָ��id��ѧ��**********************
	public int deleteById(int id) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from Student where id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return result;
	}

	@Override
	// **********************�޸�ָ��ID��ѧ����Ϣ����**********************
	public int update(Student student) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "update student set name = ?,age = ?, gender = ?,address = ?,birthday = ?  where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			preparedStatement.setInt(6, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return result;
	}

	@Override
	public List<Student> selectAll() {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Student";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					Student student = new Student(id, name, age, gender, address, birthday);
					studentsList.add(student);
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

	@Override
	// **********************�鿴ָ��id��ѧ����Ϣ**********************
	public List<Student> selectById(int id) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "select * from Student where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id1 = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					student = new Student(id1, name, age, gender, address, birthday);
					studentsList.add(student);
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

	@Override
	public List<Student> selectByName(String name) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "select * from Student where name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name1 = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					student = new Student(id, name1, age, gender, address, birthday);
					studentsList.add(student);
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

	public boolean checkName(String name) {
		boolean isBe = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "select id from Student where name = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isBe = true;
			} else {
				isBe = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return isBe;
	}

	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Student where birthday   between ? AND ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(startbirthday.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(endbirthday.getTime()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				studentsList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

	@Override
	public List<Manager> selectAll_Manager() {
		List<Manager> list = new ArrayList<Manager>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from manager ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String account = resultSet.getString("account");
				String password = resultSet.getString("password");
				Manager manager = new Manager(id, name, age, gender, address, account, password);
				list.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Student> selectByAddress(String address) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "select * from Student where address = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address1 = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					student = new Student(id, name, age, gender, address1, birthday);
					studentsList.add(student);
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

	public List<Student> searchByCondition(selectCondition searchCondition) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from student where 1=1 ";
			List<String> list = new ArrayList<String>();
			if (!searchCondition.getId().isEmpty()) {
				sql += " and id = ? ";
				list.add(searchCondition.getId());
			}
			if (!searchCondition.getName().isEmpty()) {
				sql += " and name like ? ";
				list.add("%" + searchCondition.getName() + "%");
			}
			if (!searchCondition.getAge().isEmpty()) {
				sql += " and age = ? ";
				list.add(searchCondition.getAge());
			}
			if (!searchCondition.getGender().isEmpty()) {
				sql += " and gender = ? ";
				list.add(searchCondition.getGender());
			}
			if (!searchCondition.getAddress().isEmpty()) {
				sql += " and address = ? ";
				list.add(searchCondition.getAddress());
			}
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				preparedStatement.setObject(i + 1, list.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				studentsList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentsList;
	}

	public List<Student> findPageBeanList(int index, int pageSize) {
		List<Student> list = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from student limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, index);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalCount() {
		int count = 0;
		try {
			
			connection = DBUtil.getConnection();
			String sql = "select count(*) from student";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		System.out.println(count);
		return count;
	}

	@Override
	public Manager selectBynamePassword(String name, String password) {
		Manager manager = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select  id,password,account from manager where account=? and password=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String account = resultSet.getString("account");
					String password1 = resultSet.getString("password");
					manager = new Manager(id, account, password1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return manager;
	}

}
