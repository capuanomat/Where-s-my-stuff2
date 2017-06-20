package com.example.matthieujbcapuano.wheresmystuff;

/**
 * Created by Alezx on 6/19/2017.
 */

public class AdminUser extends UserModel {
        public AdminUser(String name, String userName, String password, int[] phoneNumber,
        String email, boolean banned, boolean banPermission) {
            super(name, userName, password, phoneNumber, email, banned, banPermission);
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
                    + banned + " Ban Permission: " + banPermission;
        } else {
            String printout = "Admin--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
                    password + " Phone Number: ";
            for (int i = 0; i < phoneNumber.length; i++) {
                printout += phoneNumber[i] + " ";
            }
            printout += " Email: " + email + " Banned: "
                    + banned + " Ban Permission: " + banPermission;
            return printout;
        }
    }
}

