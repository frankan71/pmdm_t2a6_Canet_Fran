package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mibancooperacional.bd.MiBancoOperacional;
import mibancooperacional.pojo.Cliente;
import mibancooperacional.pojo.Cuenta;
import mibancooperacional.pojo.Movimiento;

public class movimientosCuenta extends AppCompatActivity {
    //Declaramos Cuenta
    Cuenta cuenta;

    //Declaramos las variables necesarias para crear la lista
    ListView lista;
    ArrayAdapter<String> adaptador;

    //Obtenemos una instancia de MiBancoOperacional para trabajar con ella
    MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos_cuenta);

        //Aquí cojo del bundle la cuenta que está serializado, por lo que tengo que hacer un cast a Cuenta
        Bundle bolsaRecibida=getIntent().getExtras();
        cuenta=(Cuenta) bolsaRecibida.getSerializable("cuentakey");



        //Creamos el array con los objeto movimiento para poder generar la lista de movimientos
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        movimientos = mbo.getMovimientos(cuenta);

        //Creamos los Array de tipo, fechaoperacion, descripcion e importe para poder cargar los
        // datos que necesitamos mostrar del objeto movimientos
        ArrayList<String> tipoMovimiento = new ArrayList();
        ArrayList<String> fechaMovimiento = new ArrayList();
        ArrayList<String> descripcionMovimiento = new ArrayList();
        ArrayList<String> importeMovimiento = new ArrayList();

        List tareas2 = new ArrayList<TareaMovimientos>();

        //Vamos a darle a saldo formato de numero
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("es","ES"));

        //Vamos a darle formato a la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd - MMMM - yyyy  (H:mm:ss)");

        for (int i=0; i<movimientos.size(); i++){
            tareas2.add(new TareaMovimientos(" Tipo Movimiento: "+String.valueOf( movimientos.get(i).getTipo()),
                    " Fecha de operacion: "+ sdf.format(movimientos.get(i).getFechaOperacion()).toString(),
                    " Descripción: "+movimientos.get(i).getDescripcion(),
                    " Importe : "+formatoImporte.format((movimientos.get(i).getImporte()))));
        }

        //Creo la referencia a la lista
        lista = (ListView) findViewById(R.id.listaMovimientos);

        //inicializamos el adaptador
        adaptador=new MiArrayAdapterMovimientos<String>(this,tareas2);

        lista.setAdapter(adaptador);


    }
}
