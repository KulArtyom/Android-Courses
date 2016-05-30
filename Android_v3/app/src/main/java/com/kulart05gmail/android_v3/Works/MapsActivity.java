package com.kulart05gmail.android_v3.Works;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.kulart05gmail.android_v3.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


        LatLng Minsk = new LatLng(53.90433816, 27.56744385);
        mMap.addMarker(new MarkerOptions().position(Minsk).title("Minsk"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Minsk));

        LatLng Magiley = new LatLng(53.89786522, 30.33874512);
        mMap.addMarker(new MarkerOptions().position(Magiley).title("Magiley"));

        LatLng Vitebsk = new LatLng(55.17886766, 30.20690918);
        mMap.addMarker(new MarkerOptions().position(Vitebsk).title("Vitebsk"));

        LatLng Grodno = new LatLng(53.67718827, 23.82385254);
        mMap.addMarker(new MarkerOptions().position(Grodno).title("Grodno"));

        LatLng Brest = new LatLng(52.09975693, 23.72497559);
        mMap.addMarker(new MarkerOptions().position(Brest).title("Brest"));

        LatLng Gomel = new LatLng(52.44261787, 30.99243164);
        mMap.addMarker(new MarkerOptions().position(Gomel).title("Gomel"));

        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(52.09975693, 23.72497559))  // Brest
                .add(new LatLng(53.90433816, 27.56744385))  // Minsk

        );
        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(52.44261787, 30.99243164))  // Gomel
                .add(new LatLng(53.90433816, 27.56744385))  // Minsk

        );

        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(53.89786522, 30.33874512))  // Magilew
                .add(new LatLng(53.90433816, 27.56744385))  // Minsk

        );

        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(55.17886766, 30.20690918))  // Vitebsk
                .add(new LatLng(53.90433816, 27.56744385))  // Minsk

        );

        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(53.67718827, 23.82385254))  // Grodno
                .add(new LatLng(53.90433816, 27.56744385))  // Minsk

        );


    }
}
