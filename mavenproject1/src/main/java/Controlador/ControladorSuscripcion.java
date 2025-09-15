/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
/**
 *
 * @author Oiciruxm
 */
public class ControladorSuscripcion {
    boolean activo = false;
    public boolean ActivarSuscripcion(){
        return activo = true;
    }
    public boolean CancelarSuscripcion (){
        if (activo==true){
            return activo = false;
        }
        return activo = false;
    }
    
    public boolean RenovarSuscripcion (){
        if (activo==false){
            return activo = true;
        }
        return activo = true;
    }
}
