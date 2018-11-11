package com.guia3Margarita.guia3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {

    public AdaptadorMensaje(Context context, List<Mensaje> lstmensajes){
        super(context,0,lstmensajes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //obteniendo Datos
        Mensaje men = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje,parent,false);
        }
        TextView mensaje = convertView.findViewById(R.id.txtMensaje);
        TextView hora = convertView.findViewById(R.id.txtHora);

        mensaje.setText(men.mensaje);
        hora.setText(men.hora);
        return convertView;
    }
}
