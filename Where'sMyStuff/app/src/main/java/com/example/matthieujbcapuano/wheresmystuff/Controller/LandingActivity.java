package com.example.matthieujbcapuano.wheresmystuff.Controller;

import com.example.matthieujbcapuano.wheresmystuff.Model.*;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {

    /**
     * Descriptive tag about the activity to user when Logging stuff
     */
    static String TAG = "LandingActivity";

    // MATTHIEU: This is the variable we'll use to store all our users, has a getter below
    //private UserManager _userManager = new UserManager();
    private ArrayList<User> userArray = new ArrayList<>();

    //RegisteredUsersDB myDb;
    //EditText editName, editUsername, editPassword;

    // Buttons
    FloatingActionButton fab;
    Button btnLogin;
    Button btnRegister;

    //RegisteredUsersDB myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //myDb = new RegisteredUsersDB(this);

        // MATTHIEU: The three buttons
        fab = (FloatingActionButton) findViewById(R.id.fab);
        btnLogin = (Button) (findViewById(R.id.buttonLogin));
        btnRegister = (Button) (findViewById(R.id.buttonRegister));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(LandingActivity.this, LoginActivity.class);
                intentLogin.putExtra("userManager", userArray);
                startActivity(intentLogin);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LandingActivity.this, RegistrationActivity.class);
                intentRegister.putExtra("userManager", userArray);
                startActivity(intentRegister);
            }
        });
    }

    // ----------------------------------------- MAYBE REMOVABLE -------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds lostItems to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            /**
             * MATTHIEU: iF YOU ADDED AN ACTIVITY AND WANT THE SETTINGS PAGE (THREE LITTLE DOTS ON
             *           TOP RIGHT TO REDIRECT TO THAT PAGE, THIS IS WHERE YOU'D ADD THE CODE.
             *           e.g.
             *           Intent intentLogin = new Intent(this, LoginActivity.class);
             *           startActivity(intentLogin);
             */
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
