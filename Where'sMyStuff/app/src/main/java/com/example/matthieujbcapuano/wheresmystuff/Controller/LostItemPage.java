package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matthieujbcapuano.wheresmystuff.Model.LostItemManager;
import com.example.matthieujbcapuano.wheresmystuff.Model.LostItem;
import com.example.matthieujbcapuano.wheresmystuff.R;
import com.example.matthieujbcapuano.wheresmystuff.Controller.addLostItem;

import java.util.ArrayList;
import java.util.List;
//ALEXANDER: Built from a combination M3 and Creating Lists Tutorial online
public class LostItemPage extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.lostRecyclerView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(
//        @Override
//        public void onClick(View v) {
//            Intent intentAddLostItem = new Intent(LostItemPage.this, addLostItem.class);
//            startActivity(intentAddLostItem);
//
//        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddLostItem = new Intent(LostItemPage.this, addLostItem.class);
                startActivity(intentAddLostItem);
            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        addLostItem lostItemManager = new addLostItem();
        ArrayList<LostItem> list = lostItemManager.getLostItemsList();
        mAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<LostItem> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<LostItem> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_lost_item_content, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(mDataset.get(position).toString());

        }

        // Return the size of your dataset
        @Override
        public int getItemCount() {
            if (mDataset != null) {
                return mDataset.size();
            }
            return 0;
        }
    }
}
