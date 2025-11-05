/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author MARCOS NOTEBOOK
 */
public abstract class MetodoPago {
    private String nombreTitular;
    
    // Metodo getter y setter
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    // Método abstracto para procesar el pago
    public abstract void procesarPago();
}
