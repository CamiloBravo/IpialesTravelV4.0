package com.camilobc.ipialestravel;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapasBarFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;


    public MapasBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mapas_bar,container,false);
        mapView =(MapView) view.findViewById(R.id.mapbar);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mapas_bar, container, false);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { //cambio this por getcontext, esto lo copio desde mapsactivity
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng yesterday= new LatLng(0.830758, -77.652810);
        mMap.addMarker(new MarkerOptions().position(yesterday).title("Yesterday Pub").snippet("Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_yesterday_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yesterday,16)); //entre mas pequeño el numero mas alto el mapa

        LatLng shots= new LatLng(0.830709, -77.653607);
        mMap.addMarker(new MarkerOptions().position(shots).title("Shot mee").snippet("Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_shot_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(shots,16)); //entre mas pequeño el numero mas alto el mapa

        LatLng madrid= new LatLng(0.831418, -77.647070);
        mMap.addMarker(new MarkerOptions().position(madrid).title("Madrid Life Club").snippet("Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_madrid_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madrid,16));
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
