/**
 * @author 21027690
 */
package students;

import java.util.ArrayList;

import cca_details.CCA;
import cca_details.Helper;

/**
 * @author 21027690
 *
 */
public class StudentMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studList = new ArrayList<Student>();
		
		studList.add(new Student(22345678, "Ben Lim", 9, "W64H", "Ms Denise"));
		studList.add(new Student(21083574, "Shirley Tan", 10, "E62M", "Mr William"));
		
		int option = 0;
		
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				viewAllStudents(studList);
			}
			else if (option == 2) {
				addStudent(studList);
			}
			else if (option == 3) {
				deleteStudent(studList);
			}
			else if (option == 4) {
				System.out.println("Bye!");
			}		
		}
	}
	
	public static void menu() {
		System.out.println("WELCOME TO STUDENT PROFILES!");
		Helper.lines(32, "-");
		System.out.println("1. View All Students");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Quit");
	}
	public static void viewAllStudents(ArrayList<Student> studList) {
		
	}
	
	public static void addStudent(ArrayList<Student> studList) {
		
	}
	
	public static void deleteStudent(ArrayList<Student> studList) {
	
	}
}
