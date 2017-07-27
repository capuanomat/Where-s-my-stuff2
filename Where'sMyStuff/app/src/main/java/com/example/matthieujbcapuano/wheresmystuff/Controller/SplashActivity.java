package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matthieujbcapuano.wheresmystuff.R;

/**
 * Created by simolanayak on 7/26/17.
 */

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    private ImageView img;
    private TextView txt;
    private TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        img = (ImageView) findViewById(R.id.pup_img);
        txt = (TextView) findViewById(R.id.wms_title);
        slogan = (TextView) findViewById(R.id.textView4);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                //it will go from Splash Activity to the Landing Activity
                Intent i = new Intent(SplashActivity.this, LandingActivity.class);
                startActivity(i);

                // close the splash screen
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
