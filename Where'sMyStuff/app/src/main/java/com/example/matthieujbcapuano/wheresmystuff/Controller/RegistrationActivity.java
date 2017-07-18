package com.example.matthieujbcapuano.wheresmystuff.Controller;

import com.example.matthieujbcapuano.wheresmystuff.Data.RegisteredUsersDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.*;
import com.example.matthieujbcapuano.wheresmystuff.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    static String TAG = "RegistrationActivity";

    /**
     * Instance variables to read the input fields on the UI
     */
    private EditText mUsernameView;
    private EditText mPasswordView;
    private EditText mNameView;
    private EditText mPhoneNumberView;
    private EditText mEmailView;
    private Spinner userTypeSpinner;

    /**
     * After the data is read during OnCreate, these variables will store the strings specifically.
     */
    String username, password, name, initialPhoneNumber, email, userType;

    /**
     * Buttons on the registration screen
     */
    Button btnRegister;
    Button btnCancel;

    /**
     * Instance variables to try to store user data
     */
    ArrayList<User> userArray;
    RegisteredUsersDB myDb;

    /**
     *
     * @param savedInstanceState instance state for launch
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        /* Reading in the data */
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        mNameView = (EditText) findViewById(R.id.name);
        mPhoneNumberView = (EditText) findViewById(R.id.name);
        mEmailView = (EditText) findViewById(R.id.email);
        userTypeSpinner = (Spinner) findViewById(R.id.userTypeSpinner);

        /** Displays the drop down options  on the spinner correctly **/
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, User.legalUserTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(adapter);

        /** The two buttons **/
        btnRegister = (Button) findViewById(R.id.registerButton);
        btnCancel = (Button) findViewById(R.id.buttonCancelRegister);

        /** Initializing database variables **/
        Bundle bundle = getIntent().getExtras();
        userArray = bundle.getParcelableArrayList("userManager");
        myDb = new RegisteredUsersDB(this);

        /** When the buttons are pressed **/
        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister(userArray);
            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLanding = new Intent(RegistrationActivity.this, LandingActivity.class);
                startActivity(intentLanding);
            }
        });
    }


    /**
     *
     * @param userArray list of all users
     */
    private void attemptRegister(ArrayList<User> userArray) {
        username = mUsernameView.getText().toString();
        password = mPasswordView.getText().toString();
        name = mNameView.getText().toString();
        initialPhoneNumber = String.valueOf(mPhoneNumberView.getText());
        email = mEmailView.getText().toString();
        userType = userTypeSpinner.getSelectedItem().toString();

        // TODO: Figure out how we want to deal with phone numbers (2,147,483,647 is largest int).
        int[] phoneNumber = new int[1];

        boolean isAdmin = userType.equals("Admin");

        User user;
        View focusView = null; // This may be necessary to add the little error messages
        if (isAdmin) {
            user = new AdminUser(name, username, password, phoneNumber, email);
        } else {
            user = new RegularUser(name, username, password, phoneNumber, email);
        }

        boolean error = false;
        if (isUserNameValid(username) && isPasswordValid(password) && isEmailValid(email)) {
            userArray.add(user);
            AddData();
        } else {
            if (!isUserNameValid(username)){
                mUsernameView.setError(getString(R.string.error_invalid_username));
                focusView = mUsernameView;
            } else if (!isPasswordValid(password)) {
                mPasswordView.setError(getString(R.string.error_invalid_password));
                focusView = mPasswordView;
            } else {
                mEmailView.setError(getString(R.string.error_invalid_email));
                focusView = mEmailView;
            }
            error = true;
        }
        if (error) {
            focusView.requestFocus();
        }
    }

    // TODO: This and the three methods below check that input data is correct. We can improve them.

    /**
     *
     * @param email the email to check
     * @return whether or not email is valid
     */
    private boolean isEmailValid(String email) {
        if (!email.contains("@")) {
            Toast.makeText(RegistrationActivity.this, "Email is invalid", Toast.LENGTH_LONG).show();
        }
        return email.contains("@");
    }

    /**
     *
     * @param username the username to check
     * @return whether or not the username is valid
     */
    private boolean isUserNameValid(String username) {
        return (username.length() <= 10); //_userManager.findValidUsername(username);
    }

    /**
     *
     * @param password the password to check
     * @return whether or not the password is valid
     */
    public boolean isPasswordValid(String password) {
        if (myDb == null) {
            return true;
        } else {
            for (User user : myDb.getAccounts()) {
                if (user.getPassword().equals(password)) {
                    return false;
                }
            }
            return true;
        }
        //return (password.length() <= 10); //_userManager.findValidPassword(password);
    }

    public RegisteredUsersDB getMyDb() {
        return myDb;
    }

    /**
     * checks if user was added to database, posts message
     */
    public void AddData() {
        boolean isInserted = myDb.addAccount(new User(name, username, password));
        if(isInserted) {
            Toast.makeText(RegistrationActivity.this, "Data was Inserted!", Toast.LENGTH_LONG).show();
            this.finish();
        } else {
            Toast.makeText(RegistrationActivity.this, "Data was NOT Inserted!", Toast.LENGTH_LONG).show();
            // TODO: Add a more descriptive error message here
        }
    }
}

