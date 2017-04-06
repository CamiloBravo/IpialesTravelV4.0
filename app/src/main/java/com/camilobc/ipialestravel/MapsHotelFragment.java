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
public class MapsHotelFragment extends Fragment implements OnMapReadyCallback{

    private MapView mapView;
    private GoogleMap mMap;

    public MapsHotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_maps_hotel,container,false);
        mapView =(MapView) view.findViewById(R.id.maphotel);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mapas_bar, container, false);
        return view;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_maps_hotel, container, false);
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

        LatLng mayas= new LatLng(0.816254, -77.659982);
        mMap.addMarker(new MarkerOptions().position(mayas).title("Hosteria Mayasquer").snippet("Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_mayas_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mayas,14)); //entre mas pequeño el numero mas alto el mapa

        LatLng torre= new LatLng(0.830308, -77.643873);
        mMap.addMarker(new MarkerOptions().position(torre).title("Hotel Torre de Cristal").snippet("Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_torre_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(torre,14)); //entre mas pequeño el numero mas alto el mapa

        LatLng nubes= new LatLng(0.828801, -77.642883);
        mMap.addMarker(new MarkerOptions().position(nubes).title("Hotel Nubes Verdes").snippet("Hotel").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_nubes_opt)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nubes,14));
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
