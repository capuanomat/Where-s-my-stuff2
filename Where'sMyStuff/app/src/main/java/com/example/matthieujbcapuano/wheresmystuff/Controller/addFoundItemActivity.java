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
import android.widget.Toast;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.FoundItem;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class addFoundItemActivity extends AppCompatActivity {

    /** Instance variables to read input fields from the UI **/
    private EditText mNameView;
    private EditText mDescriptionView;
    private EditText mLocationView;
    private EditText mDateView;

    /** Instance variable to store found items **/
    ArrayList<FoundItem> foundItemsList;

    /** Variable for database **/
    ItemsDB myDB2;

    public ArrayList<FoundItem> getFoundItemsList() {return foundItemsList;}

    /** Buttons **/
    Button addFoundItemButton;

    /**
     *
     * @param savedInstanceState previous instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_found_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Reading in the data **/
        mNameView = (EditText) findViewById(R.id.nameFound);
        mDescriptionView = (EditText) findViewById(R.id.descriptionFound);
        mLocationView = (EditText) findViewById(R.id.locationFound);
        mDateView = (EditText) findViewById(R.id.dateFound);

        /** Initializing the list where we will store found items **/
        foundItemsList = new ArrayList<>();

        /** Initializing database variable **/
        myDB2 = new ItemsDB(this);

        /** Initializing the "Post Found Item" Button and setting it off if pressed **/
        addFoundItemButton = (Button) findViewById(R.id.buttonAddFound);
        addFoundItemButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                attemptToAddFoundItem();
            }
        });
    }

    /** Instance variables to store data from the UI **/
    String name, description, location, date;

    /**
     * reads views for information, creates a new foun item
     */
    private void attemptToAddFoundItem() {
        name = mNameView.getText().toString();
        description = mDescriptionView.getText().toString();
        location = mLocationView.getText().toString();
        date = mDateView.getText().toString();

        //TODO: Add verification that the item is of appropriate format before adding it

        /** Creates the new found item instance and tries to add it to the list **/
        FoundItem foundItem = new FoundItem(name, description, location, date);
        boolean added = foundItemsList.add(foundItem);

        /*
        if(added {
            Intent returnToFoundPage = new Intent(addFoundItemActivity.this, foundItemPageActivity.class);
            startActivity(returntoFoundPage);
        } else {
            Toast.makeText(addFoundItemActivity.this, "Item was not inserted!", Toast.LENGTH_LONG).show();
        }
         */
        AddData();
    }

    /**
     * tells whether or not new found item was added to database, displays text message
     * if item was added, reloads found page
     */
    public void AddData() {
        boolean isInserted = myDB2.addFoundItem(new Item(name, description, location, date, "Found"));
        if (isInserted) {
            Toast.makeText(addFoundItemActivity.this, "Item was posted!", Toast.LENGTH_LONG).show();
            Intent backToFoundPage = new Intent(addFoundItemActivity.this, FoundItemPageActivity.class);
            startActivity(backToFoundPage);
        } else {
            Toast.makeText(addFoundItemActivity.this, "Item was NOT posted!!", Toast.LENGTH_LONG).show();
            //TODO: Add more descriptive error message here
        }
    }
}
