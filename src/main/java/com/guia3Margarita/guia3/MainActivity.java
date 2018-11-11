package com.guia3Margarita.guia3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variable que me dice el estado
    public static int GUARDADO=47;//puede ser un numero cualquiera
    private AdaptadorContacto adaptadorContacto;
    private FloatingActionButton btnAgregar;
    private ArrayList<Contacto> contactosArrayList;
    public static ArrayList<Mensaje> lstMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Contactos");
        btnAgregar  = findViewById(R.id.btnAgregar);
        contactosArrayList = new ArrayList<>();
        lstMensaje = new ArrayList<>();
        //Inicializando el adaptador
        adaptadorContacto = new AdaptadorContacto(this,  contactosArrayList);
        //Inicializando el listView
        ListView listView =  findViewById(R.id.lstContactos);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorContacto);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //preparo el activity
                Intent intent = new Intent(MainActivity.this,ContactoActivity.class);
                startActivityForResult(intent,GUARDADO);
            }
        });

        //cuando de click sobre un item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO cuando toco un contacto muestro un mensaje
                //Toast.makeText(MainActivity.this,"Contacto "+contactosArrayList.get(position).nombre,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,MensajeActivity.class));
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo los datos
            Contacto c = new Contacto(
                    data.getStringExtra("NOMBRE"),
                    data.getStringExtra("NUMERO")
            );
            //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
            contactosArrayList.add(c);
            adaptadorContacto.notifyDataSetChanged();
        }
    }
}
