package Model;


import java.util.ArrayList;

public class User {

    /**
     * Instance variables to describe everything important about the user.
     */
    String name;
    String userName;
    String password;
    long[] phoneNumber;
    String email;
    boolean banned;
    boolean isAdmin;
    ArrayList<Item> lostItems;
    ArrayList<Item> toDeliver;
    
    public static ArrayList<Item> nullList = new ArrayList<Item>();

    /**
     *  Constructor with all 8 parameters.
     * @param name          Name of user
     * @param userName      Username of user
     * @param password      Password of user
     * @param phoneNumber   Phone Number of user
     * @param email         Email of user
     * @param banned        Whether the user is banned or not
     * @param isAdmin       Whether the user is an admin or not
     * @param lostItems
     * @param toDeliver
     * TODO: Add constructors with fewer arguments and do constructor chaining to this one.
     */
    public User(String name, String userName, String password,
            long[] phoneNumber, String email, boolean banned, boolean isAdmin, 
            ArrayList<Item> lostItems, ArrayList<Item> toDeliver) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.banned = banned;
        this.isAdmin = isAdmin;
        /*hey Matt and Alex, making a user an admin is as simple as setting
        this boolean*/
        this.lostItems = lostItems;
        this.toDeliver = toDeliver;
    }

    public User(String name, String username, String password) {
        this(name, username, password, new long[0], "", false, false, nullList, 
                nullList);
    }

    public User(String username, String password) {
        this("", username, password, new long[0], "", false, false, nullList,
                nullList);
    }

    public User() {
        this("", "", "", new long[0], "", false, false, nullList, nullList);
    }

    /**
     * Getter for name variable.
     * @return  Name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for username of user.
     * @return The username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Getter for the password.
     * @return  Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the phone number(s).
     * @return  Phone number(s)
     */
    public String getPhoneNumber() {
        String number = "";
        if (phoneNumber.length <= 1) {
            number += phoneNumber[0];
        } else {
            for (int i = 0; i < phoneNumber.length; i++) {
                number += phoneNumber[i] + " ";
            }
        }
        return number;
    }

    /**
     * Getter for the email.
     * @return  Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for banned status.
     * @return  Whether the user is banned or not.
     */
    public boolean getBanned() {
        return banned;
    }

    /**
     * Getter for the admin Status.
     * @return  Whether user is admin or not.
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * toString method for the User Class. Is o verriden by the RegularUser and AdminUser classes.
     * @return  A string describing all important details about the user
     * TODO: It may be better to do instanceof and not override this method in Regular/AdminUser
     */
    public String toString() {
        String toPrint =
                "User------ Name: " + name + ", UserName: " + userName + ", Password: " + password;
        if (phoneNumber.length <= 1) {
            toPrint = toPrint + ", Phone Number: " + phoneNumber[0];
        } else {
            for (long i : phoneNumber) {
                toPrint += i + " ";
            }
        }
        toPrint = toPrint + ", Email: " + email + ", Banned: " + banned;
        return toPrint;
    }




    /**********************************************************************************************
     * ALEXANDER: Borrowed from M3, These methods are required by the parcelable interface
     * SIMOLA: Altered method by writing my own relay for the data
     
    private User(DataShuttle in) {
        this.userName = in.getInfo();
        this.password = in.getInfo();
        this.name = in.getInfo();
        this.phoneNumber = in.getInfo();
        this.email = in.getInfo();
        this.banned = in.getInfo();
        this.lostItems = in.getInfo();
        this.toDeliver = in.getInfo();
    }

    /* *************************
       If you add new instance vars to Student, you will need to add them to the write
     
    public void writeToUserRelay(DataShuttle dest) {
        
    }*/

}
