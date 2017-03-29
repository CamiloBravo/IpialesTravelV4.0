package com.camilobc.ipialestravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String username, correo;
    TextView tUsername, tCorreo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername=(TextView) findViewById(R.id.tUsername1);
        tCorreo=(TextView) findViewById(R.id.tCorreo1);

        Bundle extras=getIntent().getExtras(); //el bbundle es para extraer datos
        username=extras.getString("username");
        correo=extras.getString("correo");

        tUsername.setText(username);
        tCorreo.setText(correo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.cerrar: //cerrar es nombre de menu.xml
                intent =new Intent(PerfilActivity.this, LoginActivity.class); //ojo a lo que antepone el this!!!
                startActivity(intent);
                finish();
                break;
            case R.id.Principal: //este tambien esta en menu.xml
                intent =new Intent(PerfilActivity.this, MainActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.parques: //este tambien esta en menu.xml
                intent =new Intent(PerfilActivity.this, ListActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.sitios: //cerrar es nombre de menu.xml
                intent =new Intent(PerfilActivity.this, SitiosActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.bares: //cerrar es nombre de menu.xml
                intent =new Intent(PerfilActivity.this, BaresActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.hotel: //cerrar es nombre de menu.xml
                intent =new Intent(PerfilActivity.this, HotelActivity.class); //ojo a lo que antepone el this!!!
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
