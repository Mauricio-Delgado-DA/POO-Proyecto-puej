/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author MARCOS NOTEBOOK
 */
public class PagoYape extends MetodoPago {
    private String numeroTelefono;
    
    //getter y setter 
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    //verifica si el numero tiene 9 digitos
    
    public boolean validarNumero() {
        return numeroTelefono != null && numeroTelefono.matches("9\\d{8}");
    }

    // proceso de pago
    
    public void procesarYape() {
        System.out.println("Procesando pago con Yape del número " + numeroTelefono + "...");
    }

    // valida el numero y ejecuta el pago si esta correcto
    
    @Override
    public void procesarPago() {
        if (validarNumero()) {
            procesarYape();
            System.out.println("Pago con Yape confirmado.");
        } else {
            System.out.println("Número inválido. Pago rechazado.");
        }
    }
}

