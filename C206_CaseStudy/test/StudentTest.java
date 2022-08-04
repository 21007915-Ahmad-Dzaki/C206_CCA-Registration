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
	public void testViewAllStudents() {
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
			
		//test if the list of students retrieved from the SourceCentre is empty
		String allStudent= C206_CaseStudy.retrieveAllStudents(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
					
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addStudent(studentList, stud1);
		C206_CaseStudy.addStudent(studentList, stud2);
		assertEquals("Test if that Student arraylist size is 2?", 2, studentList.size());
			
		//test if the expected output string same as the list of Student retrieved from the C206_CaseStudy
		allStudent= C206_CaseStudy.retrieveAllStudents(studentList);

		testOutput = String.format(("%-10s%-15s%-10d%-10s%-20s%s\n", 
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
	}
}

