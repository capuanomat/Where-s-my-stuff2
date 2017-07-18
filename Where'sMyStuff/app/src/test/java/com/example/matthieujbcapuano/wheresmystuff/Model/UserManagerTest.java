package com.example.matthieujbcapuano.wheresmystuff.Model;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sharence on 7/15/2017.
 *
 * Method Contract:
 *
 * findValidUsername is a public method of UserManager class and username is a string that is being
 * checked to see if someone else has the same username. The method returns true if allUserNames:
 * ArrayList is empty or does not contain the param; returns false if allUserNames does contain
 * the param.
 *
 * Signature:
 * + findValidUsername(username: String) : boolean
 *
 * Preconditions:
 * 1) username is of String type
 * 2) Instance of allUserNames ArrayList with size >= 0
 *
 * Postcondition:
 * 1) Returns true or false of whether Username is valid
 *
 * Invariants:
 * 1) Size of allUserNames >= 0
 *
 * Framing Conditions:
 * 1) If method returns true, the username may be added to the list if password is valid too.
 
 */
public class UserManagerTest {
    @Test
    public void findValidUsername() throws Exception {
        int[] phn = {123};
        User chance = new User("Sharence Solomero", "chance", "pass", phn, "email", false, false);
        UserManager um = new UserManager();
        um.getAllUserNames().clear();
        boolean output = um.findValidUsername("chance");

        //Test when userNames list is empty
        Assert.assertEquals(true, output);

        //Test a vaild username that is not in userNames list
        um.addUser(chance);
        output = um.findValidUsername("girl");
        Assert.assertEquals(true, output);

        //Test an invalid username that is already in userNames list
        output = um.findValidUsername("chance");
        Assert.assertEquals(false, output);
    }

}