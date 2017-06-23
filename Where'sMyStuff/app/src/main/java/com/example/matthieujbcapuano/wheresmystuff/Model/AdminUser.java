package com.example.matthieujbcapuano.wheresmystuff.Model;

public class AdminUser extends User {
        public AdminUser(String name, String userName, String password, int[] phoneNumber,
        String email) {
            super(name, userName, password, phoneNumber, email, false, true);
        }

    /**
     * Alexander: replaces 'user' with 'admin' in printout, to show if we are creating generic users or admins
     * @return String printout, tells all the info on the admin
     */
    @Override
    public String toString() {
        if (phoneNumber.length <= 1) {
            return "Admin--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
                    password + " Phone Number: " + phoneNumber[0] + " Email: " + email + " Banned: "
                    + banned;
        } else {
            String printout = "Admin--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
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

