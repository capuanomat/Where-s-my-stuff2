package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.List;

public class FoundItemPageActivity extends AppCompatActivity {

    /** Instance variable to display the list of lostItems **/
    private ListView listView;

    /** Database variable and array to pull out lostItems from database **/
    private ItemsDB myDB2;
    List<Item> foundItems;

    /** Buttons **/
    Button btnBackToMain;

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

        ArrayAdapter<Item> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, foundItems
        );
        listView.setAdapter(arrayAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddFoundItem = new Intent(FoundItemPageActivity.this, addLostItemActivity.class);
                startActivity(intentAddFoundItem);
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackToMain = new Intent(FoundItemPageActivity.this, MainPageActivity.class);
                startActivity(intentBackToMain);
            }
        });
    }

}
