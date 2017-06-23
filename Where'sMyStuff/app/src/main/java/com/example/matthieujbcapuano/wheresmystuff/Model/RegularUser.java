package com.example.matthieujbcapuano.wheresmystuff.Model;

public class RegularUser extends User {

    public RegularUser(String name, String userName, String password, int[] phoneNumber,
                     String email) {
        super(name, userName, password, phoneNumber, email, false, false);
    }

    /**
     * Alexander: replaces 'user' with 'Regular User' in printout, to show which type of user
     * @return String printout, tells all the info on the regular user
     */
    @Override
    public String toString() {
        if (phoneNumber.length <= 1) {
            return "Regular User--- Name:  " + name
                    + " UserName: " + userName
                    + " Password: " + password
                    + " Phone Number: " + phoneNumber[0]
                    + " Email: " + email
                    + " Banned: " + banned;
        } else {
            String printout = "Regular User--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
                    password + " Phone Number: ";
            for (int i = 0; i < phoneNumber.length; i++) {
                printout += phoneNumber[i] + " ";
            }
            printout += " Email: " + email + " Banned: "
                    + banned;
            return printout;
        }
    }
}

