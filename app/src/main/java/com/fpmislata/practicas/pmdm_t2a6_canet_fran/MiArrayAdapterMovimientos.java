package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fran on 17/10/2015.
 */
public class MiArrayAdapterMovimientos<T> extends ArrayAdapter<T> {

    public MiArrayAdapterMovimientos(Context context, List<T> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //obtenemos una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvamos la referencia del view de la fila
        View listItemView=convertView;

        //Comprobamos si el view no existe
        if(null==convertView){
            //Si no existe, entonces inflarlo con two_line_list_item.xml
            listItemView=inflater.inflate(R.layout.elemento_lista_movimientos,parent,false);
        }

        //Obtengo las instancias de los textViews
        TextView texto1=(TextView)listItemView.findViewById(R.id.txt_tipo);
        TextView texto2=(TextView)listItemView.findViewById(R.id.txt_fecha);
        TextView texto3=(TextView)listItemView.findViewById(R.id.txt_descripcion);
        TextView texto4=(TextView)listItemView.findViewById(R.id.txt_importe);

        //Obtengo la instancia de la tarea en la posición actual
        T item = (T)getItem(position);

        //Divido la cadena en cuenta y saldo
        String cadenaBruta;
        String subCadenas[];
        String delimitador=";";

        cadenaBruta=item.toString();
        subCadenas=cadenaBruta.split(delimitador,4);

        texto1.setText(subCadenas[0]);
        texto2.setText(subCadenas[1]);
        texto3.setText(subCadenas[2]);
        texto4.setText(subCadenas[3]);

        //Devuelvo al listView la fila creada
        return listItemView;
    }
}
