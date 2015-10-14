package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mibancooperacional.bd.MiBancoOperacional;
import mibancooperacional.pojo.Cliente;

public class login extends AppCompatActivity {

    //Creamos la variable EditText para recoger el DNI del usuario
    private EditText et_dni;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enlazamos la variable creada con el campo correspondiente de la activity
        et_dni=(EditText)findViewById(R.id.et_dni);

        et_password=(EditText) findViewById(R.id.et_password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    //Función para crear intent al pulsar sobre el botón Salir
    public void botonSalir(View view){
        Intent intent = new Intent (login.this, MainActivity.class);
        startActivity(intent);
    }

    //Función para crear intent al pulsar sobre el botón Entrar
    public void botonEntrar(View view){
        //Paso a String el EditText et_dni
        String dni=et_dni.getText().toString();
        String password=et_password.getText().toString();

        Cliente cli = new Cliente();
        cli.setNif(dni);
        cli.setClaveSeguridad(password);
        //Toast toast1= Toast.makeText(this, a.getNif()+" "+a.getClaveSeguridad(), Toast.LENGTH_LONG);
        //toast1.show();

        MiBancoOperacional mbo=MiBancoOperacional.getInstance(this);

        cli=mbo.login(cli);

        if (cli==null){
            Toast toast= Toast.makeText(this, "El nombre de usuario o contraseña no es válido", Toast.LENGTH_LONG);
            toast.show();
            //Limpiar valores et_dni y et_password
            dni="";
            password="";

        }else {


            //Creamos el intent que nos llevará a la pantalla de bienvenida
            //Intent intent = new Intent(login.this, Bienvenida.class);
            //Enviamos la información del dni mediante el Intent a la pantalla de bienvenida
            //intent.putExtra("mensaje", dni);
            //iniciamos el Intent


            //Pasos para crear un Bundle y enviarlo a la siguiente activity
            Intent intent=new Intent (login.this, Bienvenida.class);
            Bundle bolsa=new Bundle();
            bolsa.putSerializable("clientekey", cli);
            intent.putExtras(bolsa);
            startActivity(intent);
        }
    }
}
