import java.util.ArrayList;
import java.util.Random;

//hello

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
		ArrayList<Instructor> insList = new ArrayList<Instructor>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		ArrayList<Category> catList = new ArrayList<Category>();
		ArrayList<CCA> emptyCCAlist = new ArrayList<CCA>();
		ArrayList<Student> soccer = new ArrayList<Student>();
		ArrayList<Student> Lego = new ArrayList<Student>();
		ArrayList<Student> Swimming = new ArrayList<Student>();
		
		CCA cca1 = new CCA("Little League Soccer","Soccer Club for Boys",30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat", soccer, false);
		CCA cca2 = new CCA("LEGO Expert", "LEGO building masters", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", Lego, false);
		CCA cca3 = new CCA("Swimming", "Swim faster", 30, "Tuesday", "2:00PM - 3:00PM", "Yishun Complex", "Mr Jordon",
				Swimming,true);
		
		emptyCCAlist.add(cca1);
		
		catList.add(new Category("Sport",emptyCCAlist));
		
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",6,"Lim","Lim@gmail.com",90110241));
		//id = 1234 pw:roar
		adminList.add(new Admin("Shinji",1234,"roar"));
		
		insList.add(new Instructor(1234,"Mr Izzat","roar"));
		insList.add(new Instructor(4321,"Mr Jordon","roar"));
		
		//student login use 6,6
		studentList.add(new Student("6","Ben Lim", 4, "W64H", "Ms Denise",6));
		studentList.add(new Student("5","Izzat", 5, "W64H", "Mr Joseph",5));
		studentList.add(new Student("3","Lim Chong Hin", 6, "W64H", "Ms Denise",3));
		studentList.add(new Student("4","Jordon", 6, "W64H", "Mr Ivan",4));
		studentList.add(new Student("2","Shi Jie", 1, "W64H", "Mr Ivan", 0));
		
		
		ccaList.add(cca1);
		ccaList.add(cca2);
		ccaList.add(cca3);
		
		int option = 0;
		while (option != 5) {
			mainMenu();
			option = Helper.readInt("Enter choice >");
			if (option == 1) {
				startStud(ccaList,studentList);
			}else if (option == 2) {
				startInstructor(daysList,insList,ccaList,studentList);
			}else if (option == 3) {
				startAdmin(daysList,adminList,ccaList,studentList,parentList,catList,emptyCCAlist);
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
	//by Wen Jiang
	public static void startStud(ArrayList<CCA> ccaList,ArrayList<Student> studentList) {
		
		int optionLogin = -1;
		while (optionLogin != Option_QUIT) {
			loginMenu();
			optionLogin = Helper.readInt("Enter choice > ");
			if (optionLogin == Option_LOGIN) {
				String login = loginStud(studentList);
				if (login !="zero" ) {
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
	//by Dzaki
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
							deleteCCA(ccaList,inputCCAdel(ccaList));
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
	//by Dzaki
	public static void startAdmin(String[] daysList,ArrayList<Admin> adminList, ArrayList<CCA> ccaList,ArrayList<Student> studentList, 
			ArrayList<Parent> parentList, ArrayList<Category> catList,ArrayList<CCA> emptyCCAlist) {

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
							deleteCCA(ccaList,inputCCAdel(ccaList));
						} else if (option == 4) {
							viewCCAStudents(studentList);
						} else if (option == 5){
							addStudentToCCA(ccaList,studentList);
						}else if (option == 6) {
							viewAllStudents(studentList);
						}else if (option == 7) {
							Student student = inputStudAdd(studentList);
							addStudent(studentList,student);
						}else if (option == 8) {
							deleteStudent(studentList,inputStudentDel(studentList));
						}else if (option == 9) {
							viewCat(catList);
						}else if (option == 10) {
							addCat(catList,inputAddCat(emptyCCAlist));
						}else if (option == 11) {
							removeCat(catList);
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
	//by Dzaki
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
	// by Wen Jiang
	private static String loginStud(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		
		boolean foundStudent = false;
		boolean success = false;
		String login = "zero";
		while (!success) {
			String LoginStudentID = Helper.readString("Enter Student ID > ");
			int registrationID = Helper.readInt("Enter CCA Registration ID > ");
			
			for (Student s : studentList) {
				if (LoginStudentID.equals(s.getID())) { 
					foundStudent = true;
					if(registrationID == s.getRegistrationID()) {
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
	//by whole team
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
	//by team
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
	//by team
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
	
	//=================================VIEW Methods==================================================//
	
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
	//by Anessa
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
	//by Dzaki
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

		for (int i = 0;i<ccaList.size();i++) {
			output += ccaList.get(i).display();
		}
		return output;
	}
	//by Dzaki
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		String output = "\nLIST OF CCA\n";
		// additionally displays the vacancy of the CCA in real time
		output += String.format("%-23s %-25s %-13s %-12s %-18s %-15s %-10s\n", 
				"TITLE","DESCRIPTION","VACANCY","DAY","TIME","VENUE","IN-CHARGE");
		output += retrieveAllCCA(ccaList);
		
		System.out.println(output);
	}
	//by Anessa
	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10s%-15s%-10d%-10s%-20s%s\n", studentList.get(i).getID(), studentList.get(i).getName(),
					studentList.get(i).getGrade(), studentList.get(i).getStudClass(), studentList.get(i).getTeacher(),
					studentList.get(i).getRegistrationID());
		}
		return output;
	}
	public static void viewAllStudents(ArrayList<Student> studentList) {
		String output = "";
		output += String.format("%-10s%-15s%-10s%-10s%-20s%s\n", "ID", "NAME", "GRADE", "CLASS", "TEACHER","REG. ID");
		
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10s%-15s%-10d%-10s%-20s%s\n", studentList.get(i).getID(), studentList.get(i).getName(),
					studentList.get(i).getGrade(), studentList.get(i).getStudClass(), studentList.get(i).getTeacher(),
					studentList.get(i).getRegistrationID());
		}
		System.out.println(output);
	}
	//by Shi Jie
	private static void viewAllParents(ArrayList<Parent> parentList) {
		// TODO Auto-generated method stub
		String output = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "StudentID", "Student Name",
				"grade", "classroom", "teacher","registeration ID", "parent", "parent Email", "parent number");
		output += getParentDetails(parentList);

		System.out.println(output);
	}
	//by Shi Jie
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
	//by Syahrul
	public static String loadDataCat(ArrayList<Category> obj) {
		String output = "";
		for (Category C : obj) {
			output += "\n- " + C.getCname();
		}
		return output;
	}
	//by Syahrul
	public static void viewCat(ArrayList<Category> obj) {
		// TODO Auto-generated method stub
		String output = "Categories: \n";
		output += "--------";
		output += loadDataCat(obj);
		System.out.println(output);
		
	}
	
	//=============================================ADD Methods======================================//
	// WenJiang and Dzaki
	public static void studCCAReg(ArrayList<CCA> ccaList,ArrayList<Student> studentList, String id) {
        // TODO Auto-generated method stub
        String output = String.format("%-30s", "CCA List:");
        CCA chosenCCA = null;
        int i = 0;
        for (CCA c : ccaList) {
            i++;
            output+= String.format("\n%d) %-30s", i,c.getTitle());
        }
        System.out.println(output);
        int CCAOption = Helper.readInt("Select CCA > ");
        for(int x = 0; x < ccaList.size();x++) {
            if(x == CCAOption -1) {
                chosenCCA = ccaList.get(x);
            }
        }
        if (!chosenCCA.isFull() && !chosenCCA.isPaid()) {
            for(Student s : studentList) {
                if (s.getID().equals(id)) {
                    chosenCCA.getStudentList().add(s);
                    s.setInCCA(true);
                    s.setCCA(chosenCCA);
                    System.out.println("CCA chosen successfully");
                    if(chosenCCA.getClassSize()<=chosenCCA.getStudentList().size()) {
                        chosenCCA.setFull(true);
                    }
                }
            }

        }else if (!chosenCCA.isFull() && chosenCCA.isPaid()) {
			boolean paid = Helper.readBoolean("Have you made payment? >");
			if (paid) {
				for(Student s : studentList) {
	                if (s.getID().equals(id)) {
	                    chosenCCA.getStudentList().add(s);
	                    s.setInCCA(true);
	                    s.setCCA(chosenCCA);
	                    s.setHasPaid(true);
	                    System.out.println("CCA chosen successfully");
	                    if(chosenCCA.getClassSize()<=chosenCCA.getStudentList().size()) {
	                        chosenCCA.setFull(true);
	                    }
	                }
	            }
			}else {
				System.out.println("Kindly make payment first.");
			}
        }
        else {
            System.out.println("Invalid option");
        }
    }
	//by Dzaki
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
		String time = Helper.readString("Enter Duration of CCA (__pm -__pm)> ");
		String venue = Helper.readString("Enter venue of CCA > ");
		String name = Helper.readString("Enter Name of Instructor In-Charge > ");
		boolean isPaid = Helper.readBoolean("Is this a paid CCA? >");
		CCA cca= new CCA(title,desc,classSize,day,time,venue,name,studentList,isPaid);
		return cca;
		
	}
	//by Dzaki
	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {		
		ccaList.add(cca);
	}
	//by Wen Jiang & Dzaki
	public static void addStudentToCCA(ArrayList<CCA> ccaList,ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		String output = String.format("%-30s", "CCA List:");
		CCA selectedCCA = null;
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
			if (z == CCAOption-1) {
				selectedCCA = ccaList.get(z);
			}
		}
		//push
		if (!selectedCCA.isFull() && !selectedCCA.isPaid()) {
			for(int x = 0; x < studentList.size();x++) {
				if(x == (studentOption - 1)) {
					selectedCCA.getStudentList().add(studentList.get(x));
					studentList.get(x).setCCA(selectedCCA);
					studentList.get(x).setInCCA(true);
					System.out.println("Student added successfully");
					if(selectedCCA.getClassSize()<=selectedCCA.getStudentList().size()) {
						selectedCCA.setFull(true);
					}
				}
			}
		}else if (!selectedCCA.isFull() && selectedCCA.isPaid()) {
			boolean paid = Helper.readBoolean("Has student paid? >");
			if (paid) {
				for(int x = 0; x < studentList.size();x++) {
					if(x == (studentOption - 1)) {
						selectedCCA.getStudentList().add(studentList.get(x));
						studentList.get(x).setCCA(selectedCCA);
						studentList.get(x).setInCCA(true);
						studentList.get(x).setHasPaid(true);
						System.out.println("Student added successfully");
						if(selectedCCA.getClassSize()<=selectedCCA.getStudentList().size()) {
							selectedCCA.setFull(true);
						}
					}
				}
			}else {
				System.out.println("Student has yet to pay.");
			}
		}

	}
	//by Anessa
	public static Student inputStudAdd(ArrayList<Student> studentList) {
		String id = Helper.readString("Enter new student ID > ");
		String name = Helper.readString("Enter new student name > ");
		int grade = Helper.readInt("Enter new student grade > ");
		String studClass = Helper.readString("Enter new student class > ");
		String teacher = Helper.readString("Enter new student classroom teacher > ");
		int regID = Helper.readInt("Enter Registration ID");

		Student student = new Student(id, name, grade, studClass, teacher, regID);

		return student;

	}
	public static void addStudent(ArrayList<Student> studentList, Student student) {
		if (student != null) {
			studentList.add(student);
			System.out.println("Student successfully added!");
		}else {
			System.out.println("Student could not be added!");
		}

	}
	//by Shi Jie
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
	//by Syahrul
	public static Category inputAddCat(ArrayList<CCA> catList) {
		String input = Helper.readString("Enter Category name > ");
		Category input2 = new Category(input,catList);
		return input2;
	}
	//by Syahrul
	public static void addCat(ArrayList<Category> obj, Category input) {
		obj.add(input);
		System.out.println("CCA Category added!");
	}
	//=======================================DELETE METHODS=====================================================
	//by Dzaki
	public static CCA inputCCAdel(ArrayList<CCA> ccaList) {
		boolean found = false;
		String title = Helper.readString("Enter CCA Title > ");
		int index = 0;

		for (int i = 0; i < ccaList.size();i++) {
			if (title.equalsIgnoreCase(ccaList.get(i).getTitle())){
				index=i;
				found = true;
			}
		}
		if (found) {
			System.out.println(index);
			return ccaList.get(index);	
		}else {
			return null;
		}
		
	}
	//by Dzaki
	public static void deleteCCA(ArrayList<CCA> ccaList, CCA c) {
		if (c != null) {
			
				ccaList.remove(c);
				System.out.println("DELETING CCA....");
				System.out.println("CCA has been deleted");
		}else {
			System.out.println("CCA not found!");
		}
	}
	//by Anessa
	public static Student inputStudentDel(ArrayList<Student> studentList) {
		String id = Helper.readString("Enter student ID to be deleted > ");
		boolean delete = false;
		int key = 0;
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getID().equals(id)) {
				key = i;
				delete = true;
			}
		}
		if (delete) {
			System.out.println(key);
			return studentList.get(key);
		} else {
			return null;
		}
	}
	public static void deleteStudent(ArrayList<Student> studentList, Student s) {
		if ( s != null ) {		
			studentList.remove(s);
			System.out.println("Student has been deleted!");
		} else {
			System.out.println("Failed to delete student!");
		}
	}
	//by Shi jie
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
	//by Shi Jie
	public static boolean isExist(ArrayList<Category> obj, String input) {
		boolean check = false;
		for (int i = 0; i < obj.size(); i++) {
			if (obj.get(i).getCname().equalsIgnoreCase(input)) {
				obj.remove(i);
				check = true;
			}
		}
		return check;
	}
	//by Syahrul
	public static void removeCat(ArrayList<Category> obj) {
		String input = Helper.readString("Enter Category name > ");
		boolean check = isExist(obj, input);
		
		if (check == true) {
			System.out.println("Remove Successful");
		} else if (check == false) {
			System.out.println("Name does not exist! Remove fail!");
		}
	}
	//by Shi Jie
	public static int checkRegisterationID(ArrayList<Parent> parentList, Random rand, int ccaRegister) {
		for (int i = 0; i < parentList.size(); i++) {
			if (ccaRegister == parentList.get(i).getRegistrationID()) {
				ccaRegister = rand.nextInt(99999);
			}
		}
		return ccaRegister;
	}
	
}