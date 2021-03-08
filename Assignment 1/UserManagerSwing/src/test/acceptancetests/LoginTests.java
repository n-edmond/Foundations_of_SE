package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class LoginTests extends TestCase{
	
	private UserAccountManager userAccountManager, userAccountManager2;
	
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu",
				"9132835734");
		
		userAccountManager2 = new UserAccountManager();
		userAccountManager2.registerNewUser("tesingNewLogin2", "@testingHere1", "@testingHere1", "Snow", "White", "snow_white@gmail.com",
				"(123)456-7890");
	}
	
	//SUCCESS
	public void testSuccessfulLogIn() {
		UserAccount userAccount = userAccountManager.login("admin", "@umkcFH310");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
	}
	
	
	//FAILURE
	public void testUnsuccessfulLogInWrongUsername() {
		//test should fail as the username does not match this password
		
		UserAccount userAccount = userAccountManager.login("taco", "@umkcFH310");
		assertNull(userAccount);
		assertFalse(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
	}
	
	public void testUnsuccessfulLogInWrongPass() {
		//test should fail as the password does not match this user name
		
		UserAccount userAccount = userAccountManager.login("admin", "umkcFH310");
		assertNull(userAccount);
		assertFalse(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
	}
	
	
}
