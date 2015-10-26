package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mibancooperacional.bd.MiBancoOperacional;
import mibancooperacional.pojo.Cliente;

public class cambiarClave extends AppCompatActivity {

    //Declaro las cvariabels de cliente y obtengo la instancia de mibancoOperacional
    Cliente cliente;
    MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);

    //Creo las variables para capturar los campos del layout
    EditText txt_claveAntigua, txt_claveNueva;

    //Creo las variable para capturar los botones
    Button bt_cancelarClave, bt_aceptarClave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_clave);

        //Enlazo los EditText con las variables
        txt_claveNueva=(EditText)findViewById(R.id.txt_claveNueva);
        txt_claveAntigua=(EditText)findViewById(R.id.txt_claveAntigua);

        bt_aceptarClave=(Button) findViewById(R.id.bt_aceptarClave);
        bt_cancelarClave=(Button) findViewById(R.id.bt_cancelarClave);

        //Aquí cojo del bundle el cliente que está serializado, por lo que tengo que acer un cast a Cliente
        Bundle bolsaRecibida=getIntent().getExtras();
        cliente=(Cliente) bolsaRecibida.getSerializable("clientekey");





    }

    public void botonCancelar(View view){
        //Pasos para crear un Bundle y enviarlo a la siguiente activity
        Intent intent=new Intent (cambiarClave.this, Bienvenida.class);
        Bundle bolsa=new Bundle();
        bolsa.putSerializable("clientekey", cliente);
        intent.putExtras(bolsa);
        startActivity(intent);
    }

    public void botonAceptar(View view){

        //Paso los editText a String
        String claveAntigua= txt_claveAntigua.getText().toString();
        String claveNueva=txt_claveNueva.getText().toString();

        if (claveAntigua.equals("") || claveNueva.equals("") ){
            Toast toast= Toast.makeText(this, "Debe cumplimentar todos los campos", Toast.LENGTH_LONG);
            toast.show();
        }else if(claveAntigua.equals(cliente.getClaveSeguridad())){
            cliente.setClaveSeguridad(claveNueva);
            mbo.changePassword(cliente);
            bt_aceptarClave.setVisibility(View.INVISIBLE);
            bt_cancelarClave.setText("Salir");

            Toast toast= Toast.makeText(this, "Nueva clave introducida correctamente", Toast.LENGTH_LONG);
            toast.show();

            txt_claveNueva.setText("");
            txt_claveAntigua.setText("");
        }else{
            Toast toast= Toast.makeText(this, "La clave actual de usuario introducida no es correcta", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
