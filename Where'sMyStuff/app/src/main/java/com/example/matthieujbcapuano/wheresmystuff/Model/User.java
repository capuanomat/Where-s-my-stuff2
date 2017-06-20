package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by Matthieu J.B Capuano on 6/20/2017.
 */

public abstract class User {
    /**
     * First three instance variables are strings to define the name of the user, username and
     * password
     */
    private String name;
    private String user;
    private String pass;

    private int[] contactNumbers;
    private boolean banPermission;
    private boolean banned;
}
