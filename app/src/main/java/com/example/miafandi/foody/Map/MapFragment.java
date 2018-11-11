package com.example.miafandi.foody.Map;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.miafandi.foody.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment  {
//    SupportMapFragment mapFragment;
//    GoogleMap mMap;
//    GoogleApiClient googleApiClient;
    ImageView im1, im2,im3,im4,im5,imd1,imd2,imd3,imd4,imd5;
    SearchView searchV;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        im1 = (ImageView) rootView.findViewById(R.id.pin1);
        im2 = (ImageView) rootView.findViewById(R.id.pin2);
        im3 = (ImageView) rootView.findViewById(R.id.pin3);
        im4 = (ImageView) rootView.findViewById(R.id.pin4);
        im5 = (ImageView) rootView.findViewById(R.id.pin5);
        imd1 = (ImageView) rootView.findViewById(R.id.dtp1);
        imd2 = (ImageView) rootView.findViewById(R.id.dtp2);
        imd3 = (ImageView) rootView.findViewById(R.id.dtp3);
        imd4 = (ImageView) rootView.findViewById(R.id.dtp4);
        imd5 = (ImageView) rootView.findViewById(R.id.dtp5);
        searchV = (SearchView) rootView.findViewById(R.id.searchView);

        imd1.setVisibility(View.INVISIBLE);
        imd2.setVisibility(View.INVISIBLE);
        imd3.setVisibility(View.INVISIBLE);
        imd4.setVisibility(View.INVISIBLE);
        imd5.setVisibility(View.INVISIBLE);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.VISIBLE);
                imd2.setVisibility(View.INVISIBLE);
                imd3.setVisibility(View.INVISIBLE);
                imd4.setVisibility(View.INVISIBLE);
                imd5.setVisibility(View.INVISIBLE);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.INVISIBLE);
                imd2.setVisibility(View.VISIBLE);
                imd3.setVisibility(View.INVISIBLE);
                imd4.setVisibility(View.INVISIBLE);
                imd5.setVisibility(View.INVISIBLE);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.INVISIBLE);
                imd2.setVisibility(View.INVISIBLE);
                imd3.setVisibility(View.VISIBLE);
                imd4.setVisibility(View.INVISIBLE);
                imd5.setVisibility(View.INVISIBLE);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.INVISIBLE);
                imd2.setVisibility(View.INVISIBLE);
                imd3.setVisibility(View.INVISIBLE);
                imd4.setVisibility(View.VISIBLE);
                imd5.setVisibility(View.INVISIBLE);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.INVISIBLE);
                imd2.setVisibility(View.INVISIBLE);
                imd3.setVisibility(View.INVISIBLE);
                imd4.setVisibility(View.INVISIBLE);
                imd5.setVisibility(View.VISIBLE);
            }
        });
        searchV.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imd1.setVisibility(View.INVISIBLE);
                imd2.setVisibility(View.INVISIBLE);
                imd3.setVisibility(View.INVISIBLE);
                imd4.setVisibility(View.INVISIBLE);
                imd5.setVisibility(View.INVISIBLE);

            }
        });

//
        return rootView;
    }


}
