package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class LoginTests extends TestCase{
	
	private UserAccountManager userAccountManager;
	
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu",
				"9132835734");
	}
	
	//SUCCESS
	public void testSuccessfulLogIn() {
		//this test should pass as the user name and password are is valid
		
		UserAccount userAccount = userAccountManager.login("admin", "@umkcFH310");
		assertNotNull(userAccount);
		assertTrue(userAccount.getUserName().equalsIgnoreCase("admin"));
		assertTrue(userAccount.getPassword().equals("@umkcFH310"));
		assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
	}
	
	public void testSuccessfulLogIn2() {
		//this test should pass as the user name and password are valid. Case does not matter for user name
		
		UserAccount userAccount = userAccountManager.login("Admin", "@umkcFH310");
		assertNotNull(userAccount);
		assertTrue(userAccount.getUserName().equalsIgnoreCase("admin"));
		assertTrue(userAccount.getPassword().equals("@umkcFH310"));
		assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
	}
	
	//FAILURE
	
	public void testUnsuccessfulLogInWrongUsername() {
		//test should fail since the user name is incorrect
		
		UserAccount userAccount = userAccountManager.login("amin", "@umkcFH310");
		//account should return null as there is not an account with these log in credentials
		assertNull(userAccount);
		//should assert that the user name does not exist. test continues
		assertFalse(userAccountManager.doesUserNameExist("amin"));
		//since the username does not exist, this is the issue with the userAccount not being created
		if(userAccount == null) {
			System.out.println("The user name does not exist. testUnsuccessfulLogInWrongUsername()");
		}
	}

	public void testUnsuccessfulLogInWrongPass() {
		//test should fail since the password is incorrect
		
		UserAccount userAccount = userAccountManager.login("admin", "umkcFH310");
		//account should return null as there is not account with these log in credentials
		assertNull(userAccount);
		//should assert that the user name does exist. test continues
		assertTrue(userAccountManager.doesUserNameExist("admin"));
		//since the username exists yet the userAccount still returns null, the password must be the issue
		if (userAccount == null){
			System.out.println("The password does not exist. testUnsuccessfulLogInWrongPass()");
		}
	}
	
}
