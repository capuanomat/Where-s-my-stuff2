package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable{

    /**
     * Instance variable that seems to be necessary to make a class serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instance variables that will contain all users in the app, all their passwords and usernames.
     * Will be useful to search for valid usernames and passwords.
     * TODO: Consider using a hashmap.
     */
    private ArrayList<User> allUsers;
    private ArrayList<String> allUserNames;
    private ArrayList<String> allPasswords;
    private ArrayList<String> allEmails;

    /**
     * Constructor for the class. At the moment, it initializes it with a single user: "Bob", with
     * "user" and "pass" as username and password.
     * TODO: Remove the default user Bob once registration is correctly implemented.
     */
    public UserManager() {
        allUsers = new ArrayList<>();
        allUsers.add(new RegularUser("Bob", "user","pass", new int[0] , "email"));
        allUserNames = new ArrayList<>();
        allUserNames.add("user");
        allPasswords = new ArrayList<>();
        allPasswords.add("pass");
        allEmails = new ArrayList<>();
    }

    /**
     * Getter for the ArrayList<User> of all users.
     * @return  An ArrayList<User> of all users.
     */
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    /**
     * Getter for the ARrayList<String> of all usernames.
     * @return  An ArrayList<String> of all usernames
     */
    public ArrayList<String> getAllUserNames() {
        return allUserNames;
    }

    /**
     * Getter for the ArrayList<String> of all passwords.
     * @return  An ArrayList<String> of all passwords
     */
    public ArrayList<String> getAllPasswords() {
        return allPasswords;
    }

    /**
     * Getter for the ArrayList<String> of all passwords.
     * @return  An ArrayList<String> of all passwords
     */
    public ArrayList<String> getAllEmails() {
        return allEmails;
    }


    /**
     * Searches through all users in the ArrayList<User> to check if any of them have the username
     * and password provided. In which case it returns true.
     * @param username  The username input by the user for verification
     * @param password  The password input by the user for verification
     * @return          Whether the login attempt is valid or not
     */
    public boolean loginAttempt(String username, String password) {
        for(User u: allUsers) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a user to the list of all users, along with the username and password.
     * @param user  The user to be added to the list of all users
     * @return      The user passed in
     * TODO: It might make more sense to return a boolean that tells if the user was correctly added
     */
    public User addUser(User user) {
        allUsers.add(user);
        allUserNames.add(user.getUserName());
        allPasswords.add(user.getPassword());
        allEmails.add(user.getEmail());
        return user;
    }

    /**
     * Takes in a username and sees if it already exists in the UserManager. Prevents the creation
     * of multiple users with the same username.
     * @param username  The username to be checked for duplicates
     * @return          Whether the username is unique or not
     */
    public boolean findValidUsername(String username) {
        if (allUserNames.isEmpty()) {
            return true;
        }
        for (String s: allUserNames) {
            if(s.equals(username)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Takes in a password and sees if it already exists in the UserManager. Prevents the creation
     * of multiple users with the same username.
     * @param password  The password to be checked for duplicates
     * @return          Whether the password is unique or not
     */
    public boolean findValidPassword(String password) {
        if (allPasswords.isEmpty()) {
            return true;
        }
        for (String s: allPasswords) {
            if(s.equals(password)) {
                return false;
            }
        }
        return true;
    }


    /**
     * METHOD CONTRACT:
     * Signature: method name is findValidEmail, parameters is an email string, returns boolean
     * Preconditions: can be called at anytime
     * Postconditions: object is not modified by method only accessed
     * Framing Conditons: no instance variables are modified
     * Invariants: none
     * Takes in a email and sees if it already exists in the UserManager. Prevents the creation
     * of multiple users with the same email.
     * @param email  The email to be checked for duplicates
     * @return          Whether the email is unique or not
     */
    public boolean findValidEmail(String email) {
        if (allEmails.isEmpty()) {
            return true;
        }
        for (String e: allEmails) {
            if(e.equals(email)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ToString method for the UserManager class.
     * @return  The string detailing all the users, their usernames and passwords
     * TODO: This might be better formatted as a CSV list in the form "User, username, password"
     */
    @Override
    public String toString() {
        return "UserManager{";
                //+ "allUsers=" + allUsers +
                //"\n, allPasswords=" + allPasswords +
                //"\n, allUserNames=" + allUserNames +
                //'}';
    }
}
