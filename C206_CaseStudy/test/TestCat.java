
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCat {
	
	private Category c1;
	private Category c2;
	private Category c3;
	
	private ArrayList<CCA> detail;
	private ArrayList<Category> obj;

	@Before
	public void setUp() throws Exception {
		c1 = new Category("Sports", detail);
		c2 = new Category("Musics", detail);
		c3 = new Category("Arts", detail);
		
		detail = new ArrayList<CCA>();
		obj = new ArrayList<Category>();
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
		c1 =  null;
		c2 =  null;
		c3 =  null;
		
		detail = null;
		obj = null;
	}

}
