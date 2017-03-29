package com.camilobc.ipialestravel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

   // String[] bares = new String[]{"shots", "yesterday", "madrid"};
    private Lista_entrada[] datos=new Lista_entrada[]{
           new Lista_entrada(R.drawable.pola, "Parque La Pola", "Parque insignia del municipio", "calle 7 #12-A"),
           new Lista_entrada(R.drawable.santander, "Parque 20 de Julio", "Sitio de eventos y festejos", "calle 9 #13-B"),
           new Lista_entrada(R.drawable.julio, "Parque Santander", "Lugar cultural de Ipiales", "calle 8 #11-A")
   };

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.list);
        Adapter adapter= new Adapter(this, datos);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data= ((Lista_entrada) parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ListActivity.this, HotelActivity.class);
                startActivity(intent);

            }
        });

    //    ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bares);

      //  list.setAdapter(adapter);
    }
    class Adapter extends ArrayAdapter<Lista_entrada>{

        public Adapter(@NonNull Context context, Lista_entrada[] datos) { //recibe contecto y arreglo
            super(context, R.layout.list_item,datos); //Retorna el array con la info
        }
        //ctrl + O y buscar getview
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView nombre=(TextView) item.findViewById(R.id.Nombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip=(TextView) item.findViewById(R.id.Descrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc=(TextView) item.findViewById(R.id.Direcc);
            direc.setText(datos[position].getDirec());

            ImageView imagen= (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
            //return super.getView(position, convertView, parent);
        }
    }
}
