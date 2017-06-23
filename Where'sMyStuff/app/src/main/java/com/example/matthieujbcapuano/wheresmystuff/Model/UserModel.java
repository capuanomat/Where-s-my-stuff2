package com.example.matthieujbcapuano.wheresmystuff;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 6/17/2017.
 */

public class UserModel implements Parcelable {
    public static List<String> legalUserTypes = Arrays.asList("Regular", "Admin");
    String userName;
    String password;
    String name;
    int[] phoneNumber;
    String email;
    boolean banned;
    boolean banPermission;
    boolean isAdmin;

    public UserModel(String name, String userName, String password, int[] phoneNumber,
                     String email, boolean banned, boolean banPermission, boolean isAdmin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.banned = banned;
        this.banPermission = banPermission;
        this.isAdmin = isAdmin;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    /* *********************************
     * ALEXANDER: Borrowed from M3, These methods are required by the parcelable interface
     *
     */

    private UserModel(Parcel in) {
        userName = in.readString();
        password = in.readString();
        name = in.readString();
        phoneNumber = in.createIntArray();
        email = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /* *************************
       If you add new instance vars to Student, you will need to add them to the write
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeIntArray(phoneNumber);
        dest.writeString(email);
    }

    public static final Parcelable.Creator<UserModel> CREATOR
            = new Parcelable.Creator<UserModel>() {
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
//Alexander: Haven't implemented these yet, will need a phoneNumber list instead of array
//    public String addNumber(int newNumber) {
//
//    }
//
//    public String removeNumber(int numberToBeReplaced) {
//
//    }


}
