/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author MARCOS NOTEBOOK
 */
public class PagoEfectivo extends MetodoPago {
    private String codigoTransaccion;
    
    //getter y setter 

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    // registra el pago y te muestra el codigo 
    
    public void registrarPago() {
        System.out.println("Pago en efectivo registrado. Código: " + codigoTransaccion);
    }

    // confirma el pago
    
    public void confirmarPago() {
        System.out.println("Pago confirmado con código " + codigoTransaccion + ".");
    }
    
    @Override
    public void procesarPago() {
        registrarPago();
        confirmarPago();
    }
}
