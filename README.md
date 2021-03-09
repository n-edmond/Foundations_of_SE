# Foundations_of_SE

The course introduces concepts of software engineering (e.g. definitions, context) and the software development process (i.e. life cycle). Students will get a solid foundation in agile methodology, software requirements, exceptions and assertions, verification and validation, software models and modeling, and user Interface design. Various software architectures are discussed.

-------------------------------------------------------------------------------------------------------

### Assignment 1 - Acceptance Criteria and Testing
This assignment focuses on acceptance criteria and test programming. It is based on the given “UserManagerSwing” project, which allows a new user to sign up (referred to as the user story of “register new user”) and an existing user to log in (referred to as the user story of “login”). The production code is partially written. The source code consists of the following packages and classes:  


![userManagerSwing](https://github.com/n-edmond/Foundations_of_SE/blob/main/Images/UserManagerSwing.png)
	
	
Please do not create any new package or class. You only need to add code to the existing classes. To test if the project has been set up correctly on your computer, you may run UserManagerGUI.java as a Java application, which should present the following interface:

![login](https://github.com/n-edmond/Foundations_of_SE/blob/main/Images/login.png)

The user name and password of a predefined user account are "admin" and "@umkcFH310", respectively. You should be able to use this account to log in. You may test your acceptance criteria manually through the GUI if you want, but you do not need to understand or modify the GUI classes.
A successful new user registration requires the following valid data: 

![create_new_acct](https://github.com/n-edmond/Foundations_of_SE/blob/main/Images/create_new_acct.png)

•	User name: it must start with a letter and consist of only letters and digits without any space character. User name is case insensitive. Different users must have different user names. 
•	Password: it must have at least six characters, consist of only letters, digits, and special characters (@, #, $, ^, &), and at least one upper-case letter, one lower-case letter, one digit, and one special character.
•	First name: it must consist of only letters
•	Last name: it must consist of only letters
•	Email address: it must be a valid email address
•	Phone number: it must include three-digit area code and seven digit phone number
These data items are represented as instance variables in the UserAcccount class in the business package. The “register new user” and “login” user stories are implemented by the following methods in the UserAccountManager class, respectively: 
•	public String registerNewUser(String userName, String password, String reenteredPassword, String firstName, String lastName, String email, String phone)

•	public UserAccount login(String userName, String password)

For the registerNewUser method, reenteredPassword is listed as a parameter so that all the parameters are corresponding to the data entries provided in the GUI as shown in the following screenshot. The acceptance criteria for “register new user” should consider whether reenteredPassword matches password. 
 


wiki page - https://github.com/n-edmond/Foundations_of_SE/wiki/Assignment-1

________________________________________________________________________________________________________
               
### Assignment 2- Assignment TBD

wiki page - TBD

________________________________________________________________________________________________________

### Final Project
wiki page - TBD
