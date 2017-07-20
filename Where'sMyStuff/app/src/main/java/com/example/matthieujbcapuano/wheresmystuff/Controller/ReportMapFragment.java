package com.example.matthieujbcapuano.wheresmystuff.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.matthieujbcapuano.wheresmystuff.Data.ItemsDB;
import com.example.matthieujbcapuano.wheresmystuff.Model.Item;
import com.example.matthieujbcapuano.wheresmystuff.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by simolanayak on 7/19/17.
 */

public class ReportMapFragment extends AppCompatActivity implements OnMapReadyCallback{

    //Need to pull info from the found items
    private ItemsDB allItems = new ItemsDB(this);
    private LatLng[] reportLocations;
    private String[] reports;

    private SupportMapFragment mapFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map_report_view);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.reportLocations);
        mapFragment.getMapAsync(this);
        loadReportLocationsAndNames();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        for (int i = 0; i < reportLocations.length; i++) {
            googleMap.addMarker(new MarkerOptions().position(reportLocations[i]).title(reports[i]));
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(reportLocations[0]));
    }

    private void loadReportLocationsAndNames() {
        List<Item> allthethings = allItems.getFoundItems();
        int numReports = allthethings.size();
        LatLng[] places = new LatLng[allthethings.size()];
        String[] itemnames = new String[allthethings.size()];

        for (int i = 0; i < numReports; i++) {
            places[i] = allthethings.get(i).getLocation();
            itemnames[i] = allthethings.get(i).getName();
        }

        reportLocations = places;
        reports = itemnames;
    }
}