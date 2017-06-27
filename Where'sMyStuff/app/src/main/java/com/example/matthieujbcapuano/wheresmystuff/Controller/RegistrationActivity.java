package com.example.matthieujbcapuano.wheresmystuff.Controller;

import com.example.matthieujbcapuano.wheresmystuff.Data.DatabaseHelper;
import com.example.matthieujbcapuano.wheresmystuff.Model.*;
import com.example.matthieujbcapuano.wheresmystuff.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
     * Buttons on the registration screen
     */
    Button btnRegister;
    Button btnCancel;

    /**
     * Instance variables to try to store user data
     */
    ArrayList<User> userArray;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        /** Reading in the data **/
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
        myDb = new DatabaseHelper(this);

        /** When the buttons are pressed **/
        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
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
     * After the data was read in during OnCreate, these variables will store the strings specifically.
     */
    String password, username, name, initialPhoneNumber, email, userType;

    private void attemptRegister(ArrayList<User> userArray) {
        password = mPasswordView.getText().toString();
        username = mUsernameView.getText().toString();
        name = mNameView.getText().toString();
        initialPhoneNumber = String.valueOf(mPhoneNumberView.getText());
        email = mEmailView.getText().toString();
        userType = userTypeSpinner.getSelectedItem().toString();

        // TODO: Figure out how we want to deal with phone numbers (2,147,483,647 is largest int).
        int[] phoneNumber = new int[1];

        boolean isAdmin = userType.equals("Admin");

        User user;
        if (isAdmin) {
            user = new AdminUser(name, username, password, phoneNumber, email);
        } else {
            user = new RegularUser(name, username, password, phoneNumber, email);
        }
        userArray.add(user);
        AddData();
    }

    // TODO: This and the three methods below check that input data is correct. We can improve them.
    private boolean isEmailValid(String email) {
        if (!email.contains("@")) {
            Toast.makeText(RegistrationActivity.this, "Email is invalid", Toast.LENGTH_LONG).show();
        }
        return email.contains("@");
    }

    //ALEXANDER: added this method, implemented userManager's method
    private boolean isUserNameValid(String username) {
        return true; //_userManager.findValidUsername(username);
    }

    //ALEXANDER: changed this method from template, implemented usermanager's method
    private boolean isPasswordValid(String password) {
        return true; //_userManager.findValidPassword(password);
    }


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

