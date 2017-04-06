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
public class MapsSitiosFragment extends Fragment implements OnMapReadyCallback{

    private MapView mapView;
    private GoogleMap mMap;

    public MapsSitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_maps_sitios,container,false);
        mapView =(MapView) view.findViewById(R.id.mapsitios);
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

        LatLng granPlaza= new LatLng(0.830018, -77.648921);
        mMap.addMarker(new MarkerOptions().position(granPlaza).title("Gran Plaza").snippet("Centro Comercial").icon(BitmapDescriptorFactory.fromResource(R.drawable.gran40)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(granPlaza,12)); //entre mas pequeño el numero mas alto el mapa

        LatLng LasLajas= new LatLng(0.805520, -77.586019);
        mMap.addMarker(new MarkerOptions().position(LasLajas).title("Las Lajas").snippet("Santuario").icon(BitmapDescriptorFactory.fromResource(R.drawable.santuario40)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LasLajas,12)); //entre mas pequeño el numero mas alto el mapa

        LatLng Charco= new LatLng(0.821211, -77.619722);
        mMap.addMarker(new MarkerOptions().position(Charco).title("Charco").snippet("Asadero de Cuyes").icon(BitmapDescriptorFactory.fromResource(R.drawable.cuy40)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Charco,12)); //entre mas pequeño el numero mas alto el mapa
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
