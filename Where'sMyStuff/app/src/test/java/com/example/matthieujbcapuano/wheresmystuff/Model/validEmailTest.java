package com.example.matthieujbcapuano.wheresmystuff.Model;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ash Bhimasani on 7/18/2017.
 */

/**
 * METHOD CONTRACT:
 * Signature: method name is findValidEmail, parameters is an email string, returns boolean
 * Preconditions: can be called at anytime
 * Postconditions: object is not modified by method only accessed
 * Framing Conditons: no instance variables are modified
 * Invariants: none
 */
public class validEmailTest {
    @Test
    public void findValidEmail() throws Exception {
        int[] phn = {111111};
        User user = new User("Ash", "user", "pass", phn, "wigglytuff@yahoo.com", false, false);
        UserManager um = new UserManager();
        um.getAllEmails().clear();
        boolean output = um.findValidEmail("wigglytuff@yahoo.com");

        //Test when userNames list is empty
        Assert.assertEquals(true, output);

        //Test a valid email that is not in email list
        um.addUser(user);
        output = um.findValidEmail("snorlax@gmail.com");
        Assert.assertEquals(true, output);

        //Test an invalid email that is already in email list
        output = um.findValidEmail("wigglytuff@yahoo.com");
        Assert.assertEquals(false, output);
    }

}