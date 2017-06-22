package com.example.matthieujbcapuano.wheresmystuff;
import java.util.ArrayList;
/**
 * Created by Alezx on 6/22/2017.
 */

public class UserManager {
    ArrayList<UserModel> allUsers;
    ArrayList<String> allPasswords;
    ArrayList<String> allUserNames;


    public UserManager() {
        allUsers = new ArrayList<>();
        allUsers.add(new RegularUser("Bob", "user","pass", new int[0] , "email"));
        allUserNames = new ArrayList<>();
        allUserNames.add("user");
        allPasswords = new ArrayList<>();
        allPasswords.add("pass");
    }
    //
    //ALEXANDER: might be a useful method to have later
//    public UserModel findUser(UserModel){
//
//    }

    public boolean loginAttempt(String username, String password) {
        for(UserModel u: allUsers) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public UserModel addUser(UserModel user) {
        allUsers.add(user);
        allUserNames.add(user.getUserName());
        allPasswords.add(user.getPassword());
        return user;
    }
   //ALEXANDER: to make sure there are no duplicate usernames
    public boolean findValidUsername(String username) {
        if (allUserNames == null) {
            return true;
        }
        for (String s: allUserNames) {
            if(s.equals(username)) {
                return false;
            }
        }
        return true;
    }

    //ALEXANDER: to make sure there ar eno duplicate passwords
    public boolean findValidPassword(String password) {
        if (allPasswords == null) {
            return true;
        }
        for (String s: allPasswords) {
            if(s.equals(password)) {
                return false;
            }
        }
        return true;
    }
}
