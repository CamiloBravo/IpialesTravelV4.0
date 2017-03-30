package com.camilobc.ipialestravel;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DrawerSitiosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    String username, correo;
//    TextView tUsername, tCorreo;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_sitios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

//        tUsername=(TextView) findViewById(R.id.tUsername1);
//        tCorreo=(TextView) findViewById(R.id.tCorreo1);

        Bundle extras=getIntent().getExtras(); //el bbundle es para extraer datos
        username=extras.getString("username");
        correo=extras.getString("correo");

//        tUsername.setText(username);
//        tCorreo.setText(correo);

        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

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

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0: Sitio1 tab1 = new Sitio1();
                    return tab1;
                case 1: Sitio2 tab2 = new Sitio2();
                    return tab2;
                case 2: Sitio3 tab3 = new Sitio3();
                    return tab3;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Las Lajas";
                case 1:
                    return "Charco";
                case 2:
                    return "Gran Plaza";
            }
            return null;
        }
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
        getMenuInflater().inflate(R.menu.drawer_sitios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.Principal: //este tambien esta en menu.xml
                intent = new Intent(DrawerSitiosActivity.this, DrawerMainActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.parques: //este tambien esta en menu.xml
                intent =new Intent(DrawerSitiosActivity.this, ListActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.miPerfil: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerSitiosActivity.this, DrawerPerfilActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.hotel: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerSitiosActivity.this, DrawerHotelActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.bares: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerSitiosActivity.this, DrawerBarActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.cerrar: //cerrar es nombre de menu.xml
                intent = new Intent(DrawerSitiosActivity.this, LoginActivity.class); //ojo a lo que antepone el this!!!
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dMain) {
            intent = new Intent(DrawerSitiosActivity.this, DrawerMainActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        } else if (id == R.id.dPerfil) {
            intent = new Intent(DrawerSitiosActivity.this, DrawerPerfilActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        } else if (id == R.id.dHotel) {
            intent = new Intent(DrawerSitiosActivity.this, DrawerHotelActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.dBar) {
            intent = new Intent(DrawerSitiosActivity.this, DrawerBarActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.dParques) {
            intent = new Intent(DrawerSitiosActivity.this, ListActivity.class); //ojo a lo que antepone el this!!!
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
