package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.matthieujbcapuano.wheresmystuff.Data.LostItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.List;

//ALEXANDER: Built from a combination M3 and Creating Lists Tutorial online
public class LostItemPage extends AppCompatActivity {

    /**
     * Instance variables for ???
     **/
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListView listView;

    /**
     * Database variables
     **/
    private LostItemsDB myDB2;
    List<Item> items;

    /**
     * Buttons
     **/
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Alex stuff **/
        //mRecyclerView = (RecyclerView) findViewById(R.id.lostRecyclerView);
        listView = (ListView) findViewById(R.id.lostItems);

        /** Database stuff **/
        myDB2 = new LostItemsDB(this);
        items = myDB2.getLostItems();

        ArrayAdapter<Item> arrayAdapter = new ArrayAdapter<Item>(
                this, android.R.layout.simple_list_item_1, items
        );
        listView.setAdapter(arrayAdapter);

        btnDelete = (Button) findViewById(R.id.buttonDeleteLItem);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDB2.deleteItem("9");
                if (deleteRows > 0) {
                    Toast.makeText(LostItemPage.this, "Data was deleted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LostItemPage.this, "Data was NOT deleted!", Toast.LENGTH_SHORT).show();
                    // TODO: Add a more descriptive error message here
                }
            }
        });

        /** Initializing the floating action button and setting it off if pressed **/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddLostItem = new Intent(LostItemPage.this, addLostItemActivity.class);
                startActivity(intentAddLostItem);
            }
        });

//        /** Alex stuff **/
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        addLostItemActivity lostItemManager = new addLostItemActivity();
//        //ArrayList<LostItem> list = lostItemManager.getLostItemsList();
//        mAdapter = new MyAdapter(items);
//        mRecyclerView.setAdapter(mAdapter);
    }
}






//    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//        private List<Item> mDataset;
//
//        // Provide a reference to the views for each data item
//        // Complex data items may need more than one view per item, and
//        // you provide access to all the views for a data item in a view holder
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            // each data item is just a string in this case
//            public TextView mTextView;
//            public ViewHolder(TextView v) {
//                super(v);
//                mTextView = v;
//            }
//        }
//
//        // Provide a suitable constructor (depends on the kind of dataset)
//        public MyAdapter(List<Item> myDataset) {
//            mDataset = myDataset;
//        }
//
//        // Create new views (invoked by the layout manager)
//        @Override
//        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
//                                                       int viewType) {
//            // create a new view
////            TextView v = (TextView) LayoutInflater.from(parent.getContext())
////                    .inflate(R.layout.content_lost_item_page, parent, false);
//
////            ViewHolder vh = new ViewHolder(v);
////            return vh;
//            return null;
//        }
//
//        // Replace the contents of a view (invoked by the layout manager)
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            // - get element from your dataset at this position
//            // - replace the contents of the view with that element
//            holder.mTextView.setText(mDataset.get(position).toString());
//
//        }
//
//        // Return the size of your dataset
//        @Override
//        public int getItemCount() {
//            if (mDataset != null) {
//                return mDataset.size();
//            }
//            return 0;
//        }
//    }
//}
