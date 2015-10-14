package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Fran on 14/10/2015.
 */
public class MiArrayAdapter<T> extends ArrayAdapter<T> {


    public MiArrayAdapter(Context context, List<T> objects) {
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
            listItemView=inflater.inflate(android.R.layout.two_line_list_item,parent,false);
        }

        //Obtengo las instancias de los textViews
        TextView titulo=(TextView)listItemView.findViewById(android.R.id.text1);
        TextView subtitulo=(TextView)listItemView.findViewById(android.R.id.text2);

        //Obtengo la instancia de la tarea en la posición actual
        T item = (T)getItem(position);

        //Divido la cadena en cuenta y saldo
        String cadenaBruta;
        String subCadenas[];
        String delimitador=",";

        cadenaBruta=item.toString();
        subCadenas=cadenaBruta.split(delimitador,2);

        titulo.setText(subCadenas[0]);
        subtitulo.setText(subCadenas[1]);

        //Devuelvo al listView la fila creada
        return listItemView;
    }
}
