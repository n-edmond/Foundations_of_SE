package production.business;
import java.util.regex.*;

public class UserAccount {
	
	private String userName;
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public UserAccount() {	
	}
	
	public static String checkInputError(String userName, String password, String firstName, String lastName, String email, String phone){
		String errorMessage ="";
		if (!isUserNameValid(userName))
				errorMessage += "Invalid user name.\n";
		if (!isPasswordValid(password))
				errorMessage += "Invalid password.\n";	
		if (!isFirstNameValid(firstName))
			errorMessage += "Invalid first name.\n";
		if (!isLastNameValid(lastName))
			errorMessage += "Invalid last name.\n";
		if (!isEmailValid(email))
			errorMessage += "Invalid email.\n";
		if (!isPhoneNumberValid(phone))
			errorMessage += "Invalid phone number.\n";
		return errorMessage;
	}
	
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	// DONE EXCLUDING IF MULTIPLE USER NAEMES EXIST you need to complete this method; do not change the return type
	public static boolean isUserNameValid(String userName){
		// check if userName is valid
		
		//if the username is empty it is not valid
		if (userName.length() == 0) {
			return false;
		}
		userName= userName.toLowerCase();
		
		//if the username begins with a letter, continue the check
		if ((userName.charAt(0) >= 'a' && userName.charAt(0) <= 'z')){
			
			//creates a list of conditions to check for the string, must contain char or ints
			String userName_checker = "[^a-z0-9]";
			//compiles the userName_checker
		    Pattern pattern = Pattern.compile(userName_checker);
		    //runs pattern checker
		    Matcher matcher = pattern.matcher(userName);
		    //creates a boolean flag to find the given conditions
		    boolean flag = matcher.find();
		    
		    if (flag) {
		    	//special the user name check found an invalid character and is now invalid
		    	return false;
		    }
		    else {
		    	//user name found no invalid characters and is now valid
		    	return true;
		    } 
		}
		//otherwise, the username begins with something other than a char and is invalid
		else {
			return false;
		}
	 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	// DONE you need to complete this method; do not change the return type
	public static boolean isPasswordValid(String password){
		// check if password is valid

		//using regular expression to set the standards of the password
		String password_checker = "^(?=.*[0-9])"//checks that at least one digit is included
                       + "(?=.*[a-z])(?=.*[A-Z])"//checks that at least one upper/lower case letter included
                       + "(?=.*[@#$^&])"  //checks that one of these special chars are included
                       + ".{6,}$";//limits the password to at least 6, no upper limit for password
                       
		//compiles the regular expression
		Pattern pattern = Pattern.compile(password_checker);
		//checks for match in the password_checker
		Matcher matcher = pattern.matcher(password); 
		//returns boolean on if a match was found
		return matcher.matches();
	}

    public boolean isValidCredential(String userName, String password) {
         return matchUserName(userName) && matchPassword(password);
    }
    
    public boolean matchUserName(String userName) {
         return userName != null && userName.equalsIgnoreCase(this.userName);
    }
    
    private boolean matchPassword(String password) {
        return password != null && password.equals(this.password);
   }

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	// DONE you need to complete this method; do not change the return type
	public static boolean isFirstNameValid(String firstName){
		// check if firstName is valid
		
		//if last name is not entered it is not valid
		if(firstName.length()==0) {
			return false;
		}
				
		//iterate through the first name string
		for(int i = 0; i < firstName.length(); i++) {
			//if a character in the string is a number return that it is not valid
			if (Character.isDigit(firstName.charAt(i))) {
				return false;
			}
		}
		//return true otherwise
		return true;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	// DONE you need to complete this method; do not change the return type
	public static boolean isLastNameValid(String lastName){
		// check if lastName is valid
		
		//if last name is not entered it is not valid
		if(lastName.length()== 0) {
			return false;
		}
		//iterate through the first name string
		for(int i = 0; i < lastName.length(); i++) {
					//if a character in the string is a number return that it is not valid
			if (Character.isDigit(lastName.charAt(i))) {
				return false;
				}
			}
		//return true otherwise
		return true;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	// DONE you need to complete this method; do not change the return type
	public static boolean isEmailValid(String email){
		// check if email is valid
		
		//if the email entered is null or does not contain the '@' symbol it is not valid
		if( email == null || (email.indexOf("@")==-1)) {
			return false;
		}
		//it is valid otherwise
		return true;
	}

	public String getPhoneNumber(){
		return phone;
	}

	public void setPhoneNumber(String phone){
		this.phone = phone;
	}

	// DONE you need to complete this method; do not change the return type
	public static boolean isPhoneNumberValid(String phone){
		// check if phone (number) is valid
		//phone_num_check = Integer.parseInt(phone);
		
		//if the phone number contains at least 10 digits
		if (phone.matches("\\d{10}")) {
			return true;
		}
		// if phone number contains hyphens similar to 123-456-7890 it is valid
		else if (phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		}
		//if phone number contains brackets for are code it is valid
		else if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
			return true;		
		}
		//return false if none of the above conditions are met
		else {
			return false;
		}
	}
}