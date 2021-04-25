package test.unittests.Item;

import junit.framework.TestCase;
import production.business.Item;

//DONE
public class GetTitleTest extends TestCase {
	
	private Item items = new Item ("popcorn", 2.58, 1);
	
	//tests that the getter function returns expected value
	public void testTitleRetrieved() {
		//this email address is valid so test should pass
		String expected_output = "popcorn";
		String output = items.getTitle();
		assertEquals(expected_output, output);
	}
	
	//tests title retrieval with random cases. should swap to lower case automatically
	public void testToLowerTitle() {
		
	}
	
	//tests unsuccessful title retrieval due to no title added
	public void testInvalidTitleEmpty() {
		assertFalse(Item.isTitleValid(""));
		System.out.println("Title failure. No title entered. testInvalidTitleEmpty()\n");
		
	}
	//tests that title contains letters and numbers
	public void testInvalidTitle() {
		assertFalse(Item.isTitleValid("pop1corn"));
		System.out.println("Title failure. Invalid characters encountered. testInvalidTitle()\n");
		
	}
	//tests that title does not contain letters and numbers
	public void testValidTitle() {
		assertTrue(Item.isTitleValid("popcorn"));
	}

}

