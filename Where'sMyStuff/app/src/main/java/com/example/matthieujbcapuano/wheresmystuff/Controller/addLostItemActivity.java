package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Condition;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.Model.ItemCategory;
import com.example.matthieujbcapuano.wheresmystuff.Model.LostItem;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class addLostItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    /**
     * Instance variables to read input fields from UI
     */
    private EditText mNameView;
    private EditText mDescriptionView;
    private EditText mLocationView;
    private EditText mDateView;
    private Spinner categorySpinner;


    /** Instance variable to store lost lostItems **/
    ArrayList<LostItem> lostItemsList;

    /** Instance variables to try to store user data **/
    ItemsDB myDB2;

    /** Getter for the array of lost lostItems **/
    public ArrayList<LostItem> getLostItemsList() {
        return lostItemsList;
    }

    /** Buttons **/
    Button addLostItemButton;
    Button goToMapButton;

    /**
     *
     * @param savedInstanceState instance state to create on
     */
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
        categorySpinner = (Spinner) findViewById(R.id.catspin);

        /** Initializing the list where we will store lost lostItems **/
        lostItemsList = new ArrayList<>();

        /** Initializing database variables **/
        myDB2 = new ItemsDB(this);

        /** Initializing the "Post Lost Item" Button and setting it off if clicked**/
        addLostItemButton = (Button) findViewById(R.id.buttonAddLost);
        addLostItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptToAddLostItem();
            }
        });

        goToMapButton = (Button) findViewById(R.id.buttonEnterLoc);
        goToMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                Intent enterOnMap = new Intent(addLostItemActivity.this, EnterLocation.class);
                startActivity(enterOnMap);
            }
        });

        /**Putting the names of the item categories**/
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ItemCategory.catarr());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    /** Instance variables to store data from the UI **/
    String name, description, location, date;
    ItemCategory cat;

    /**
     * reads in views for information, creates new lost item with information
     */
    private void attemptToAddLostItem() {
        name = mNameView.getText().toString();
        description = mDescriptionView.getText().toString();
        location = mLocationView.getText().toString();
        date = mDateView.getText().toString();
        cat = (ItemCategory) categorySpinner.getSelectedItem();


        //TODO: Add verification that the item is of appropriate format before adding it

        /** Creates the new lost item instance and tries to add it to the list **/
        LostItem lostItem = new LostItem(name, description, location, date, cat);
        boolean added = lostItemsList.add(lostItem);

        /*
        if (added) {
            Intent returnToLostPage = new Intent(addLostItemActivity.this,
            LostItemPageActivity.class);
            startActivity(returnToLostPage);
        } else {
            Toast.makeText(addLostItemActivity.this, "Item was not inserted!",
            Toast.LENGTH_LONG).show();
        }
        */
        AddData();
    }

    /**
     * tells whether or not lost item was added to data base, displays message
     * reloads lost page if item was added
     */
    public void AddData() {
        boolean isInserted = myDB2.addLostItem(new Item(name, description, location, date, Condition.LOST, cat));
        if (isInserted) {
            Toast.makeText(addLostItemActivity.this, "Item listing made successfully.", Toast.LENGTH_LONG).show();
            Intent backToLostPage = new Intent(addLostItemActivity.this,
                    LostItemPageActivity.class);
            startActivity(backToLostPage);
        } else {
            Toast.makeText(addLostItemActivity.this, "An error occurred while attempting to post the item.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cat = (ItemCategory) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        cat = ItemCategory.OTHER_NONE;
    }
}
