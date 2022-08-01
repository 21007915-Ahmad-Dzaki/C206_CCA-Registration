/**
 * @author 21027690
 */
package students;

/**
 * @author 21027690
 *
 */
public class Student {

	private String id;
	private String name;
	private int grade;
	private String studClass;
	private String teacher;
	
	public Student (String id, String name, int grade, String studClass, String teacher) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.studClass = studClass;
		this.teacher = teacher;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getStudClass() {
		return studClass;
	}
	
	public void setStudClass(String studClass) {
		this.studClass = studClass;
	}
	
	public String getTeacher() {
		return teacher;
	}
	
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
