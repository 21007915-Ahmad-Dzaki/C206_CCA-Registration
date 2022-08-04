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
	@Before
	public void setUp() throws Exception {
		ArrayList<Student> emptyList = new ArrayList<Student>();
		cca1 = new CCA("Little League Soccer", "Soccer Club for Boys", 30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat",emptyList );
		cca2 = new CCA("LEGO Expert", "LEGO building masters", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon",emptyList );
		cca3 = new CCA("Swimming", "Swim faster", 30, 
				"Tuesday", "2:00PM - 3:00PM", "Yishun Complex", "Mr Jordon",emptyList );
	}

	@Test
	public void testRetrieveAllCCA() {//Dzaki
		// Test if cca list is not null but empty -boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve item", ccaList);
		
		//test if the list of cca retrieved from the SourceCentre is empty - boundary
		String allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		String testOutput = "";
		assertEquals("Check that ViewAllCCA", testOutput, allCCA);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, ccaList.size());
		
		//test if the expected output string same as the list of cca retrieved from the SourceCentre	
		allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n","Little League Soccer", "Soccer Club for Boys", 30, 
				"Wednesday", "2:00PM - 4:00PM", "School Field", "Mr Izzat" );
		testOutput += String.format("%-23s %-25s %-13d %-12s %-18s %-15s %-10s\n","LEGO Expert", "LEGO building masters", 40, 
				"Tuesday", "2:00PM - 3:00PM", "E62A", "Mr Jordon");
	
		assertEquals("Test that ViewAllCCA", testOutput, allCCA);
	}
	
	@Test
	public void testAddCCA() {//Dzaki
		
		// Item list is not null, so that can add a new CCA - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);
		
		//Given an empty list, after adding 1 cca, the size of the list is 1 - normal
		//The item just added is as same as the first cca of the list
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check that CCA is added", cca1, ccaList.get(0));

		//Add another cca. test The size of the list is 2? -normal
		//The cca just added is as same as the second item of the list
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that CCA arraylist size is 2", 2, ccaList.size());
		assertSame("Check that CCA is added", cca2, ccaList.get(1));
		
		// test that title for CCA object should not be empty
		assertFalse(cca1.getTitle().isEmpty());
		
		//test that 
		
	}
	
	@Test
	public void testDeleteCCA() {//Dzaki
		// test that item must exist in the list to be deleted. (boundary)
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertFalse(ccaList.contains(cca3));
		
		//test that CCA is removed from list (normal)
		
		C206_CaseStudy.deleteCCA(ccaList,cca2);
		assertEquals(ccaList.get(0).getTitle(),"Little League Soccer");
		assertEquals(ccaList.size(),1);

		
		//test that deleted CCA cannot be deleted again (error)
		assertEquals(ccaList.size(),1);
		assertEquals(ccaList.get(0).getTitle(),"Little League Soccer");
		assertFalse(ccaList.contains(cca2));
		
	}
	@Test
	public void testAddParent() {//shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",6,"Lim","Lim@gmail.com",90110241));
		assertSame("parentList size is 1",parentList.size(),1);
	}
	@Test
	public void testAddParentBountry() {//shi jie
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",6,"Lim","Lim@gmail.com",90110241));
		assertSame("parentList size is 1",parentList.size(),1);
		parentList.remove(0);
		assertSame("parentList size is 0",parentList.size(),0);
		parentList.add(new Parent("7","Benny  Lim", 9, "W64H", "Ms jasmine",7,"Lim","Lim@gmail.com",99999999));
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",8,"Lim","Lim@gmail.com",88888888));
		assertSame("parentList size is 2",parentList.size(),2);
	}
	@Test
	public void testDeleteNormal() {
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		parentList.add(new Parent("6","Ben Lim", 9, "W64H", "Ms Denise",6,"Lim","Lim@gmail.com",90110241));
		assertSame("parentList size is 1",parentList.size(),1);
		
	}
	@Test
	public void testDeleteBountry() {}
	@Test
	public void testDeleteError() {}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	@After
	public void tearDown() throws Exception {
	}
}
