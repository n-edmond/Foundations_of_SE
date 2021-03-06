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
	}
	
	//SUCCESS
	public void testSuccessfulLogIn() {
		//this test should pass as the user name and password are is valid
		
		UserAccount userAccount = userAccountManager.login("admin", "@umkcFH310");
		assertNotNull(userAccount);
		assertTrue(userAccount.getUserName().equalsIgnoreCase("admin"));
		assertTrue(userAccount.getPassword().equals("@umkcFH310"));
	}
	
	public void testSuccessfulLogIn2() {
		//this test should pass as the user name and password are valid. Case does not matter for user name
		
		UserAccount userAccount = userAccountManager.login("Admin", "@umkcFH310");
		assertNotNull(userAccount);
		assertTrue(userAccount.getUserName().equalsIgnoreCase("admin"));
		assertTrue(userAccount.getPassword().equals("@umkcFH310"));
	}
	
	//FAILURE
	
	public void testUnsuccessfulLogInWrongUsername() {
		//test should fail since the user name is incorrect
		
		UserAccount userAccount = userAccountManager.login("amin", "@umkcFH310");
		assertNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
		
		
	}
	
	public void testUnsuccessfulLogInWrongPass() {
		//test should fail since the password is incorrect
		
		UserAccount userAccount = userAccountManager.login("admin", "umkcFH310");
		assertNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
		
	}
	
	
}
