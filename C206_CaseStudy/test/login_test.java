/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * wenjiang, 2 Aug 2022 7:04:39 pm
 */

/**
 * @author wenjiang
 *
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class login_test {
	
	private ArrayList<CCA> ccaList = new ArrayList<CCA>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private CCA football;
	private CCA rugby;
	private Student marshal;
	private Student lily;
	
	public void setUp() throws Exception {
//		prepare test data
		lily = new Student("21000000","Ben Lim", 9, "W64H", "Ms Denise", "1");
		marshal = new Student("21000001","Ben Lim", 9, "W64H", "Ms Denise","2");
		football = new CCA("Little League Soccer","Soccer Club for Boys",30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat", studentList);
		rugby = new CCA("Rugby", "RUSH", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", studentList);
		
	}
	@Test
	public void testAddCCAStudent() {
		lily = new Student("21000000","Ben Lim", 9, "W64H", "Ms Denise", "1");
		marshal = new Student("21000001","Ben Lim", 9, "W64H", "Ms Denise","2");
		football = new CCA("Little League Soccer","Soccer Club for Boys",30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat", studentList);
		rugby = new CCA("Rugby", "RUSH", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", studentList);
		// Ensure both ArrayList is not null so more can be added- Boundary
		assertNotNull("Check if there is CCA arraylist to add to", ccaList);
		assertNotNull("Check if there is student arraylist to add to", studentList);
		// Add one to the empty lists, there should be 1 total - normal
		// Check the same object is in the array lists
		ccaList.add(football);
		studentList.add(marshal);
		assertEquals("Check cca arraylist size is 1", 1, ccaList.size());
		assertEquals("Check student arraylist size is 1", 1, studentList.size());
		assertSame("Check that the same cca is added", football, ccaList.get(0));
		assertSame("Check that the same student is added", marshal, studentList.get(0));

		// Add another object, test The size of the array lists is 2 - Normal
		// The object added recently is the same as the object before being added.
		ccaList.add(rugby);
		studentList.add(lily);
		assertEquals("Check that cca arraylist size is 2", 2, ccaList.size());
		assertEquals("Check that student arraylist size is 2", 2, ccaList.size());
		assertSame("Check that rugby is added", rugby, ccaList.get(1));
		assertSame("Check that lily is added", rugby, ccaList.get(1));
		
		// test that title for all CCA objects should not be empty
		assertFalse(football.getTitle().isEmpty());
		assertFalse(rugby.getTitle().isEmpty());
		
		// test that id for all student objects should not be empty
		assertFalse(marshal.getID().isEmpty());
		assertFalse(lily.getID().isEmpty());
		
		//test that registrationId for all student objects should not be empty
		assertFalse(marshal.getRegistrationID().isEmpty());
		assertFalse(lily.getRegistrationID().isEmpty());
		
		// test that the arraylist in CCA objects are empty
		assertTrue(football.getStudentList().isEmpty());
		assertTrue(rugby.getStudentList().isEmpty());
		
		
		//test that students can be added to the ArrayList in the CCA
		football.getStudentList().add(lily);
		rugby.getStudentList().add(marshal);
		assertSame("Check that football student list contains lily",football.getStudentList().get(0), lily);
		assertSame("Check that rugby student list contains marshal",rugby.getStudentList().get(0), marshal);
		
		//arraylist in CCA objects contain one Student object each
		assertEquals("check one student in football",football.getStudentList().size(),1);
		assertEquals("check one student in rugby",rugby.getStudentList().size(),1);
		
	}
	@Test
	public void testRemoveCCAStudent() {
//		lily = new Student("21000000","Ben Lim", 9, "W64H", "Ms Denise", "1");
//		marshal = new Student("21000001","Ben Lim", 9, "W64H", "Ms Denise","2");
//		football = new CCA("Little League Soccer","Soccer Club for Boys",30, 
//				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat", studentList);
//		rugby = new CCA("Rugby", "RUSH", 40, 
//				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon", studentList);
		
		football.getStudentList().add(lily);
		football.getStudentList().add(marshal);
		//ensure students are added
		assertFalse("Check that students lily and marshal are added to football",football.getStudentList().isEmpty());
		
		//removing 1 student from the student list in football
		football.getStudentList().remove(lily);
		//ensure only 1 object is in the array list
		assertEquals("Check football has 1 student left in its student list",football.getStudentList().size(),1);
		//removing the last student from the array list
		football.getStudentList().remove(marshal);
		//check that array list is empty
		assertTrue("Check that football student list is empty",football.getStudentList().isEmpty());
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
}
