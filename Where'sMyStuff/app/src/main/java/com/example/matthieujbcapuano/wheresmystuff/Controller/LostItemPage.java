package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matthieujbcapuano.wheresmystuff.Model.LostItemManager;
import com.example.matthieujbcapuano.wheresmystuff.Model.LostItem;
import com.example.matthieujbcapuano.wheresmystuff.R;

import java.util.List;

public class LostItemPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //View recyclerView = findViewById(R.id.lostRecyclerView);
        //setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        LostItemManager lostItemManager = LostItemManager.getInstance();
        //recyclerView.setAdapter(new );
    }

//    public class SimpleLostItemRecyclerViewAdapter extends
//            RecyclerView.Adapter<SimpleLostItemRecyclerViewAdapter.ViewHolder> {
//        private final List<LostItem> mLostItems;
//
//        public SimpleLostItemRecyclerViewAdapter(List<LostItem> list) {
//            mLostItems = list;
//        }
//
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(
//                R.layout.activity_lost_item_page, parent, false);
//
//        return new ViewHolder(view);
//        }
//        public onBindViewHolder(final ViewHolder holder, int position) {
//            final LostItemManager lostItemManager = LostItemManager.getInstance();
//            holder.mLostItem = mLostItems.get(position);
//            holder.mNameView.setText("" + mLostItems.get(position).getName());
//            holder.mDescriptionView.setText(mLostItems.get(position).getDescription());
//
//        }
//    }

}
