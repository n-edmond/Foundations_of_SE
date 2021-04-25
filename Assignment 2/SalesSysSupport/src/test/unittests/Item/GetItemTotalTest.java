package test.unittests.Item;

import junit.framework.TestCase;
import production.business.UserAccount;

//DONE
public class GetItemTotalTest extends TestCase {
	//Phone number: it must include three-digit area code and seven digit phone number
	
	/*ACCEPTABLE FORMATS
	 * 1234567890
	 * 123-456-7890
	 * (123)456-789
	 */
	
	//SUCCESS TESTS
	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
	}
	
	public void testValidPhoneNumberWithHypen() {
		//test phone number with hyphens. should pass
		assertTrue(UserAccount.isPhoneNumberValid("816-123-4567"));
	}
	
	public void testValidPhoneNumberWithParens() {
		assertTrue(UserAccount.isPhoneNumberValid("(816)123-4567"));
	}
	
	
	//FAILURE TESTS
	public void testInvalidPhoneNumber() {
		//phone number does not have enough digits. Should fail
		System.out.println("Phone number failure. Not enough digits. testInvalidPhoneNumber() \n");
		assertFalse(UserAccount.isPhoneNumberValid("12345678"));
	}
	
	public void testInvalidPhoneNumberNoneEntered() {
		//no phone number entered. Should fail
		System.out.println("Phone number failure. Empty string encountered. testInvalidPhoneNUmberNoneEntered() \n");
		assertFalse(UserAccount.isPhoneNumberValid(""));
	}
	
	public void testInvalidPhoneNumberNotEnoughHypens() {
		//should fail since not enough hyphens
		System.out.println("Phone number failure. Not enough hyphens. testInvalidPhoneNUmberNotEnoughHyphens() \n");
		assertFalse(UserAccount.isPhoneNumberValid("816-1234567"));
	}

}
