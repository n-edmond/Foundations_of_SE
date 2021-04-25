package test.unittests.Item;

import junit.framework.TestCase;
import production.business.UserAccount;

//DONE
public class UserNameTests extends TestCase {
	/*User name: it must start with a letter and consist of only letters and digits without any space character. 
	User name is case insensitive. Different users must have different user names.*/
	
	//SUCCESS
	public void testValidUserName() {
		//user name is valid test should be true
		assertTrue(UserAccount.isUserNameValid("admin"));
	}
	
	public void testValidUserNameWithCase() {
		//user name is valid as case does not matter
		assertTrue(UserAccount.isUserNameValid("AdminWithCase"));
	}
	
	public void testValidUserNameWithCaseAndNumber() {
		//user name is valid as numbers are allowed
		assertTrue(UserAccount.isUserNameValid("AdminWithCaseAndNumber1"));
	}

	//FAILURES
	public void testInvalidUserNameBeginWithInt() {
		//user name is not valid as it cannot begin with integer so test should fail
		System.out.println("UserName failure. Begins with int. testInvalidUserNameBeginsWithInt() \n");
		assertFalse(UserAccount.isUserNameValid("1admin"));
	}
	
	public void testInvalidUserNameHasSpace() {
		//user name is not valid as it cannot contain spaces so test should fail
		System.out.println("UserName failure. Whitespace encountered. testInvalidUserNameHasSpace() \n");
		assertFalse(UserAccount.isUserNameValid("ad min"));
	}
	
	public void testInvalidUserNameHasSpecChar() {
		//user name is valid as it cannot contain special characters so test should fail
		System.out.println("UserName failure. Special character encountered. testInvalidUserNameHasSpecChar() \n");
		assertFalse(UserAccount.isUserNameValid("adm!n"));
	}
	
	public void testInvalidUserNameOnlyNums() {
		//user name is not valid as it only contains numbers
		System.out.println("UserName failure. No letters encountered; begins with int. testInvalidUserNameOnlyNums() \n");
		assertFalse(UserAccount.isUserNameValid("2020"));
	}
}
