package com.example.matthieujbcapuano.wheresmystuff;

/**
 * Created by Alexander on 6/17/2017.
 */

public class UserModel {
    String userName;
    String password;
    String name;
    int[] phoneNumber;
    String email;
    boolean banned;
    boolean banPermission;

    public UserModel(String name, String userName, String password, int[] phoneNumber,
                     String email, boolean banned, boolean banPermission) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.banned = banned;
        this.banPermission = banPermission;
    }

    public String toString() {
        if (phoneNumber.length <= 1) {
            return "User--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
                    password + " Phone Number: " + phoneNumber[0] + " Email: " + email + " Banned: "
                    + banned + " Ban Permission: " + banPermission;
        } else {
            String printout = "User--- Name:  " + name + " " + "UserName: " + userName + " Password: " +
                    password + " Phone Number: ";
            for (int i = 0; i < phoneNumber.length; i++) {
                printout += phoneNumber[i] + " ";
            }
            printout += " Email: " + email + " Banned: "
                    + banned + " Ban Permission: " + banPermission;
            return printout;
        }
    }
    public String getName() {
        return "Name: " + name;
    }

    public String getUserName() {
        return "Username " + userName;
    }

    public String getPassword() {
        return "Password: " + password;
    }

    public String getEmail() {
        return "Email: " + email;
    }

    public String getPhoneNumber() {
        String number;
        if (phoneNumber.length <= 1) {
            number = "Number: " + phoneNumber[0];
        } else {
            number = "Number: ";
            for (int i = 0; i < phoneNumber.length; i++) {
                number += phoneNumber[i] + " ";
            }
        }
        return number;
    }
//Alexander: Haven't implemented these yet, will need a phoneNumber list instead of array
//    public String addNumber(int newNumber) {
//
//    }
//
//    public String removeNumber(int numberToBeReplaced) {
//
//    }


}
