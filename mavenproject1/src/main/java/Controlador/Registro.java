/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Usuario;
import java.util.Scanner;

/**
 *
 * @author Aldha
 */
public class Registro {
       private Usuario[]usuarios=new Usuario[10];
       private int contador=0;
       private int GenerarId(){
         return (int)(Math.random() * 90000) + 10000;
       }
       
       public void registroUsuarios(){
           if(contador>=usuarios.length){
               System.out.println("Registros completos");
               return;
           }
           Scanner reader = new Scanner(System.in);
           System.out.println("Ingrese el correo");
           String correo = reader.nextLine();
           
           if (!Usuario.ValidarCorreo(correo)) {
            System.out.println("Patron de correo inválido");
                return;
            }
           
           for(int i =0;i<usuarios.length;i++){
               if(usuarios[i].getEmail().equalsIgnoreCase(correo)){
                   System.out.println("Correo ya registrado");
                   return;
               }
           }
           
           System.out.println("Ingrese su contraseña");
           String contraseña=reader.nextLine();
           
           usuarios[contador]= new Usuario(GenerarId(),correo,contraseña);
           contador++;
           System.out.println("Usuario registrado");
        } 
}
