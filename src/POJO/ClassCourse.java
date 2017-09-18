package POJO;

public class ClassCourse {

	private int id;
	private int class_id;
	private int course_id;
	private String coName;
	private String clName;

	
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getClName() {
		return clName;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public ClassCourse(int id, String coName, String clName) {
		super();
		this.id = id;
		this.coName = coName;
		this.clName = clName;
	}
	public ClassCourse() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
}
