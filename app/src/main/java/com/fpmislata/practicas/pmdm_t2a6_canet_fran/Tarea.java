package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

/**
 * Created by Fran on 15/10/2015.
 */
public class Tarea {

    private String cuenta;
    private String saldo;

    public Tarea(String cuenta, String saldo) {
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return cuenta+","+saldo;
    }
}
