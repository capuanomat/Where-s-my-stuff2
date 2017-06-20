package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.matthieujbcapuano.wheresmystuff.R;

public class MainPageActivity extends AppCompatActivity {

    static String TAG = "MainPageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //MATTHIEU: ADDING THE CODE TO SEND USER BACK TO WELCOME SCREEN IF LOGOUT IS PRESSED
        Button buttonLogout = (Button) (findViewById(R.id.buttonLogout));
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "MATTHIEU: Lougout Button was Pressed!");
                Intent intentLogout = new Intent(MainPageActivity.this, WelcomeScreenActivity.class);
                startActivity(intentLogout);
            }
        });

    }
}
