/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class Notificacion {
  private final String mensaje;
    private boolean leida;
    
    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.leida = false;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public boolean isLeida() {
        return leida;
    }
    
    public void marcarComoLeida() {
        this.leida = true;
    }
    
    public String getResumen() {
        return (leida ? "[LEÍDA] " : "[NUEVA] ") + mensaje;
    }   
}
