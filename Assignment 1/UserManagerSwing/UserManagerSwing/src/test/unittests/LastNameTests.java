package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;

//DONE
public class LastNameTests extends TestCase {
	//Last name: it must consist of only letters

	//SUCCESS
	public void testValidLastName() {
		//last name is valid so test should pass
		assertTrue(UserAccount.isLastNameValid("Smith"));
	}
	
	//FAILURE
	public void testInvalidLastNameContainsNum() {
		//last name is invalid since it contains a digit so test should fail
		System.out.println("Last Name failure, Int encountered");
		assertFalse(UserAccount.isLastNameValid("Sm1th"));
	}
	
	public void testInvalidLastNameEmpty() {
		//last name is empty so test should fail
		System.out.println("Last Name failure. Empty string encountered");
		assertFalse(UserAccount.isLastNameValid(""));
	}

}
