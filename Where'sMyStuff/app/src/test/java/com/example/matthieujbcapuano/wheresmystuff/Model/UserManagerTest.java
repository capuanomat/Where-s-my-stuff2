package com.example.matthieujbcapuano.wheresmystuff.Model;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sharence on 7/15/2017.
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