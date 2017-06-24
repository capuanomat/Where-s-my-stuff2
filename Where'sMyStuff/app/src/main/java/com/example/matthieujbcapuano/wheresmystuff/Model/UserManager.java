package com.example.matthieujbcapuano.wheresmystuff.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable{

    private static final long serialVersionUID = 1L;

    private ArrayList<User> allUsers;
    private ArrayList<String> allPasswords;
    private ArrayList<String> allUserNames;

    public UserManager() {
        allUsers = new ArrayList<>();
        allUsers.add(new RegularUser("Bob", "user","pass", new int[0] , "email"));
        allUserNames = new ArrayList<>();
        allUserNames.add("user");
        allPasswords = new ArrayList<>();
        allPasswords.add("pass");
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public boolean loginAttempt(String username, String password) {
        for(User u: allUsers) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User addUser(User user) {
        allUsers.add(user);
        allUserNames.add(user.getUserName());
        allPasswords.add(user.getPassword());
        return user;
    }

   //ALEXANDER: Makes sure there are no  duplicate usernames
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

    //ALEXANDER: Makes sure there are no duplicate passwords
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

    @Override
    public String toString() {
        return "UserManager{";
                //+ "allUsers=" + allUsers +
                //"\n, allPasswords=" + allPasswords +
                //"\n, allUserNames=" + allUserNames +
                //'}';
    }
}
