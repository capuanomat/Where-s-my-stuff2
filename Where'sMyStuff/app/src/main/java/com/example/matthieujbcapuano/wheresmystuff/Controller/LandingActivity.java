package com.example.matthieujbcapuano.wheresmystuff.Controller;

import com.example.matthieujbcapuano.wheresmystuff.Model.*;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {

    static String TAG = "LandingActivity";

    // MATTHIEU: This is the variable we'll use to store all our users, has a getter below
    private UserManager _userManager = new UserManager();
    private ArrayList<User> userArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Application is running, YAY!!!");

        // MATTHIEU: This is for the button on the bottom right I think
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // MATTHIEU: This is for the login button
        Button buttonLogin = (Button) (findViewById(R.id.buttonLogin));
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(LandingActivity.this, LoginActivity.class);
                intentLogin.putExtra("userManager", userArray);
                startActivity(intentLogin);
            }
        });

        //MATTHIEU: This is for the Register button
        Button buttonRegister = (Button) (findViewById(R.id.buttonRegister));
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LandingActivity.this, RegistrationActivity.class);
                intentRegister.putExtra("userManager", userArray);
                startActivity(intentRegister);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
