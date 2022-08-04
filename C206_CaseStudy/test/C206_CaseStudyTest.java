import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private CCA cca1;
	private CCA cca2;
	private CCA cca3;

	private ArrayList<CCA> ccaList = new ArrayList<CCA>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private CCA football;
	private CCA rugby;
	private Student marshal;
	private Student lily;
	private Parent mem1 = new Parent("6", "Ben Lim", 9, "W64H", "Ms Denise", 6, "Lim", "Lim@gmail.com", 90110241);
	private Parent mem2 = new Parent("7", "Dzaki", 9, "W64H", "Ms jasmine", 7, "Dzaki", "Dzaki@gmail.com", 90110241);
	private Parent mem3 = new Parent("8", "Dzaki", 9, "W64H", "Ms jasmine", 9, "Dzaki", "Dzaki@gmail.com", 90110241);

	@Before
	public void setUp() throws Exception {
		ArrayList<Student> emptyList = new ArrayList<Student>();
		cca1 = new CCA("Little League Soccer", "Soccer Club for Boys", 30, "Wednesday", "2:00PM - 4:00PM",
				"School Field", "Mr Izzat", emptyList);
		cca2 = new CCA("LEGO Expert", "LEGO building masters", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon",
				emptyList);
		cca3 = new CCA("Swimming", "Swim faster", 30, "Tuesday", "2:00PM - 3:00PM", "Yishun Complex", "Mr Jordon",
				emptyList);
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

		// test that

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
	public void testAddParent() {// shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		parentList.add(mem1);
		assertSame("parentList size is 1", parentList.size(), 1);
		assertFalse(parentList.isEmpty());
	}

	@Test
	public void testAddParentBountry() {// shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		assertTrue(parentList.isEmpty());
		parentList.clear();
		assertTrue(parentList.isEmpty());

	}

	@Test
	public void testDeleteNormal() {
		ArrayList<Parent> parentList = new ArrayList<Parent>();

		parentList.add(mem1);
		parentList.add(mem2);
		Parent mem3 = parentList.remove(1);
		assertSame(mem3, mem2);

	}

	@Test
	public void testDeleteBountry() {
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
	public void testAddStudentToCCA() {
		lily = new Student("21000000", "Ben Lim", 9, "W64H", "Ms Denise", 1);
		marshal = new Student("21000001", "Ben Lim", 9, "W64H", "Ms Denise", 2);
		football = new CCA("Little League Soccer", "Soccer Club for Boys", 30, "Wednesday", "2:00PM - 4:00PM",
				"School Field", "Mr Izzat", studentList);
		rugby = new CCA("Rugby", "RUSH", 40, "Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", studentList);
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
	public void testStudentsInCCA() {
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
	public void testLogin() {
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

	@After
	public void tearDown() throws Exception {
	}
}
