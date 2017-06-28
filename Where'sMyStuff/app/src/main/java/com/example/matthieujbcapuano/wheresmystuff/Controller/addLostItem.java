package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.matthieujbcapuano.wheresmystuff.Model.LostItem;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class addLostItem extends AppCompatActivity {

    /**
     * instance variables to read input fields from UI
     */
    private EditText mNameView;
    private EditText mDescriptionView;
    private EditText mLocationView;
    private EditText mDateView;

    /**
     *  Instance variable to store lost items
     */
    ArrayList<LostItem> lostItemsList;

    Button addLostItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lost_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * reading data and assigning to instance variable
         */
        mNameView = (EditText) findViewById(R.id.name);
        mDescriptionView = (EditText) findViewById(R.id.description);
        mLocationView = (EditText) findViewById(R.id.location);
        mDateView = (EditText) findViewById(R.id.date);
        addLostItemButton = (Button) findViewById(R.id.button);

        lostItemsList = new ArrayList<>();


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        addLostItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptToAddLostItem(lostItemsList);
            }
        });
    }
    //variables to store data we read in
    String name, description, location, date;
    private void attemptToAddLostItem(ArrayList<LostItem> lostItemsList) {
        name = mNameView.getText().toString();
        description = mDescriptionView.getText().toString();
        location = mLocationView.getText().toString();
        date = mDateView.getText().toString();

        LostItem lostItem = new LostItem(name, description, location, date);
        lostItemsList.add(lostItem);
        Button addLostItemButtonAttempt = (Button) findViewById(R.id.button);
        addLostItemButtonAttempt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToLostPage = new Intent(addLostItem.this, LostItemPage.class);
                startActivity(returnToLostPage);
            }
        });
    }

    public ArrayList<LostItem> getLostItemsList() {
        return lostItemsList;
    }

}
