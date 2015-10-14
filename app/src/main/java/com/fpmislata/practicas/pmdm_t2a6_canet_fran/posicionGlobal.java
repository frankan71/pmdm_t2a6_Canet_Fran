package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mibancooperacional.bd.MiBancoOperacional;
import mibancooperacional.pojo.Cliente;
import mibancooperacional.pojo.Cuenta;

public class posicionGlobal extends AppCompatActivity {

    //Declaramos el cliente
    Cliente cli;

    //Declaramos las variables necesarias para crear la lista
    ListView lista;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posicion_global);



        //Aquí cojo del bundle el cliente que está serializado, por lo que tengo que acer un cast a Cliente
        Bundle bolsaRecibida=getIntent().getExtras();
        cli=(Cliente) bolsaRecibida.getSerializable("clientekey");

        //Creamos el array con los objeto cuenta para poder generar la lista
        ArrayList<Cuenta> Cuentas = new ArrayList<>();
        MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);
        Cuentas= mbo.getCuentas(cli);

        //Creamos el Array numeroCuentas y saldos para poder cargar los números de cuenas del objeto Cuentas
        ArrayList<String> numeroCuentas = new ArrayList();
        ArrayList<String> saldos = new ArrayList();
        List tareas = new ArrayList<Tarea>();

        //for (int i=0; i<Cuentas.size(); i++){
            //numeroCuentas.add ("Nº de Cuenta (" + (i+1)+"): "+ Cuentas.get(i).getNumeroCuenta());
            //saldos.add ("Saldo actual: "+ Cuentas.get(i).getSaldoActual() );
        //}

        for (int i=0; i<Cuentas.size(); i++){
            tareas.add(new Tarea(" Nº Cuenta: "+Cuentas.get(i).getNumeroCuenta(), " Saldo: "+String.valueOf(Cuentas.get(i).getSaldoActual())+"€"));
        }

        //Creo la referencia a la lista
        lista = (ListView) findViewById(R.id.lista);

        //inicializamos el adaptador para un solo item
        //adaptador=new MiArrayAdapter<String>(this,numeroCuentas);

        //inicializamos el adaptador
        adaptador=new MiArrayAdapter<String>(this,tareas);

        lista.setAdapter(adaptador);

    }
}
