import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private CCA cca1;
	private CCA cca2;
	private CCA cca3;
	
	private Student stud1;
	private Student stud2;
	private Student stud3;
	private Student stud4;

	private ArrayList<CCA> ccaList = new ArrayList<CCA>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private CCA football;
	private CCA rugby;
	private Student marshal;
	private Student lily;
	private Parent mem1 = new Parent("6", "Ben Lim", 9, "W64H", "Ms Denise", 6, "Lim", "Lim@gmail.com", 90110241);
	private Parent mem2 = new Parent("7", "Dzaki", 9, "W64H", "Ms jasmine", 7, "Dzaki", "Dzaki@gmail.com", 90110241);
	private Parent mem3 = new Parent("8", "Dzaki", 9, "W64H", "Ms jasmine", 9, "Dzaki", "Dzaki@gmail.com", 90110241);

	private Category c1;
	private Category c2;
	private Category c3;
	
	private ArrayList<CCA> detail;
	private ArrayList<Category> obj;
	@Before
	public void setUp() throws Exception {
		ArrayList<Student> soccer = new ArrayList<Student>();
		ArrayList<Student> lego = new ArrayList<Student>();
		ArrayList<Student> swim = new ArrayList<Student>();
		cca1 = new CCA("Little League Soccer", "Soccer Club for Boys", 30, "Wednesday", "2:00PM - 4:00PM",
				"School Field", "Mr Izzat", soccer, false);
		cca2 = new CCA("LEGO Expert", "LEGO building masters", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon",
				lego,false);
		cca3 = new CCA("Swimming", "Swim faster", 30, "Tuesday", "2:00PM - 3:00PM", "Yishun Complex", "Mr Jordon",
				swim,false);
		
		stud1 = new Student("6","Ben Lim", 6, "W64H", "Ms Denise",6);
		stud2 = new Student("5","Izzat", 6, "W64H", "Mr Joseph",5);
		stud3 = new Student("3","Lim Chong Hin", 5, "W64H", "Ms Denise",3);
		stud4 = new Student("2","Lee Ah", 2, "W64H", "Ms Denise",2);
		c1 = new Category("Sports", detail);
		c2 = new Category("Musics", detail);
		c3 = new Category("Arts", detail);
		
		detail = new ArrayList<CCA>();
		obj = new ArrayList<Category>();
	}

	@Test
	public void testRetrieveAllCCA() {// Dzaki
		// Test if cca list is not null but empty -boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve item", ccaList);

		// test if the list of cca retrieved from the SourceCentre is empty - boundary
		String allCCA = C206_CaseStudy.retrieveAllCCA(ccaList);
		String testOutput = "";
		assertEquals("Check that ViewAllCCA", testOutput, allCCA);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, ccaList.size());

		// test if the expected output string same as the list of cca retrieved from the
		// SourceCentre
		allCCA = C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n", "Little League Soccer",
				"Soccer Club for Boys", 30, "Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat");
		testOutput += String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n", "LEGO Expert",
				"LEGO building masters", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon");

		assertEquals("Test that ViewAllCCA", testOutput, allCCA);
		
		// test that vacancy of CCA is updated when student registered and viewed again.
		//use one student to apply for Little League Soccer
		studentList.add(stud1);
		C206_CaseStudy.addStudentToCCA(ccaList,studentList);
		allCCA = C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n", "Little League Soccer",
				"Soccer Club for Boys", 29, "Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat");
		testOutput += String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n", "LEGO Expert",
				"LEGO building masters", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon");
		assertEquals("Test that vacancy is updated", testOutput, allCCA);
	}

	@Test
	public void testAddCCA() {// Dzaki

		// Item list is not null, so that can add a new CCA - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);

		// Given an empty list, after adding 1 cca, the size of the list is 1 - normal
		// The item just added is as same as the first cca of the list
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check that CCA is added", cca1, ccaList.get(0));

		// Add another cca. test The size of the list is 2? -normal
		// The cca just added is as same as the second item of the list
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that CCA arraylist size is 2", 2, ccaList.size());
		assertSame("Check that CCA is added", cca2, ccaList.get(1));

		// test that title for CCA object should not be empty
		assertFalse(cca1.getTitle().isEmpty());

		// test that classSizes are more than 0 and less than 50
		assertTrue(cca1.getClassSize()<50 && cca1.getClassSize()>0);
		assertTrue(cca2.getClassSize()<50 && cca1.getClassSize()>0);
		assertTrue(cca3.getClassSize()<50 && cca1.getClassSize()>0);

	}

	@Test
	public void testDeleteCCA() {// Dzaki
		// Item list is not null, so that can add a new CCA - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);

		// test that item in the list is not null to be deleted.
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertNotNull(cca1);
		assertNotNull(cca2);

		// test item exists in stack(boundary)
		assertTrue(ccaList.contains(cca1));
		assertTrue(ccaList.contains(cca2));
		assertFalse(ccaList.contains(cca3));

		// test that correct CCA is removed from list (normal)
		C206_CaseStudy.deleteCCA(ccaList, cca2);
		assertEquals(ccaList.get(0).getTitle(), "Little League Soccer");
		assertEquals(ccaList.size(), 1);

		// test that delete function will not delete 2 CCA (error)
		C206_CaseStudy.addCCA(ccaList, cca2);
		C206_CaseStudy.deleteCCA(ccaList, cca1);
		assertNotEquals(ccaList.size(), 0);
		assertTrue(ccaList.contains(cca2));

	}
	@Test 
	public void testRetrieveAllStudents() { // Anessa
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);

		//test if the list of students retrieved from the C206_CaseStudy is empty
		String allStudent= C206_CaseStudy.retrieveAllStudents(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addStudent(studentList, stud1);
		C206_CaseStudy.addStudent(studentList, stud2);
		assertEquals("Test if that Student arraylist size is 2?", 2, studentList.size());

		//test if the expected output string same as the list of Student retrieved from the C206_CaseStudy
		allStudent= C206_CaseStudy.retrieveAllStudents(studentList);

		testOutput = String.format("%-10s%-15s%-10d%-10s%-20s%s\n", "6","Ben Lim", 6, "W64H", "Ms Denise",6);
		testOutput += String.format("%-10s%-15s%-10d%-10s%-20s%s\n","5","Izzat", 6, "W64H", "Mr Joseph",5);

		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
	}

	@Test
	public void testAddStudent() { // Anessa
		// Student list is not null, so that can add a new item
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);

		//Given an empty list, after adding 1 item, the size of the list is 1
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addStudent(studentList, stud1);			
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, studentList.size());
		assertSame("Test that Camcorder is added same as 1st item of the list?", stud1, studentList.get(0));

		//Add another item. test The size of the list is 2
		C206_CaseStudy.addStudent(studentList, stud2);
		C206_CaseStudy.addStudent(studentList, stud3);
		assertEquals("Test that Student arraylist size is 3?", 3, studentList.size());				
		assertSame("Test that Student is added same as 3rd item of the list?", stud3, studentList.get(2));
	}

	@Test
	public void testDeleteStudent() { // Anessa
		// Item list is not null, so that can add a new Student - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", studentList);

		// test that item in the list is not null to be deleted.
		C206_CaseStudy.addStudent(studentList, stud1);
		C206_CaseStudy.addStudent(studentList, stud2);
		assertNotNull(stud1);
		assertNotNull(stud2);

		// test item exists in stack - boundary
		assertTrue(studentList.contains(stud1));
		assertTrue(studentList.contains(stud2));
		assertFalse(studentList.contains(stud3));

		// test that correct Student is removed from list - normal
		C206_CaseStudy.deleteStudent(studentList, stud2);
		assertEquals(studentList.get(0).getID(), "6");
		assertEquals(studentList.size(), 1);

		// test that delete function will not delete 2 Student - error
		C206_CaseStudy.addStudent(studentList, stud2);
		C206_CaseStudy.deleteStudent(studentList, stud1);
		assertNotEquals(studentList.size(), 0);
		assertTrue(studentList.contains(stud2));

	}

	@Test
	public void testAddParent() {// shi jie
		studentList.add(stud1);
		studentList.add(stud2);
		studentList.add(stud3);
		studentList.add(stud4);
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		C206_CaseStudy.addParent(parentList,studentList);
		
		assertSame("parentList size is 1", parentList.size(), 1);
		assertFalse(parentList.isEmpty());
	}
	@Test
	public void testAddParent2() {// shi jie
		studentList.add(stud1);
		studentList.add(stud2);
		studentList.add(stud3);
		studentList.add(stud4);
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		C206_CaseStudy.addParent(parentList,studentList);
//		
//		C206_CaseStudy.addParent(parentList,studentList);
//		C206_CaseStudy.addParent(parentList,studentList);
		String mem4 =parentList.get(0).getID();
		assertSame("parentList at index 1 is same as m4", parentList.get(0).getID(), mem4);

	}

	@Test
	public void testAddParentBountry() {// shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		assertTrue(parentList.isEmpty());
		parentList.clear();
		assertTrue(parentList.isEmpty());

	}

	@Test
	public void testDeleteNormal() {//shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();

		parentList.add(mem1);
		parentList.add(mem2);
		parentList.add(mem3);
		Parent mem4 = parentList.remove(1);
		assertTrue(mem2.getID().equals(mem4.getID()));

	}

	@Test
	public void testDeleteBountry() {
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		assertTrue(parentList.isEmpty());
		parentList.add(mem1);
		parentList.add(mem2);
		
		C206_CaseStudy.deleteParent(parentList);
		assertTrue(parentList.size() == 1);
	}

	@Test
	public void testDeleteError() {

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddStudentToCCA() {//wenjiang
		lily = new Student("21000000", "Ben Lim", 9, "W64H", "Ms Denise", 1);
		marshal = new Student("21000001", "Ben Lim", 9, "W64H", "Ms Denise", 2);
		football = new CCA("Little League Soccer", "Soccer Club for Boys", 30, "Wednesday", "2:00PM - 4:00PM",
				"School Field", "Mr Izzat", studentList,false);
		rugby = new CCA("Rugby", "RUSH", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", studentList,false);
		// Student list is not null, so that can add a new student - boundary
		assertNotNull("Check if there is valid arraylist to add to", football.getStudentList());

		// Given an empty list, after adding 1 student, the size of the list is 1 -
		// normal
		// The student just added is as same as the first student of the list
		football.getStudentList().add(lily);
		assertEquals("Check that the arraylist size is 1", 1, football.getStudentList().size());
		assertSame("Check that Student is added", lily, football.getStudentList().get(0));

		// Add another student. test The size of the list is 2? -normal
		// The student just added is as same as the second item of the list
		football.getStudentList().add(marshal);
		assertEquals("Check that arraylist size is 2", 2, football.getStudentList().size());
		assertSame("Check that second student is added", marshal, football.getStudentList().get(1));

		// test that student id for student object should not be empty
		assertFalse(lily.getID().isEmpty());

	}

	@Test
	public void testStudentsInCCA() {//wenjiang
		lily = new Student("21000000", "Ben Lim", 9, "W64H", "Ms Denise", 1);
		marshal = new Student("21000001", "Ben Lim", 9, "W64H", "Ms Denise", 2);
		// Test if student list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);

		// test that the students are not null
		assertNotNull("Test that student 1 is not null", lily);
		assertNotNull("Test that student 2 is not null", marshal);
		// Given an empty list, after adding 2 students, test if the size of the list is
		// 2 - normal
		studentList.add(lily);
		studentList.add(marshal);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());

		// test that the students added are the same
		assertSame("Test that student 1 is added", lily, studentList.get(0));
		assertSame("Test that student 2 is added", marshal, studentList.get(1));

		// Test that both students are false for in CCA
		assertFalse(studentList.get(0).isInCCA());
		assertFalse(studentList.get(1).isInCCA());

		// test that after setting student 1 isInCCA to true, isInCCA becomes true -
		// normal
		studentList.get(0).setInCCA(true);
		assertTrue("Test that student 1 isInCCA is true", studentList.get(0).isInCCA());

	}

	@Test
	public void testLogin() {//wenjiang
		lily = new Student("21000000", "Ben Lim", 9, "W64H", "Ms Denise", 1);
		marshal = new Student("21000001", "Ben Lim", 9, "W64H", "Ms Denise", 2);
		// Test that student id and cca registration id is not null in student
		// Test that student id is not null
		// Test that cca registration id is not null
		assertNotNull("Test that student id is not null", lily.getID());
		assertNotNull("Test that registration id is not null", lily.getRegistrationID());

		// test that the student just added is as same as the first student of the list
		// Test that after adding into student list, the student id stay the same
		studentList.add(lily);
		assertSame("Check that Student is added", lily, studentList.get(0));
		assertSame("check that student id is the same", lily.getID(), studentList.get(0).getID());

		// test that the student just added is as same as the first student of the list
		// Test that after adding into student list, the student id stay the same

		assertSame("check that student id is the same", lily.getRegistrationID(),
				studentList.get(0).getRegistrationID());

	}
	@Test
	public void testViewAllCat() {
		//Test if obj list is empty (boundary)
		assertNotNull(obj);
		
		//Test if list taken from main but its empty (boundary)
		String methodTest = C206_CaseStudy.loadDataCat(obj);
		String empty = "";
		assertEquals(methodTest, empty);
		
		//Test after adding 3 Categories, total object in list is 3 (normal)
		C206_CaseStudy.addCat(obj, c1);
		C206_CaseStudy.addCat(obj, c2);
		C206_CaseStudy.addCat(obj, c3);
		assertEquals(obj.size(), 3);
		
		//Test if output is equal to the data retrieve from list
		String realOutput = "Categories: " + C206_CaseStudy.loadDataCat(obj);
		String testOuput = "Categories: \n- Sports\n- Musics\n- Arts";
		assertEquals(realOutput, testOuput);
	}

	@Test
	public void testAddCat() {
		//Test list is not null so that is able to add categories (boundary)
		assertNotNull(obj);
		
		//Test after added a Category, the size of the list is 1 (normal) (a)
		//Test that item added to the list is equals to the first item in the list (b)
		C206_CaseStudy.addCat(obj, c1);	
		assertEquals(1, obj.size()); //(a)
		assertSame(c1, obj.get(0)); //(b)
		
		//Test if item list is 2 when added another Category (normal) (a)
		//Test that item added to the list is equals to the second item in the list (b)
		C206_CaseStudy.addCat(obj, c2);
		assertEquals(2, obj.size()); //(a)
		assertSame(c2, obj.get(1)); //(b)
		
		//Test if item list is 3 when added another Category (normal) (a)
		//Test that item added to the list is equals to the third item in the list (b)
		C206_CaseStudy.addCat(obj, c3);
		assertEquals(3, obj.size()); //(a)
		assertSame(c3, obj.get(2)); //(b)
	}
	
	@Test
	public void testRemoveCat() {
		//Test list is not empty so that it can remove categories (boundary)
		C206_CaseStudy.addCat(obj, c1);
		C206_CaseStudy.addCat(obj, c2);
		C206_CaseStudy.addCat(obj, c3);
		assertTrue(!obj.isEmpty());
		
		//Test if item list is 2 when a Category is removed (normal) (use: Sports)
		C206_CaseStudy.removeCat(obj);
		assertEquals(2, obj.size());
		
		//Test if Category list remains 2 when removing a Category that does not exist (Error) (use: Sports)
		C206_CaseStudy.removeCat(obj);
		assertEquals(2, obj.size());
	}

	@After
	public void tearDown() throws Exception {
	}
}
