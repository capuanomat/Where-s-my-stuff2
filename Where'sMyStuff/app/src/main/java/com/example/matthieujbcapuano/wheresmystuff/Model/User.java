package com.example.matthieujbcapuano.wheresmystuff.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class User implements Parcelable {
    public static List<String> legalUserTypes = Arrays.asList("Regular", "Admin");
    String name;
    String userName;
    String password;
    int[] phoneNumber;
    String email;
    boolean banned;
    boolean isAdmin;

    /**
     *  Constructor with all 8 parameters.
     * @param name          Name of user
     * @param userName      Username of user
     * @param password      Password of user
     * @param phoneNumber   Phone Number of user
     * @param email         Email of user
     * @param banned        Whether the user is banned or not
     * @param isAdmin       Whether the user is an admin or not
     */
    public User(String name, String userName, String password, int[] phoneNumber,
                String email, boolean banned, boolean isAdmin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.banned = banned;
        this.isAdmin = isAdmin;
    }

    /**
     * Getter for Name variable.
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
     * Getter for the email.
     * @return  Email
     */
    public String getEmail() {
        return email;
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

    public String toString() {
        String toPrint =
                "User------ Name: " + name + ", UserName: " + userName + ", Password: " + password;
        if (phoneNumber.length <= 1) {
            toPrint = toPrint + ", Phone Number: " + phoneNumber[0];
        } else {
            for (int i : phoneNumber) {
                toPrint += i + " ";
            }
        }
        toPrint = toPrint + ", Email: " + email + ", Banned: " + banned;
        return toPrint;
    }


    /* *********************************
     * ALEXANDER: Borrowed from M3, These methods are required by the parcelable interface
     *
     */

    private User(Parcel in) {
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

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
