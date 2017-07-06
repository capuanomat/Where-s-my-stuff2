package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.ArrayList;
import java.util.List;

public class FoundItemPageActivity extends AppCompatActivity {

    /** Instance variable to display the list of lostItems **/
    private ListView listView;

    EditText searchBar;

    List<Item> searchFoundItems;

    /** Database variable and array to pull out lostItems from database **/
    private ItemsDB myDB2;
    List<Item> foundItems;

    /** Buttons **/
    Button btnBackToMain;
    Button searchButton;

    /**
     *
     * @param savedInstanceState instance state used to launch
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_item_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.foundItems);
        myDB2 = new ItemsDB(this);
        foundItems = myDB2.getFoundItems();
        btnBackToMain = (Button) findViewById(R.id.buttonBackToMainFound);

        searchBar = (EditText) findViewById(R.id.searchBar);
        searchButton = (Button) findViewById(R.id.searchButton);

        ArrayAdapter<Item> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, foundItems
        );
        listView.setAdapter(arrayAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddFoundItem = new Intent(FoundItemPageActivity.this,
                        addFoundItemActivity.class);
                startActivity(intentAddFoundItem);
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackToMain = new Intent(FoundItemPageActivity.this,
                        MainPageActivity.class);
                startActivity(intentBackToMain);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSearch();
            }
        });
    }

    /**
     * reads edit text view for search, makes a new database and adapter to fill items that fit are
     * with search
     */
    private void attemptSearch() {
        String search = searchBar.getText().toString().toLowerCase();
        searchFoundItems = new ArrayList<>();
        //ALEXANDER: searches array to find the items with searched for date, this was done because
        //the date is what is shown currently on found item page
        //TODO: change display to name and description, and then modify search accordingly
        for(Item item: myDB2.getFoundItems()) {
            if (item.getName().toLowerCase().equals(search)) {
                searchFoundItems.add(item);
            }
//             else if (item.getDescription().equals(search)) {
//                searchFoundItems.add(item);
//            } else if (item.getLocation().equals(search)) {
//                searchFoundItems.add(item);
//            } else if (item.getDate().equals(search)) {
//                searchFoundItems.add(item);
//            }

        }
        ArrayAdapter<Item> searchArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, searchFoundItems);
        listView.setAdapter(searchArrayAdapter);
        if (searchFoundItems.size() == 0) {
            Toast.makeText(FoundItemPageActivity.this, "No items found! Please search again!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(FoundItemPageActivity.this, "Here are your search results",
                    Toast.LENGTH_LONG).show();
//            Intent intentRefreshFoundPage = new Intent(FoundItemPageActivity.this,
//                    FoundItemPageActivity.class);
//            startActivity(intentRefreshFoundPage);
        }
    }

}
