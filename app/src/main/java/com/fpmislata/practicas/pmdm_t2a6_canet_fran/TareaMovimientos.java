package com.fpmislata.practicas.pmdm_t2a6_canet_fran;

/**
 * Created by Fran on 17/10/2015.
 */
public class TareaMovimientos {

    private String tipoMovimiento;
    private String fechaMovimiento;
    private String descripcionMovimiento;
    private String importeMovimiento;

    public TareaMovimientos(String descripcionMovimiento,String fechaMovimiento,  String importeMovimiento, String tipoMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.importeMovimiento = importeMovimiento;
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getImporteMovimiento() {
        return importeMovimiento;
    }

    public void setImporteMovimiento(String importeMovimiento) {
        this.importeMovimiento = importeMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public String toString() {
        return tipoMovimiento+";"+fechaMovimiento+";"+descripcionMovimiento+";"+importeMovimiento;
        //return tipoMovimiento+";"+descripcionMovimiento+";"+importeMovimiento;
    }
}
