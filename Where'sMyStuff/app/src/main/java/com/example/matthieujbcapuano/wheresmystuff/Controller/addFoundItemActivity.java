package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Condition;
import com.example.matthieujbcapuano.wheresmystuff.Model.FoundItem;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.Model.ItemCategory;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;

public class addFoundItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    /** Instance variables to read input fields from the UI **/
    private EditText mNameView;
    private EditText mDescriptionView;
    private EditText mLocationView;
    private EditText mDateView;
    private Spinner conditionSpinner;
    private Spinner categorySpinner;

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
        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

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

        /**Putting the names of the item categories**/
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ItemCategory.catarr());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);


        /**Doing the same for the conditions**/
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Condition.condarr());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(adapter2);
    }

    /** Instance variables to store data from the UI **/
    String name, description, location, date;
    ItemCategory cat;
    Condition status;

    /**
     * reads views for information, creates a new foun item
     */
    private void attemptToAddFoundItem() {
        name = mNameView.getText().toString();
        description = mDescriptionView.getText().toString();
        location = mLocationView.getText().toString();
        date = mDateView.getText().toString();
        status = (Condition) conditionSpinner.getSelectedItem();
        cat = (ItemCategory) categorySpinner.getSelectedItem();

        //TODO: Add verification that the item is of appropriate format before adding it

        /** Creates the new found item instance and tries to add it to the list **/
        FoundItem foundItem = new FoundItem(name, description, location, date, status, cat);
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
        boolean isInserted = myDB2.addFoundItem(new Item(name, description, location, date, status, cat));
        if (isInserted) {
            Toast.makeText(addFoundItemActivity.this, "Item successfully listed", Toast.LENGTH_LONG).show();
            Intent backToFoundPage = new Intent(addFoundItemActivity.this, FoundItemPageActivity.class);
            startActivity(backToFoundPage);
        } else {
            Toast.makeText(addFoundItemActivity.this, "An error occurred while posting this item.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == categorySpinner) {
            cat = (ItemCategory) parent.getItemAtPosition(position);
        } else {
            status = (Condition) parent.getItemAtPosition(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){
        if (parent == categorySpinner) {
            cat = ItemCategory.OTHER_NONE;
        } else {
            status = Condition.NONE_UNKNOWN;
        }
    }
}
