package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;


//DONE

public class RegisterNewUserTests extends TestCase{
	
	private UserAccountManager userAccountManager;

	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu",
				"9132835734");
	}

	//SUCCESS
	public void testSuccessfulRegistration() {
		//this is a successful registration so there should be no error messages

		String registrationResult = userAccountManager.registerNewUser("jsmith1", "@White0House", "@White0House", "John",
				"Smith", "john.smith@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith1", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
	}
	
	public void testSuccessfulRegistrationNewEmail() {
		//this is a successful registration using a new email address
		
		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smith", "this_is_john@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("this_is_john@gmail.com"));
		
	}
	
	public void testSuccessfulRegistrationWithNewPass() {
		//this is a successful registration using a new password
		
		String registrationResult = userAccountManager.registerNewUser("jsmith", "7357@nG", "7357@nG", "John",
				"Smith", "john.smith@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "7357@nG");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}
	
	public void testSuccessfulRegistrationWithNewFirstName() {
		//this is a successful registration with a new first name
		
		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "Johnathan",
				"Smith", "john.smith@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}
	
	public void testSuccessfulRegistrationWithNewLastName() {
		//this is a successful registration with a new last name

		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smithson", "john.smith@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}
	
	public void testSuccessfulRegisrationWithNewPhone() {
		//this is a successful registration with a new phone number

		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smith", "john.smith@gmail.com", "1234567890");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}
	
	public void testSuccessfulRegistrationPhoneHasHyphens() {
		//this is a successful registration with a new phone number that has hyphens

		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smith", "john.smith@gmail.com", "123-456-7890");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}
	
	public void testSuccessfulRegistrationPhoneHasParens() {
		//this is a successful registration with a phone number that has parenthesis

		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smith", "john.smith@gmail.com", "(123)456-7890");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
		
	}

	//FAILURE
	public void testRegistrationWithInvalidUserName() {
		// this test should fail due to the user name
		
		String registrationResult = userAccountManager.registerNewUser("2020", "@White0House", "@White0House",
				"John", "Smith", "johnsmith@gmail.com", "7024265734");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
	}
	
	public void testRegistrationWithInvalidEmail() {
		//this test should fail due to invalid email address
		
		String registrationResult = userAccountManager.registerNewUser("TeSt1", "@White0House", "@White0House",
				"John", "Doe", "johndoe.gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
	}
	
	public void testRegistrationWithInvalidFirstName() {
		//this test should fail due to invalid first name
		
		String registrationResult = userAccountManager.registerNewUser("TeSt2", "@White0House", "@White0House",
				"1456j", "Doe", "johndoe@gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));	
	}
	
	public void testRegistrationWithInvalidLastName() {
		//this test should fail due to invalid last name 
		
		String registrationResult = userAccountManager.registerNewUser("TeSt3", "@White0House", "@White0House",
				"John", "D123oe", "johndoe@gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));	
	}
	
	public void testRegistrationWithNonmatchingPasswords() {
		//this test should fail since re-entered passwords do not match
		
		String registrationResult = userAccountManager.registerNewUser("TeSt4", "@White0House", "@WhiteHouse",
				"John", "Doe", "johndoe@gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		
	}
	
	public void testRegistrationWithInvalidPasswords() {
		//this test should fail since password is invalid 
		
		String registrationResult = userAccountManager.registerNewUser("TeSt6", "1234", "1234",
				"John", "Doe", "johndoe@gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
	}
	
	public void testRegistrationWithInvalidPhoneNum() {
		//this test should fail since the phone number provided is invalid
		
		String registrationResult = userAccountManager.registerNewUser("TeSt5", "@White0House", "@White0House",
				"John", "Doe", "johndoe@gmail.com", "123-45678");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		
	}
	
	public void testRegistrationWithExistingUserName() {
		//this test should fail since the username of 'admin' already exists
		
		String registrationResult = userAccountManager.registerNewUser("admin", "@White0House", "@White0House",
				"John", "Doe", "johndoe@gmail.com", "1234567890");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		
		
	}
	
}
