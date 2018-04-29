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

//        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        if (mapFragment == null) {
//            FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            mapFragment = SupportMapFragment.newInstance();
//            ft.replace(R.id.map, mapFragment).commit();
//        }
//        mapFragment.getMapAsync(this);
        return rootView;
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//        buildClient();
////        LatLng latLng = new LatLng(22.5,88.7);
////        MarkerOptions markerOptions = new MarkerOptions();
////        markerOptions.position(latLng);
////        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
////        markerOptions.title("Current Position");
////        markerOptions.snippet("My Position");
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
////        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
////        mMap.addMarker(markerOptions);
//    }
//
//    private void buildClient() {
//        googleApiClient = new GoogleApiClient.Builder(getActivity().getApplicationContext())
//                .addConnectionCallbacks(this)
//                .addApi(LocationServices.API)
//                .build();
//        googleApiClient.connect();
//    }
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        Toast.makeText(getActivity(), "Map Connected!", Toast.LENGTH_SHORT).show();
//        LocationRequest lr = new LocationRequest();
//        lr.setInterval(1000);
//        lr.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, lr, this);
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//      //  Toast.makeText(getActivity(),"Location Changing",Toast.LENGTH_SHORT).show();
//    }
}
