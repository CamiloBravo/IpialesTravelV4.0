package com.camilobc.ipialestravel;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
