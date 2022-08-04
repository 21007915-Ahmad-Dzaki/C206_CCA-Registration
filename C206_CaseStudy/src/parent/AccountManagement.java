/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

package c206_graded;

import java.util.ArrayList;
import java.util.Random;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 18047206 Lim Shi Jie, 18 April 2022, 10.17 am
 */

public class AccountManagement {

	private static final int Option_DEL = 3;
	private static final int Option_ADD = 2;
	private static final int Option_VIEW = 1;
	private static final int Option_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	private static void start() {
		// TODO Auto-generated method stub

		ArrayList<Registeration> parentList = new ArrayList<Registeration>();
		parentList.add(new Registeration("22345678", "Ben Lim", 1, "W64H", "Ms Denise", "Mr Ben", "test@gmail.com",
				12345432));
		int option = -1;
		while (option != Option_QUIT) {
			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == Option_VIEW) {
				viewAll(parentList);
			} else if (option == Option_ADD) {
				addParent(parentList);
			} else if (option == Option_DEL) {
//				deleteParent(parentList);
			} else if (option == Option_QUIT) {

				System.out.println("Thank you for using Account managment application!");
			}
		}

	}

	private static void deleteParent(ArrayList<Parent> parentList) {
		// TODO Auto-generated method stub
		int DelRegisterationID = Helper.readInt("enter the registeration ID");
		String studentID = Helper.readString("Enter student ID");
		for (int i = 0; i < parentList.size(); i++) {
			if (DelRegisterationID == parentList.get(i).getCcaRegister()
					&& parentList.get(i).getID().contains(studentID)) {
				parentList.remove(i);
				System.out.println("Parent account has bee deleted");
			} else {
				System.out.println("Parent account does not exist, or already has been deleted");

			}
		}

	}

	private static void addParent(ArrayList<Registeration> parentList) {
		// TODO Auto-generated method stub
		String studID = Helper.readString("Enter student ID > ");
		String studName = Helper.readString("Enter student Name > ");
		int grade = Helper.readInt("Enter student grade > ");
		String classroom = Helper.readString("Enter classroom > ");
		String teacherName = Helper.readString("Enter teacher name > ");
		String parentName = Helper.readString("Enter parent name > ");
		String parentEmail = Helper.readString("Enter parent email > ");
		String emailPattern = "@";
		boolean emailMatch = false;
		while (emailMatch != true) {
			if (parentEmail.contains(emailPattern)) {
				emailMatch = true;

			} else {
				emailMatch = false;
				System.out.println("Please enter a email in the form of @");
				parentEmail = Helper.readString("Enter parent email > ");

			}
		}
		if (emailMatch) {
			int parentNumber = Helper.readInt("enter parent number > ");

//			 to generate random number
			Random rand = new Random();
			int ccaRegister = rand.nextInt(99999);
			// ensure that parents get the unique CCAregisterID.
			ccaRegister = checkRegisterationID(parentList, rand, ccaRegister);

			Registeration mem = new Registeration(studID, studName, grade, classroom, teacherName, parentName,
					parentEmail, parentNumber);
			parentList.add(mem);
			System.out.println("Account have been successsfuly created");
			System.out.println("Your CCA registeration ID is " + ccaRegister);
		}

	}

	private static int checkRegisterationID(ArrayList<Registeration> parentList, Random rand, int ccaRegister) {
		for (int i = 0; i < parentList.size(); i++) {
			if (ccaRegister == parentList.get(i).getCcaRegister()) {
				ccaRegister = rand.nextInt(99999);
			}
		}
		return ccaRegister;
	}

	private static void viewAll(ArrayList<Registeration> parentList) {
		// TODO Auto-generated method stub
		String output = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "StudentID", "Student Name",
				"grade", "classroom", "teacher","registeration ID", "parent", "parent Email", "parent number");
		output += getParentDetails(parentList);

		System.out.println(output);
	}

	private static String getParentDetails(ArrayList<Registeration> parentList) {
		String output = "";
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", parentList.get(i).getID(),
					parentList.get(i).getName(), parentList.get(i).getGrade(), parentList.get(i).getStudClass(),
					parentList.get(i).getTeacher(), parentList.get(i).getParentName(),
					parentList.get(i).getParentEmail(), parentList.get(i).getParentNumber());
		}
		return output;
	}

	private static void menu() {
		// TODO Auto-generated method stub
		Helper.line(80, "=");
		System.out.println("Welcome to Manage Account Page");
		Helper.line(80, "=");
		System.out.println("1. View All parents");
		System.out.println("2. Add parent account");
		System.out.println("3. Delete parent");
		System.out.println("4. Quit");

	}

}
