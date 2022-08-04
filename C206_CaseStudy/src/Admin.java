/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Ahmad Dzaki Bin Osman, 21007915, 3 Aug 2022 9:50:55 pm
 */

/**
 * @author ahmad
 *
 */
public class Admin {
	
	private String name;
	private int ID ;
	private String password;
	
	public Admin(String name, int iD, String password) {
		super();
		this.name = name;
		ID = iD;
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	
}
