/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

package parent;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

public class Registeration {

	public Registeration(int studentID, String studentName, String grade, String classroom, String teacherName,
			String parentName, String parentEmail, int parentNumber, int ccaRegister) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.classroom = classroom;
		this.teacherName = teacherName;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentNumber = parentNumber;
		this.ccaRegister = ccaRegister;
	}

	private int studentID;
	private String studentName;
	private String grade;
	private String classroom;
	private String teacherName;
	private String parentName;
	private String parentEmail;
	private int parentNumber;
	private int ccaRegister;

	// the various get and set methods

	// student ID might be will be important.
	public int getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getGrade() {
		return grade;
	}

	public String getClassroom() {
		return classroom;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getParentName() {
		return parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public int getParentNumber() {
		return parentNumber;
	}

	public int getCcaRegister() {
		return ccaRegister;
	}

}
