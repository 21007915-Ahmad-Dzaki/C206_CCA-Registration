/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ahmad Dzaki Bin Osman, 21007915, 2 Aug 2022 9:36:44 pm
 */

/**
 * @author ahmad
 *
 */
public class Instructor {

	private int ID;
	private String name;
	private String password;
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public Instructor(int iD, String name, String password) {
		super();
		ID = iD;
		this.name = name;
		this.password = password;
	}
}
