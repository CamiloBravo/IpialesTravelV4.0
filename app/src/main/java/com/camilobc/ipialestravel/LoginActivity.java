package com.camilobc.ipialestravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUser, ePass;
    Button bIniciar;
    TextView tRegistro;
    String username, password, correo;
    Intent intent;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs= getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        username=prefs.getString("username","noname");
        password=prefs.getString("password","nopass");
        correo=prefs.getString("correo","nocorreo");

        Log.d("login",String.valueOf(prefs.getInt("login",-1))); //esto es para seguir estos datos, es decir, mirar que esta sacando en la consola
        Log.d("username",username);
        Log.d("password",password);
        Log.d("correo",correo);

        if (prefs.getInt("login",-1)==1) //1 si hay alguien loggeado, -1 no hay
        {
            intent =new Intent(LoginActivity.this, DrawerMainActivity.class); //ojo a lo que antepone el this!!!
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
        eUser=(EditText) findViewById(R.id.eUser);
        ePass=(EditText) findViewById(R.id.ePass);
        bIniciar=(Button) findViewById(R.id.bIniciar);
        tRegistro=(TextView) findViewById(R.id.tRegistro);

        tRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LoginActivity.this, RegistroActivity.class); //ojo a lo que antepone el this!!!
                startActivityForResult(intent,1234);
            }
        });


        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (eUser.getText().toString().equals(username) && ePass.getText().toString().equals(password))
                    {
                        editor.putInt("login",1); //aqui coloca el 1, para saber que hay alguien loggeado
                        editor.commit();

                        intent =new Intent(LoginActivity.this, DrawerMainActivity.class); //ojo a lo que antepone el this!!!
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "El usuario ingresado no existe", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK)
        {
            username=data.getExtras().getString("username");
            password=data.getExtras().getString("contrasena");
            correo=data.getExtras().getString("correo");

            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("correo",correo);
            editor.commit();
            Log.d("username",username);
        }
        else
        {
            if (requestCode==1234 && resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show(); //Ojo que Toast tiene un retardo, puede hacer la app lenta
            }
        }
    }
}
