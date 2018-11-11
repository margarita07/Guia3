package com.guia3Margarita.guia3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private  AdaptadorMensaje adaptadorMensaje;
    private Button btnGuardar;
    private EditText mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        setTitle("Lista de Mensajes");
        btnGuardar = findViewById(R.id.btnEnviar);
        mensaje = findViewById(R.id.txtEntrada);
        //inicializamos el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this,MainActivity.lstMensaje);
        //inicializamos la vista de la lista
        ListView listView = findViewById(R.id.lstMensaje);
        listView.setAdapter(adaptadorMensaje);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mensaje.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"No Se pueden Enviar Mensajes Vacios",Toast.LENGTH_SHORT).show();
                }else{

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR,17);
                    calendar.set(Calendar.MINUTE, 30);
                    calendar.set(Calendar.SECOND, 2);
                    String fecha = simpleDateFormat.format(calendar.getTime());
                    String entrada = mensaje.getText().toString();
                    Mensaje nuevomensaje = new Mensaje(entrada,fecha);
                    MainActivity.lstMensaje.add(nuevomensaje);
                    mensaje.setText("");
                    adaptadorMensaje.notifyDataSetChanged();
                }
            }
        });
    }
}
