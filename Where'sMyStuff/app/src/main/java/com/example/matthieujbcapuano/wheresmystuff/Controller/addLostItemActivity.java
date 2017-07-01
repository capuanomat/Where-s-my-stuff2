package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matthieujbcapuano.wheresmystuff.Data.LostItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.Model.LostItem;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class addLostItemActivity extends AppCompatActivity {

    /**
     * Instance variables to read input fields from UI
     */
    private EditText mNameView;
    private EditText mDescriptionView;
    private EditText mLocationView;
    private EditText mDateView;

    /**
     * Instance variable to store lost items
     */
    ArrayList<LostItem> lostItemsList;

    Button addLostItemButton;

    /**
     * Instance variables to try to store user data
     */
    LostItemsDB myDB2;

    /** Getter for the array of lost items **/
    public ArrayList<LostItem> getLostItemsList() {
        return lostItemsList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lost_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Reading in the data **/
        mNameView = (EditText) findViewById(R.id.name);
        mDescriptionView = (EditText) findViewById(R.id.description);
        mLocationView = (EditText) findViewById(R.id.location);
        mDateView = (EditText) findViewById(R.id.date);

        /** Initializing the list where we will store lost items **/
        lostItemsList = new ArrayList<>();

        /** Initializing database variables **/
        myDB2 = new LostItemsDB(this);

        /** Initializing the "Post Lost Item" Button and setting it off if clicked**/
        addLostItemButton = (Button) findViewById(R.id.buttonAddLost);
        addLostItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptToAddLostItem();
            }
        });
    }

    /** Instance variables to store data from the UI **/
    String name, description, location, date;

    private void attemptToAddLostItem() {
        name = mNameView.getText().toString();
        description = mDescriptionView.getText().toString();
        location = mLocationView.getText().toString();
        date = mDateView.getText().toString();

        //TODO: Add verification that the item is of appropriate format before adding it

        /** Creates the new lost item instance and tries to add it to the list **/
        LostItem lostItem = new LostItem(name, description, location, date);
        boolean added = lostItemsList.add(lostItem);

        /*
        if (added) {
            Intent returnToLostPage = new Intent(addLostItemActivity.this, LostItemPage.class);
            startActivity(returnToLostPage);
        } else {
            Toast.makeText(addLostItemActivity.this, "Item was not inserted!", Toast.LENGTH_LONG).show();
        }
        */
        AddData();
    }

    public void AddData() {
        boolean isInserted = myDB2.addLostItem(new Item(name, description, location, date, "Lost"));
        if (isInserted) {
            Toast.makeText(addLostItemActivity.this, "Item was posted!", Toast.LENGTH_LONG).show();
            Intent backToLostPage = new Intent(addLostItemActivity.this, LostItemPage.class);
            startActivity(backToLostPage);
        } else {
            Toast.makeText(addLostItemActivity.this, "Item was NOT posted!!", Toast.LENGTH_LONG).show();
            //TODO: Add more descriptive error message here
        }
    }
}
