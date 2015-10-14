package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Bienvenida extends AppCompatActivity {

    //Creamos las variables para enlazar con los campos de la activity
    private TextView tv_bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        //Recogemos el dato que recibimos con el Intent
        String dniRecibido=getIntent().getStringExtra("mensaje");

        //Enlazamos la variable creada con el campo correspondiente de la activity
        tv_bienvenida=(TextView)findViewById(R.id.tv_bienvenida);


        //Mostramos el mensaje de bienvenida en el textView
        tv_bienvenida.setText("Bienvenido "+ dniRecibido);


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
        startActivity(intent);
    }
}
