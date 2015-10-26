package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import mibancooperacional.bd.MiBancoOperacional;
import mibancooperacional.pojo.Cliente;
import mibancooperacional.pojo.Cuenta;

public class Bienvenida extends AppCompatActivity {

    //Creamos las variables para enlazar con los campos de la activity
    private TextView tv_bienvenida;


    Cliente cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);


        //Aquí cojo del bundle el cliente que está serializado, por lo que tengo que acer un cast a Cliente
        Bundle bolsaRecibida=getIntent().getExtras();
        cli=(Cliente) bolsaRecibida.getSerializable("clientekey");


        //Recogemos el dato que recibimos con el Intent
        //String dniRecibido=getIntent().getStringExtra("mensaje");

        //Enlazamos la variable creada con el campo correspondiente de la activity
        tv_bienvenida=(TextView)findViewById(R.id.tv_bienvenida);


        //Mostramos el mensaje de bienvenida en el textView
        tv_bienvenida.setText("Bienvenido "+ cli.getNombre().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenida, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void botonClave(View view){
        Intent intent = new Intent(Bienvenida.this, cambiarClave.class);
        Bundle bolsa=new Bundle();
        bolsa.putSerializable("clientekey", cli);
        intent.putExtras(bolsa);

        startActivity(intent);
    }


    public void botonPosicionGlobal(View view){
        //Pasos para crear un Bundle y enviarlo a la siguiente activity
        Intent intent=new Intent (Bienvenida.this, posicionGlobal.class);
        Bundle bolsa=new Bundle();
        bolsa.putSerializable("clientekey", cli);
        intent.putExtras(bolsa);
        startActivity(intent);

    }
}
