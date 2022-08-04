import java.util.ArrayList;
import java.util.Random;



public class C206_CaseStudy {	
	private static final int Option_VIEWCCASTUDENTS = 3;
	private static final int Option_ADD = 2;
	private static final int Option_VIEW = 1;
	private static final int Option_LOGOUT = 3;
	private static final int Option_QUIT = 2;
	private static final int Option_LOGIN = 1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] daysList = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Student> emptyList = new ArrayList<Student>();
		ArrayList<Instructor> insList = new ArrayList<Instructor>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",6,"Lim","Lim@gmail.com",90110241));
		
		adminList.add(new Admin("Shinji",1234,"roar"));
		
		insList.add(new Instructor(1234,"Mr Izzat","roar"));
		insList.add(new Instructor(4321,"Mr Jordon","roar"));
		
		studentList.add(new Student("6","Ben Lim", 9, "W64H", "Ms Denise",6));
		studentList.add(new Student("5","Izzat", 9, "W64H", "Mr Joseph",5));
		studentList.add(new Student("3","Lim Chong Hin", 9, "W64H", "Ms Denise",3));
		studentList.add(new Student("4","Jordon", 9, "W64H", "Mr Ivan",4));
		studentList.add(new Student("2","Shi Jie", 1, "W64H", "Mr Ivan", 0));
		
		CCA cca1 = new CCA("Little League Soccer","Soccer Club for Boys",30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat", emptyList);
		CCA cca2 = new CCA("LEGO Expert", "LEGO building masters", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", emptyList);
		ccaList.add(cca1);
		ccaList.add(cca2);
		
		int option = 0;
		while (option != 5) {
			mainMenu();
			option = Helper.readInt("Enter choice >");
			if (option == 1) {
				startStud(ccaList,studentList);
			}else if (option == 2) {
				startInstructor(daysList,insList,ccaList,studentList);
			}else if (option == 3) {
				startAdmin(daysList,adminList,ccaList,studentList,parentList);
			}else if (option == 4) {
				startParent(parentList,ccaList,studentList);
			}
			else if (option == 5) {
				System.out.println("Thank you for using CCA registration system!");
			}
		}
	}
	/**
	 * 
	 */
	
	//================================LOGIN CODES====================================================
	
	public static void startStud(ArrayList<CCA> ccaList,ArrayList<Student> studentList) {
		
		int optionLogin = -1;
		while (optionLogin != Option_QUIT) {
			loginMenu();
			optionLogin = Helper.readInt("Enter choice > ");
			if (optionLogin == Option_LOGIN) {
				String login = loginStud(studentList);
				if (login !="zero") {
					int option = -1;
					while (option != Option_LOGOUT) {
						menuStud();
						option = Helper.readInt("Enter choice > ");
						if (option == Option_VIEW) {
							viewAllCCA(ccaList);
						} else if (option == Option_ADD) {
							studCCAReg(ccaList,studentList,login);
						} else if (option == Option_LOGOUT) {
							System.out.println("Logging out...");
						}
					}
				}
			} else if (optionLogin == Option_QUIT) {
				System.out.println("Thank you for using CCA registration system!");
			}
		}
	}
	public static void startInstructor(String[] daysList,ArrayList<Instructor> insList, ArrayList<CCA> ccaList,ArrayList<Student> studentList) {

		int optionLogin = -1;
		while (optionLogin != Option_QUIT) {
			loginMenu();
			optionLogin = Helper.readInt("Enter choice > ");
			if (optionLogin == Option_LOGIN) {
				int login = loginInstructor(insList);
				if (login != 0) {
					int option = -1;
					while (option != 6) {
						menuIns();
						option = Helper.readInt("Enter choice > ");
						if (option == 1) {
							viewAllCCA(ccaList);
						} else if (option == 2) {
							CCA cca = inputCCAadd(daysList);
							addCCA(ccaList,cca);
							System.out.println("CCA has been added!");
						} else if (option == 3) {
							int index = inputCCAdel(ccaList);
							deleteCCA(ccaList,index);
						} else if (option == 4) {
							viewCCAStudents(studentList);
						} else if (option == 5){
							addStudentToCCA(ccaList,studentList);
						}
						else if (option == 6) {
							System.out.println("Logging out...");
						}
					}
				}
			} else if (optionLogin == Option_QUIT) {
				System.out.println("Thank you for using CCA registration system!");
			}
		}
	}
	public static void startAdmin(String[] daysList,ArrayList<Admin> adminList, ArrayList<CCA> ccaList,ArrayList<Student> studentList, ArrayList<Parent> parentList) {

		int optionLogin = -1;
		while (optionLogin != Option_QUIT) {
			loginMenu();
			optionLogin = Helper.readInt("Enter choice > ");
			if (optionLogin == Option_LOGIN) {
				int login = loginAdmin(adminList);
				if (login != 0) {
					int option = -1;
					while (option != 15) {
						menuAdmin();
						option = Helper.readInt("Enter choice > ");
						if (option == 1) {
							viewAllCCA(ccaList);
						} else if (option == 2) {
							CCA cca = inputCCAadd(daysList);
							addCCA(ccaList,cca);
							System.out.println("CCA has been added!");
						} else if (option == 3) {
							int index = inputCCAdel(ccaList);
							deleteCCA(ccaList,index);
						} else if (option == 4) {
							viewCCAStudents(studentList);
						} else if (option == 5){
							addStudentToCCA(ccaList,studentList);
						}else if (option == 6) {
							viewAllStudents(studentList);
						}else if (option == 7) {
							addStudent(studentList);
						}else if (option == 8) {
							deleteStudent(studentList);
						}else if (option == 9) {
							
						}else if (option == 10) {

						}else if (option == 11) {

						}else if (option == 12) {
							addParent(parentList);
						}else if (option == 13) {
							getParentDetails(parentList);
							viewAllParents(parentList);
						}else if (option == 14) {
							deleteParent(parentList);
						}
						else if (option == 15) {
							System.out.println("Logging out...");
						}
					}
				}
			} else if (optionLogin == Option_QUIT) {
				System.out.println("Thank you for using CCA registration system!");
			}
		}
	}
	public static void startParent(ArrayList<Parent> parentList, ArrayList<CCA> ccaList, ArrayList<Student>studentList) {

		int optionLogin = -1;
		while (optionLogin != 3) {
			loginMenuParent();
			optionLogin = Helper.readInt("Enter choice > ");
			if (optionLogin == Option_LOGIN) {
				String login = loginParent(parentList);
				if (login != "zero") {
					int option = -1;
					while (option != 3) {
						menuStud();
						option = Helper.readInt("Enter choice > ");
						if (option == Option_VIEW) {
							viewAllCCA(ccaList);
						} else if (option == Option_ADD) {
							studCCAReg(ccaList,studentList,login);
						} else if (option == Option_LOGOUT) {
							System.out.println("Logging out...");
						}
					}
				}
			} else if(optionLogin == 2) {
				addParent(parentList);
			}
			else if (optionLogin == 3) {
				System.out.println("Thank you for using CCA registration system!");
			}
		}
	}
	private static String loginStud(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		
		boolean foundStudent = false;
		boolean success = false;
		String login = "zero";
		while (!success) {
			String LoginStudentID = Helper.readString("Enter Student ID > ");
			String registrationID = Helper.readString("Enter CCA Registration ID > ");
			
			for (Student s : studentList) {
				if (LoginStudentID.equals(s.getID())) { 
					foundStudent = true;
					if(registrationID.equals(s.getRegistrationID())) {
						System.out.println("\nLogin Successful!\n");
						
						success = true;
						login = LoginStudentID;
						
					}else {
						System.out.println("Invalid CCA registration ID, please try again \n");
					}
				}
			}
			if (!foundStudent) {
				System.out.println("Invalid student ID, please try again\n");
			}
		}
		return login;
	}
	private static String loginParent(ArrayList<Parent> parentList) {
		// TODO Auto-generated method stub
		
		boolean foundStudent = false;
		boolean success = false;
		String login = "zero";
		while (!success) {
			String LoginStudentID = Helper.readString("Enter Student ID > ");
			int registrationID = Helper.readInt("Enter CCA Registration ID > ");
			
			for (Parent s : parentList) {
				if (LoginStudentID.equals(s.getID())) { 
					foundStudent = true;
					if(registrationID == (s.getRegistrationID())) {
						System.out.println("\nLogin Successful!\n");
						
						success = true;
						login = LoginStudentID;
						
					}else {
						System.out.println("Invalid CCA registration ID, please try again \n");
					}
				}
			}
			if (!foundStudent) {
				System.out.println("Invalid student ID, please try again\n");
			}
		}
		return login;
	}
	private static int loginInstructor(ArrayList<Instructor> insList) {
		// TODO Auto-generated method stub
		
		boolean foundInstructor = false;
		boolean success = false;
		int login = 0;
		while (!success) {
			int InstructorID = Helper.readInt("Enter Instructor ID > ");
			String password = Helper.readString("Enter Password > ");
			
			for (Instructor i : insList) {
				if (InstructorID == i.getID()) { 
					foundInstructor = true;
					if(password.equals(i.getPassword())) {
						System.out.println("\nLogin Successful!\n");
						success = true;
						login = InstructorID;
						
					}else {
						System.out.println("Invalid Instructor ID, please try again \n");
					}
				}
			}
			if (!foundInstructor) {
				System.out.println("Invalid student ID, please try again\n");
			}
		}
		return login;
	}
	private static int loginAdmin(ArrayList<Admin> adminList) {
		// TODO Auto-generated method stub
		
		boolean foundAdmin = false;
		boolean success = false;
		int login = 0;
		while (!success) {
			int AdminID = Helper.readInt("Enter Admin ID > ");
			String password = Helper.readString("Enter Password > ");
			
			for (Admin i : adminList) {
				if (AdminID == i.getID()) { 
					foundAdmin = true;
					if(password.equals(i.getPassword())) {
						System.out.println("\nLogin Successful!\n");
						success = true;
						login = AdminID;
						
					}else {
						System.out.println("Invalid Admin ID, please try again \n");
					}
				}
			}
			if (!foundAdmin) {
				System.out.println("Invalid student ID, please try again\n");
			}
		}
		return login;
	}
	/**
	 * 
	 */
	private static void loginMenu() {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println("Welcome to the CCA registration system");
		Helper.line(80, "-");
		System.out.println("1. Login");
		System.out.println("2. Quit");
		
	}
	private static void loginMenuParent() {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println("Welcome to the CCA registration system");
		Helper.line(80, "-");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		
	}
	
	/**
	 * @param LoginStudentList
	 */
	private static void menuStud() {
		// TODO Auto-generated method stub
		Helper.line(80, "=");
		System.out.println("Welcome to the CCA registration system");
		Helper.line(80, "=");
		System.out.println("1. View all CCAs");
		System.out.println("2. Choose CCA");
		System.out.println("3. Logout");
	}
	private static void menuIns() {
		// TODO Auto-generated method stub
		Helper.line(80, "=");
		System.out.println("Welcome to the CCA Management system");
		Helper.line(80, "=");
		System.out.println("1. View all CCAs");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. View Registered Students");
		System.out.println("5. Add students to CCA");
		System.out.println("6. Logout");
	}
	private static void menuAdmin() {
		// TODO Auto-generated method stub
		Helper.line(80, "=");
		System.out.println("Welcome to the CCA Management system");
		Helper.line(80, "=");
		System.out.println("1. View all CCAs");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. View Registered Students");
		System.out.println("5. Add students to CCA");
		System.out.println("6. View All Students");
		System.out.println("7. Add Students");
		System.out.println("8. Delete Students");
		System.out.println("9. View CCA Categories");
		System.out.println("10. Add CCA Categories");
		System.out.println("11. Delete CCA Categories");
		System.out.println("12. Add Parent Account");
		System.out.println("13. View Registered Parents");
		System.out.println("14. Delete Parent");
		System.out.println("15. Logout");
	}
	//=================================VIEW Methods==================================================
	private static void mainMenu() {
		// TODO Auto-generated method stub
		Helper.line(80, "=");
		System.out.println("Welcome to the CCA Registration system");
		Helper.line(80, "=");
		System.out.println("1. Login as student");
		System.out.println("2. Login as CCA Instructor");
		System.out.println("3. Login as Administrator");
		System.out.println("4. Login as Parent");
		System.out.println("5. Exit");
	}
	public static void viewCCAStudents(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		String output = String.format("%-30s %-30s", "STUDENTS","CCA TITLE");
			for (Student s : studentList) {
				if (s.isInCCA()) {
				output += String.format("\n%-30s %-30s", s.getID(), s.getCCA().getTitle());
				}
			}
		System.out.println(output);
	}
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

		for (int i = 0;i<ccaList.size();i++) {
			output += ccaList.get(i).display();
		}
		return output;
	}
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "\nLIST OF CCA\n";
		output += String.format("%-23s %-25s %-13s %-12s %-18s %-15s %-10s\n", 
				"TITLE","DESCRIPTION","VACANCY","DAY","TIME","VENUE","IN-CHARGE");
		output += retrieveAllCCA(ccaList);
		
		System.out.println(output);
	}
	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0 ; i<studentList.size();i++) {
			output += String.format("%-10s%-15s%-10d%-10s%-20s%s\n", studentList.get(i).getID(), studentList.get(i).getName(),
					studentList.get(i).getGrade(), studentList.get(i).getStudClass(),studentList.get(i).getTeacher(),studentList.get(i).getRegistrationID());
		}
		return output;
	}
	public static void viewAllStudents(ArrayList<Student> studentList) {
		String output = "";
		output += String.format("%-10s%-15s%-10s%-10s%-20s%s\n", "ID", "NAME", "GRADE", "CLASS", "TEACHER","REG. ID");
		
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10s%-15s%-10d%-10s%-20s%s\n", studentList.get(i).getID(), studentList.get(i).getName(),
					studentList.get(i).getGrade(), studentList.get(i).getStudClass(),studentList.get(i).getTeacher(),studentList.get(i).getRegistrationID());
		}
		System.out.println(output);
	}
	private static void viewAllParents(ArrayList<Parent> parentList) {
		// TODO Auto-generated method stub
		String output = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "StudentID", "Student Name",
				"grade", "classroom", "teacher","registeration ID", "parent", "parent Email", "parent number");
		output += getParentDetails(parentList);

		System.out.println(output);
	}

	private static String getParentDetails(ArrayList<Parent> parentList) {
		String output = "";
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", parentList.get(i).getID(),
					parentList.get(i).getName(), parentList.get(i).getGrade(), parentList.get(i).getStudClass(),
					parentList.get(i).getTeacher(), parentList.get(i).getParentName(),
					parentList.get(i).getParentEmail(), parentList.get(i).getParentNumber());
		}
		return output;
	}
	//=============================================ADD Methods======================================
	public static void studCCAReg(ArrayList<CCA> ccaList,ArrayList<Student> studentList, String id) {
		// TODO Auto-generated method stub
		String output = String.format("%-30s", "CCA List:");
		int i = 0;
		for (CCA c : ccaList) {
			i++;
			output+= String.format("\n%d) %-30s", i,c.getTitle());
		}
		System.out.println(output);
		int CCAOption = Helper.readInt("Select CCA > ");
		if (CCAOption <= ccaList.size()) {
			for(Student s : studentList) {
				if (s.getID().equals(id) && (ccaList.get(CCAOption-1).getStudentList().size()>0 && ccaList.get(CCAOption-1).getStudentList().size()<ccaList.get(CCAOption-1).getClassSize())) {
					CCA chosenCCA = ccaList.get(CCAOption-1);
					chosenCCA.getStudentList().add(s);
					s.setInCCA(true);
					s.setCCA(chosenCCA);
					System.out.println("CCA chosen successfully");
				}
			}

		}else {
			System.out.println("Invalid option");
		}

	}
	/**
	 * @param ccaList
	 */
	
	
	 public static CCA inputCCAadd(String[] daysList) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String title = Helper.readString("Enter CCA Title > ");
		String desc = Helper.readString("Enter CCA Description > ");
		int classSize = Helper.readInt("Enter CCA Class Size > ");

		
		while(classSize>50 || classSize<0) {
			System.out.println("Class Size should be 50 or less");
			classSize = Helper.readInt("Enter CCA Class Size > ");		
		}
		
		String day = Helper.readString("Enter Day of CCA > ");
		
//		for (int i = 0;i<daysList.length;i++) {
//			while(day.equals(daysList[i])){
//				System.out.println("Enter a valid day");
//				day = Helper.readString("Enter Day of CCA > ");
//			}
//
//		}
		String time = Helper.readString("Enter Duration of CCA (__pm -__pm)> ");
		String venue = Helper.readString("Enter venue of CCA > ");
		String name = Helper.readString("Enter Name of Instructor In-Charge > ");

		CCA cca= new CCA(title,desc,classSize,day,time,venue,name,studentList);
		return cca;
		
	}
	
	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {		
		ccaList.add(cca);
	}
	public static void addStudentToCCA(ArrayList<CCA> ccaList,ArrayList<Student> studentList) {
        // TODO Auto-generated method stub
        String output = String.format("%-30s", "CCA List:");
        int i = 0;
        for (CCA c : ccaList) {
            i++;
            output+= String.format("\n%d) %-30s", i,c.getTitle());
        }
        System.out.println(output);
        int CCAOption = Helper.readInt("Select CCA > ");
        String output2 = String.format("%-30s", "Student List:");
        output2 = String.format("\n%3s %-30s %-30s","No.","STUDENT ID","CCA REGISTRATION ID");
        int o = 0;
        for (Student s : studentList) {
            o++;
            output2+= String.format("\n%d) %-30s %-30s", o,s.getID(),s.getRegistrationID());
        }
        System.out.println(output2);
        int studentOption = Helper.readInt("Select Student > ");
        for (int z = 0;z < ccaList.size();z++) {
            if (z == CCAOption-1 && (ccaList.get(z).getStudentList().size()>0 &&ccaList.get(z).getStudentList().size()<ccaList.get(z).getClassSize())) {
                for(int x = 0; x < studentList.size();x++) {
                    if(x == (studentOption - 1)) {
                        ccaList.get(z).getStudentList().add(studentList.get(x));
                        studentList.get(x).setCCA(ccaList.get(z));
                        studentList.get(x).setInCCA(true);
                        System.out.println("Student added successfully");
                    }
                }
            }
        }

    }
	public static void addStudent(ArrayList<Student> studentList, Student student) {
		boolean studAdd = false;
		String id = Helper.readString("Enter new student ID > ");
		String name = Helper.readString("Enter new student name > ");
		int grade = Helper.readInt("Enter new student grade > ");
		String studClass = Helper.readString("Enter new student class > ");
		String teacher = Helper.readString("Enter new student classroom teacher > ");
		int regID = Helper.readInt("Enter Registration ID");
		
		for (int i = 0; i < studentList.size();) {
			studentList.add(new Student(id, name, grade, studClass, teacher,regID));
			studAdd = true;
			break;
		}
		
		if(studAdd) {
			System.out.println("New student added!");
		} else {
			System.out.println("Failed to add new student!");
		}
	}
	public static void addParent(ArrayList<Parent> parentList) {
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

			Parent mem = new Parent(studID, studName, grade, classroom, teacherName,ccaRegister, parentName,
					parentEmail, parentNumber);
			parentList.add(mem);
			System.out.println("Account have been successsfuly created");
			System.out.println("Your CCA registeration ID is " + ccaRegister);
		}

	}
	//=======================================DELETE METHODS=====================================================
	public static int inputCCAdel(ArrayList<CCA> ccaList) {
		boolean found = false;
		int index = 0;
		String title = Helper.readString("Enter CCA Title > ");

		for (int i = 0; i < ccaList.size();i++) {
			if (title.equalsIgnoreCase(ccaList.get(i).getTitle()) == true){
				index = i;
			}
		}
		System.out.println(index);
		return index;	
		
	}
	public static void deleteCCA(ArrayList<CCA> ccaList, int index) {
		ccaList.remove(index);
		System.out.println("DELETING CCA....");
		System.out.println("CCA has been deleted");
	}
	public static void deleteStudent(ArrayList<Student> studentList) {
		String id = Helper.readString("Enter student ID to be deleted > ");
		boolean delete = false;
		
		for (int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getID().equals(id)) {
				studentList.remove(i);
				delete = true;
			}
		}
		if (delete) {
			System.out.println("Student deleted!");
		} else {
			System.out.println("Failed to delete student!");
		}
	}
	public static void deleteParent(ArrayList<Parent> parentList) {
		// TODO Auto-generated method stub
		int DelRegisterationID = Helper.readInt("enter the registeration ID");
		String studentID = Helper.readString("Enter student ID");
		for (int i = 0; i < parentList.size(); i++) {
			if (DelRegisterationID == parentList.get(i).getRegistrationID()
					&& parentList.get(i).getID().contains(studentID)) {
				parentList.remove(i);
				System.out.println("Parent account has bee deleted");
			} else {
				System.out.println("Parent account does not exist, or already has been deleted");

			}
		}

	}
	public static int checkRegisterationID(ArrayList<Parent> parentList, Random rand, int ccaRegister) {
		for (int i = 0; i < parentList.size(); i++) {
			if (ccaRegister == parentList.get(i).getRegistrationID()) {
				ccaRegister = rand.nextInt(99999);
			}
		}
		return ccaRegister;
	}
	
}