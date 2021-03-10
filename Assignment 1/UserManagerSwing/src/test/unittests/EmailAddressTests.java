package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;

//DONE
public class EmailAddressTests extends TestCase {
	//Email address: it must be a valid email address. In this case email addresses must contain @ symbol to be valid as there are many types of email addresses
	
	public void testValidEmailAddress() {
		//this email address is valid so test should pass
		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com"));
	}
	public void testInvaldiEmailAddressNoSym() {
		//this email lacks the '@' symbol so email should fail
		System.out.println("email failure. no @ symbol. testInvalidEmailAddressNoSym() ");
		assertFalse(UserAccount.isEmailValid("thisShouldFail.com"));
	}

}
