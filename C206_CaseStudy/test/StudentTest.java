import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



/**
 * @author 21027690
 *
 */

public class StudentTest {

	private Student stud1;
	private Student stud2;
	private Student stud3;
		
	private ArrayList<Student> studentList = new ArrayList<Student>();
		
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stud1 = new Student("6","Ben Lim", 9, "W64H", "Ms Denise",6);
		stud2 = new Student("5","Izzat", 9, "W64H", "Mr Joseph",5);
		stud3 = new Student("3","Lim Chong Hin", 9, "W64H", "Ms Denise",3);	
	}
		
	@Test 
	public void testRetrieveAllStudents() {
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

		testOutput = String.format("%-10s%-15s%-10d%-10s%-20s%s\n", "6","Ben Lim", 9, "W64H", "Ms Denise",6);
		testOutput += String.format("%-10s%-15s%-10d%-10s%-20s%s\n","5","Izzat", 9, "W64H", "Mr Joseph",5);
	
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
	}
	@Test
	public void testAddStudent() {
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
	public void testDeleteStudent() {
		// Item list is not null, so that can add a new Student - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", studentList);

		// test that item in the list is not null to be deleted.
		C206_CaseStudy.addStudent(studentList, stud1);
		C206_CaseStudy.addStudent(studentList, stud2);
		assertNotNull(stud1);
		assertNotNull(stud2);

		// test item exists in stack(boundary)
		assertTrue(studentList.contains(stud1));
		assertTrue(studentList.contains(stud2));
		assertFalse(studentList.contains(stud3));

		// test that correct Student is removed from list (normal)
		C206_CaseStudy.deleteStudent(studentList, stud2);
		assertEquals(studentList.get(0).getID(), "6");
		assertEquals(studentList.size(), 1);

		// test that delete function will not delete 2 Student (error)
		C206_CaseStudy.addStudent(studentList, stud2);
		C206_CaseStudy.deleteStudent(studentList, stud1);
		assertNotEquals(studentList.size(), 0);
		assertTrue(studentList.contains(stud2));

	}
}

