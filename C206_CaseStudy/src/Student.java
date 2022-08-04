/**
 * @author 21027690
 */

public class Student {

	private String id;
	private String name;
	private int grade;
	private String studClass;
	private String teacher;
	private int registrationID;
	private boolean inCCA;
	private CCA CCA;
	
	public Student (String id, String name, int grade, String studClass, String teacher,int registrationID) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.studClass = studClass;
		this.teacher = teacher;
		this.registrationID = registrationID;
		this.inCCA = false;
		this.CCA = null;
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
	/**
	 * @return the registrationID
	 */
	public int getRegistrationID() {
		return registrationID;
	}
	/**
	 * @param registrationID the registrationID to set
	 */
	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}
	/**
	 * @return the inCCA
	 */
	public boolean isInCCA() {
		return inCCA;
	}
	/**
	 * @param inCCA the inCCA to set
	 */
	public void setInCCA(boolean inCCA) {
		this.inCCA = inCCA;
	}
	/**
	 * @return the cCA
	 */
	public CCA getCCA() {
		return CCA;
	}
	/**
	 * @param cCA the cCA to set
	 */
	public void setCCA(CCA cca) {
		CCA = cca;
	}
}

