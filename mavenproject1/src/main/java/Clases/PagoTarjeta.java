/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author MARCOS NOTEBOOK
 */
public class PagoTarjeta extends MetodoPago {
    private String numeroTarjeta;
    private String fechaVencimiento;
    
    // getter y setter
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    // metodo para validar si el numero de tarjeta tiene 16 digitos
    
    public boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}");
    }

    public void procesarTarjeta() {
        System.out.println("Procesando pago con tarjeta de " + getNombreTitular() + "...");
    }

    //valida y procesa la targe y si falla rechaza el pago
    
    @Override
    public void procesarPago() {
        if (validarTarjeta()) {
            procesarTarjeta();
            System.out.println("Pago con tarjeta aprobado.");
        } else {
            System.out.println("Número de tarjeta inválido. Pago rechazado.");
        }
    }
}
