package com.example.matthieujbcapuano.wheresmystuff.Model;

public class AdminUser extends User {
    /**
     * Constructor for the AdminUser class.
     * @param name          Name of the user
     * @param userName      Username of the user
     * @param password      Password of the user
     * @param phoneNumber   Phone number of the user
     * @param email         Email address of the user
     */
    public AdminUser(String name, String userName, String password, int[] phoneNumber,
        String email) {
        super(name, userName, password, phoneNumber, email, false, true);
    }

    /**
     * Overrides the User class toString method to show that the user is a regular user.
     * @return  A string detailing all elements of the user
     * TODO: It may be unnecessary to completely override this method just to mention "Admin---"
     * TODO: Try adding instanceof(RegularUser) in the User class to adjust the string instead
     * change
     */
    @Override
    public String toString() {
        if (phoneNumber.length <= 1) {
            return "Admin--- Name:  " + name + " "
                    + "UserName: " + userName
                    + " Password: " + password
                    + " Phone Number: " + phoneNumber[0]
                    + " Email: " + email
                    + " Banned: " + banned;
        } else {
            String printout = "Admin--- Name:  " + name
                    + " UserName: " + userName
                    + " Password: " + password
                    + " Phone Number: ";
            for (int i = 0; i < phoneNumber.length; i++) {
                printout += phoneNumber[i] + " ";
            }
            printout += " Email: " + email + " Banned: " + banned;
            return printout;
        }
    }
}

