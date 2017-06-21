package com.example.matthieujbcapuano.wheresmystuff.Model;

public abstract class User {
    /**
     * First three instance variables are strings to define the name of the user, username and
     * password
     */
    private String name;
    private String user;
    private String pass;

    /**
     * Variable to store contact numbers
     */
    private int[] contactNumbers;

    /**
     * Boolean variable that tells whether the user has ban permission (is an admin) or not.
     */
    private boolean banPermission;

    /**
     * Boolean variable that tells if the user is banned or not.
     */
    private boolean banned;
}
