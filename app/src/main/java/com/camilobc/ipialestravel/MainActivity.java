package com.camilobc.ipialestravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        correo=extras.getString("correo");//esto para recuperar los datos que fueron enviados al main activity para luego enviarlos a perfilactivity
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //solo llamo despues de crear menu en res/clic derecho/new/android respurcce directory

//        return super.onCreateOptionsMenu(menu); //Modifico esta opcion que salia por defecto
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.cerrar: //cerrar es nombre de menu.xml
                intent =new Intent(MainActivity.this, LoginActivity.class); //ojo a lo que antepone el this!!!
                startActivity(intent);
                finish();
                break;
            case R.id.miPerfil: //este tambien esta en menu.xml
                intent =new Intent(MainActivity.this, PerfilActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.sitios: //cerrar es nombre de menu.xml
                intent =new Intent(MainActivity.this, SitiosActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.bares: //cerrar es nombre de menu.xml
                intent =new Intent(MainActivity.this, BaresActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.hotel: //cerrar es nombre de menu.xml
                intent =new Intent(MainActivity.this, HotelActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
