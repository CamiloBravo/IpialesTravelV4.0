package com.camilobc.ipialestravel;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText eRuser, eRpass, eRrepass, eRcorreo;
    Button bRregistrar, bRcancelar;
    String expresion = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+.+[a-z]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        eRuser=(EditText) findViewById(R.id.eRuser);
        eRpass=(EditText) findViewById(R.id.eRpass);
        eRrepass=(EditText) findViewById(R.id.eRrepass);
        eRcorreo=(EditText) findViewById(R.id.eRcorreo);
        bRcancelar=(Button) findViewById(R.id.bRcancelar);
        bRregistrar=(Button) findViewById(R.id.bRregistrar);

        bRregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent= new Intent(RegistroActivity.this, LoginActivity.class);
                Intent intent= new Intent();//ya sabe donde va a ir por eso no lleva nada en el parentesis
                intent.putExtra("username",eRuser.getText().toString());
                intent.putExtra("contrasena",eRpass.getText().toString());
                intent.putExtra("correo",eRcorreo.getText().toString());
                intent.putExtra("Otra vez correo",eRrepass.getText().toString());
                String email=eRcorreo.getText().toString().trim();
                if((eRuser.getText().toString().equals("")) || eRpass.getText().toString().equals("") || eRcorreo.getText().toString().equals("") || eRrepass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Todos los campos deben ser diligenciados",Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED,intent);
                }
                else
                {
                    if (eRpass.length()>7)
                    {
                        if(eRpass.getText().toString().equals(eRrepass.getText().toString()))
                        {
                            setResult(RESULT_OK,intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"La contraseña no coincide",Toast.LENGTH_SHORT).show();
                            setResult(RESULT_CANCELED,intent);
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"La contraseña debe ser de al menos 8 digitos",Toast.LENGTH_SHORT).show();
                        setResult(RESULT_CANCELED,intent);
                    }

//                    Pattern pattern = Pattern.compile(expression);
//                    Matcher mather = pattern.matcher(email);
                    if (email.matches(expresion))
                    {
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegistroActivity.this, "El formato del correo no es correcto",Toast.LENGTH_SHORT).show();
                        setResult(RESULT_CANCELED,intent);
                    }
                }

            }
        });

        bRcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(RegistroActivity.this, LoginActivity.class);
                Intent intent= new Intent();
                //startActivity(intent);
                setResult(RESULT_CANCELED,intent); //para que no envie nada, ya no va la linea ant porque no relacionaba actividades
                finish(); //sin este no funciona, no me redirige a ninguna actividad
            }
        });
    }
}
