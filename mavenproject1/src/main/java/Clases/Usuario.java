/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Clases;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Aldha
 */
public class Usuario {
    private int IdUsuario;
    private String Nombre;
    private String Email;
    private String Contraseña;
    private List<String> Preferencias;

    public boolean ValidarCorreo(String correo){
        Pattern CorreoPatron=Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher matcher = CorreoPatron.matcher(correo);
        return matcher.matches();
    } 
    
    public void Registro(){
    }
    public void Inciar_Sesion(){
    }
    public void Actualizar_Perfil(){
    }
//por culminar
}   
