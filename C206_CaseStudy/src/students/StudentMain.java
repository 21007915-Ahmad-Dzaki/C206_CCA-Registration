/**
 * @author 21027690
 */
package students;

import java.util.ArrayList;

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
		
		studList.add(new Student("22345678", "Ben Lim", 9, "W64H", "Ms Denise"));
		studList.add(new Student("21083574", "Shirley Tan", 10, "E62M", "Mr William"));
		
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
		System.out.println("WELCOME TO STUDENT PROFILES");
		Helper.lines(40, "-");
		System.out.println("1. View All Students");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Quit");
	}
	public static void viewAllStudents(ArrayList<Student> studList) {
		String output = "";
		output += String.format("%-10s%-15s%-10s%-10s%-20s\n", "ID", "NAME", "GRADE", "CLASS", "TEACHER");
		
		for (int i = 0; i < studList.size(); i++) {
			output += String.format("%-10s%-15s%-10d%-10s%-20s\n", studList.get(i).getID(), studList.get(i).getName(),
					studList.get(i).getGrade(), studList.get(i).getStudClass(),studList.get(i).getTeacher());
		}
		System.out.println(output);
	}
	
	public static void addStudent(ArrayList<Student> studList) {
		boolean studAdd = false;
		String id = Helper.readString("Enter new student ID > ");
		String name = Helper.readString("Enter new student name > ");
		int grade = Helper.readInt("Enter new student grade > ");
		String studClass = Helper.readString("Enter new student class > ");
		String teacher = Helper.readString("Enter new student classroom teacher > ");
		
		for (int i = 0; i < studList.size();) {
			studList.add(new Student(id, name, grade, studClass, teacher));
			studAdd = true;
			break;
		}
		
		if(studAdd) {
			System.out.println("New student added!");
		} else {
			System.out.println("Failed to add new student!");
		}
	}
	
	public static void deleteStudent(ArrayList<Student> studList) {
		String id = Helper.readString("Enter student ID to be deleted > ");
		boolean delete = false;
		
		for (int i = 0; i < studList.size(); i++) {
			if(studList.get(i).getID().equals(id)) {
				studList.remove(i);
				delete = true;
			}
		}
		if (delete) {
			System.out.println("Student deleted!");
		} else {
			System.out.println("Failed to delete student!");
		}
	}
}
