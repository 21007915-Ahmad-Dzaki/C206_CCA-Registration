/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ahmad Dzaki Bin Osman, 21007915, 4 Aug 2022 10:40:37 am
 */

/**
 * @author ahmad
 *
 */
public class Parent extends Student{
	
	private String parentName;
	private String parentEmail;
	private int parentNumber;
	
	public Parent(String id, String name, int grade, String studClass, String teacher, int registrationID,
			String parentName, String parentEmail, int parentNumber) {
		super(id, name, grade, studClass, teacher, registrationID);
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentNumber = parentNumber;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @return the parentEmail
	 */
	public String getParentEmail() {
		return parentEmail;
	}

	/**
	 * @return the parentNumber
	 */
	public int getParentNumber() {
		return parentNumber;
	}

	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @param parentEmail the parentEmail to set
	 */
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	/**
	 * @param parentNumber the parentNumber to set
	 */
	public void setParentNumber(int parentNumber) {
		this.parentNumber = parentNumber;
	}
	
}
