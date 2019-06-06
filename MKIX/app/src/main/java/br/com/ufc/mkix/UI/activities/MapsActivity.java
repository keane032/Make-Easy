package br.com.ufc.mkix.UI.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import br.com.ufc.mkix.R;

public class MapsActivity extends FragmentActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private static final int MY_LOCATION_REQUEST_CODE = 250;
    private GoogleMap mMap;
    private Location myLocation;
    private float zoom = 15;
    private ArrayList<LatLng> trabalhadoresLocations = new ArrayList<>();


    private boolean mPermissionDenied = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        enableMyLocation();

        getTrabalhadoresLocations();
        addMarkes();


    }


    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
           mMap.setMyLocationEnabled(true);

           LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
           this.myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

           if(myLocation != null){
               double latitude = myLocation.getLatitude();
               double longitude = myLocation.getLongitude();
                LatLng cPosition = new LatLng(latitude,longitude);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cPosition,zoom));
           }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }

    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }


    public void getTrabalhadoresLocations(){
        //Dados não persistentes
        this.trabalhadoresLocations.add(new LatLng(-4.968840, -39.018357));
//        this.trabalhadoresLocations.add(new LatLng(-4.967266, -39.012839));
//        this.trabalhadoresLocations.add(new LatLng(-4.970783, -39.016714));
//        this.trabalhadoresLocations.add(new LatLng(-4.981299, -39.019041));
//        this.trabalhadoresLocations.add(new LatLng(-4.980700, -39.020918));
    }

    public void addMarkes(){
        for (LatLng position:trabalhadoresLocations) {
            mMap.addMarker(new MarkerOptions().position(position).title("Trabalhador Aqui!"));
        }
    }

}
