package test.unittests.Item;

import junit.framework.TestCase;
import production.business.Item;
import production.business.UserAccount;

//DONE
public class GetOrgUnitPriceTest extends TestCase {
	//Original unit price must only consists of numeric values. It must be a double
	
	private Item items = new Item ("popcorn", 2.58, 1);

	//SUCCESS
	public void testValidLastName() {
		//last name is valid so test should pass
		assertTrue(UserAccount.isLastNameValid("Smith"));
	}
	
	//FAILURE
	public void testInvalidLastNameContainsNum() {
		//last name is invalid since it contains a digit so test should fail
		System.out.println("Last Name failure, Int encountered. testInvalidLastNameContainsNum() \n");
		assertFalse(UserAccount.isLastNameValid("Sm1th"));
	}
	
	public void testInvalidLastNameEmpty() {
		//last name is empty so test should fail
		System.out.println("Last Name failure. Empty string encountered testInvalidLastNameContainsNum() \n");
		assertFalse(UserAccount.isLastNameValid(""));
	}

}
