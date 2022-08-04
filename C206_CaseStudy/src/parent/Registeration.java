/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

package c206_graded;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

public class Registeration extends Student {








	public Registeration(String id, String name, int grade, String studClass, String teacher, String parentName,
			String parentEmail, int parentNumber) {
		super(id, name, grade, studClass, teacher);
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentNumber = parentNumber;

	}




	private String parentName;
	private String parentEmail;
	private int parentNumber;


	// the various get and set methods

	// student ID might be will be important.

	public String getParentName() {
		return parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public int getParentNumber() {
		return parentNumber;
	}


}
