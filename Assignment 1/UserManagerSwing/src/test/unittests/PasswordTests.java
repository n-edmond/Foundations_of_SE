package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class PasswordTests extends TestCase {
	/*it must have at least six characters, consist of only letters, digits, and special characters 
	(@, #, $, ^, &), and at least one upper-case letter, one lower-case letter, one digit, and one special character.*/
	
	//SUCCESS
	public void testValidPassword() {
		//this password is valid so test should pass
		assertTrue(UserAccount.isPasswordValid("@White0House"));
	}
	
	public void testValidPasswordWithOneUpper() {
		//this password is valid. Will test with only one upper case
		assertTrue(UserAccount.isPasswordValid("isValid1@"));
	}
	
	public void testValidPasswordWithOneLower() {
		//this password is valid. will return with only one lower case
		assertTrue(UserAccount.isPasswordValid("iSVALID1@"));
	}
	
	//FAILURES
	public void testInvalidPasswordEmpty() {
		//an empty password is invalid so test should fail
		System.out.println("Password failure. Empty string encountered");
		assertFalse(UserAccount.isPasswordValid(""));
	}
	
	public void testInvalidPasswordMissingUpper() {
		//this should fail since there is no upper case letters
		System.out.println("Password failure. No upper case encountered");
		assertFalse(UserAccount.isPasswordValid("@white0house"));	
	}
	
	public void testInvalidPasswordMissingLower() {
		//this should fail since there are no lower case letters
		System.out.println("Password failure. No lower case encountered");
		assertFalse(UserAccount.isPasswordValid("@WHITE0HOUSE"));
	}
	
	public void testInvalidPasswordMissingSpecChar() {
		//this should fail since there are no special characters
		System.out.println("Password failure. No special character encountered");
		assertFalse(UserAccount.isPasswordValid("White0House"));
	}
	
	public void testInvalidPasswordInvalidSpecChar() {
		//this test should fail since it is not one of the authorized special characters
		System.out.println("Password failure. Unauthorized special character encountered");
		assertFalse(UserAccount.isPasswordValid("!White0House"));
	}

}
