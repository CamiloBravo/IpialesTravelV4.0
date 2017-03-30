package com.camilobc.ipialestravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class DrawerMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, correo;
    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);

        prefs= getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        Bundle extras=getIntent().getExtras(); //el bbundle es para extraer datos
        username=extras.getString("username");
        correo=extras.getString("correo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.bares: //este tambien esta en menu.xml
                intent = new Intent(DrawerMainActivity.this, DrawerBarActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.parques: //este tambien esta en menu.xml
                intent =new Intent(DrawerMainActivity.this, ListActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.miPerfil: //este tambien esta en menu.xml
                intent = new Intent(DrawerMainActivity.this, DrawerPerfilActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.sitios: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerMainActivity.this, DrawerSitiosActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.hotel: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerMainActivity.this, DrawerHotelActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.cerrar: //cerrar es nombre de menu.xml
                editor.putInt("login",-1); //aqui coloca el -1, para que quede sin login
                editor.commit();
                intent = new Intent(DrawerMainActivity.this, LoginActivity.class); //ojo a lo que antepone el this!!!
                startActivity(intent);
                finish();
                break;
        }
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.dPerfil) {
            intent = new Intent(DrawerMainActivity.this, DrawerPerfilActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.dHotel) {
           intent = new Intent(DrawerMainActivity.this, DrawerHotelActivity.class); //ojo a lo que antepone el this!!!
           intent.putExtra("username", username);
           intent.putExtra("correo", correo);
           startActivity(intent);
           finish();

        } else if (id == R.id.dBar) {
           intent = new Intent(DrawerMainActivity.this, DrawerBarActivity.class); //ojo a lo que antepone el this!!!
           intent.putExtra("username", username);
           intent.putExtra("correo", correo);
           startActivity(intent);
           finish();

        } else if (id == R.id.dSitios) {
            intent = new Intent(DrawerMainActivity.this, DrawerSitiosActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.dParques) {
           intent = new Intent(DrawerMainActivity.this, ListActivity.class); //ojo a lo que antepone el this!!!
           intent.putExtra("username", username);
           intent.putExtra("correo", correo);
           startActivity(intent);
           finish();
       } else if (id == R.id.dCerrar) {
           editor.putInt("login",-1); //aqui coloca el -1, para que quede sin login
           editor.commit();
           intent =new Intent(DrawerMainActivity.this, LoginActivity.class); //ojo a lo que antepone el this!!!
           intent.putExtra("username", username);
           intent.putExtra("correo", correo);
           startActivity(intent);
           finish();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
