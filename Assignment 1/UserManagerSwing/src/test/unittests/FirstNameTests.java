package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;

//DONE
public class FirstNameTests extends TestCase {
	//First name: it must consist of only letters

	//SUCCESS
	public void testValidFirstName() {
		//this is a valid first name so test should pass
		assertTrue(UserAccount.isFirstNameValid("john"));
	}
	
	public void testInvalidFirstNameContainsNum() {
		//contains a number so this test should fail
		System.out.println("First name failure. Int encountered. testInvalidFirstNameContainsNum()\n");
		assertFalse(UserAccount.isFirstNameValid("1John"));
	}
	
	public void testInvalidFirstNameEmpty() {
		//last name is empty so test should fail
		System.out.println("First name failure. Empty string encountered. testInvalidFistNameEmpty() \n");
		assertFalse(UserAccount.isFirstNameValid(""));
	}

}
