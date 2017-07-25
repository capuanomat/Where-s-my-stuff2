package com.example.matthieujbcapuano.wheresmystuff.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by simolanayak on 7/18/17.
 */

public class LoginAttemptTest {
    //public User(String name, String userName, String password, int[] phoneNumber,
    //String email, boolean banned, boolean isAdmin)
    UserManager manager;

    @Before
    public void buildUserManager() {
        manager = new UserManager();
        manager.addUser(new User("Randall Munroe", "xkcd", "ih8velociraptors", new int[]{902481993}, "xkcd@xkcd.com", true, true));
        manager.addUser(new User("Marie Curie", "element96", "notazombie", new int[]{301431939}, "marie@elem96.com", false, false));
        manager.addUser(new User("Michael", "higher&higher", "p4551oN3.14T", new int[]{902481993}, "cats4004@bleep.com", true, true));
        manager.addUser(new User("Moana of Motunui", "t3504life", "b4maui", new int[]{310285922}, "lupo@gmail.com", true, true));
        manager.addUser(new User("Katherine Johnson", "moonkat", "noLongerHidden", new int[]{314159265}, "johnson.katherine@nasa.gov", true, true));
        manager.addUser(new User("Xander", "muffin", "ih8velociraptors", new int[]{503911493}, "xanders@wms.com", true, true));
        manager.addUser(new User("Kitty Genovese", "aaaaaaaaa", "AAAAAAAaaaaaAAAaaa", new int[]{502392992}, "aaa@aaaaaa.com", true, true));
    }

    @Test
    //tests for logging in with the right user but password from another user
    public void rightUserWrongPassword(){
        boolean attempt = manager.loginAttempt("xkcd", "b4maui");
        assertEquals(attempt,false);
    }

    @Test
    //tests for correct login
    public void rightUserRightPassword(){
        boolean attempt = manager.loginAttempt("higher&higher", "p4551oN3.14T");
        assertEquals(attempt, true);
    }

    @Test
    //tests for user in system with a password not in the database
    public void completelyWrongPassword(){
        boolean attempt = manager.loginAttempt("t3504life", "CdaLineWhTheSkyMeetsTheSea");
        assertEquals(attempt,false);
    }

    @Test
    //tests for a valid user with a blank password field
    public void emptyPass(){
        boolean attempt = manager.loginAttempt("element96", "");
        assertEquals(attempt,false);
    }

    @Test
    //tests for a valid password with empty username field
    public void emptyUser(){
        boolean attempt = manager.loginAttempt("", "b4maui");
        assertEquals(attempt,false);
    }

    @Test
    //tests for nonexistent user
    public void nonExistentUser(){
        boolean attempt = manager.loginAttempt("sextonblake", "REPTILIANS");
        assertEquals(attempt, false);
    }

    @Test
    //tests for both fields blank
    public void fieldsBlank(){
        boolean attempt = manager.loginAttempt("", "");
        assertEquals(attempt,false);
    }

    @Test
    //tests for case sensitivity
    public void isCaseSensitive() {
        boolean attempt = manager.loginAttempt("moonkat", "NOLONGERHIDDEN");
        assertEquals(attempt, false);
    }

    @Test
    //tests for a user using the wrong alias
    public void actualNameInstead(){
        boolean attempt = manager.loginAttempt("Randall Munroe", "ih8velociraptors");
        assertEquals(attempt, false);
    }
}
