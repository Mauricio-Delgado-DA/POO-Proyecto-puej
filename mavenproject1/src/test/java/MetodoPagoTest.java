/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MARCOS NOTEBOOK
 */

import Controlador.MetodoPagoControlador;
import java.util.Scanner;

public class MetodoPagoTest {
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        MetodoPagoControlador controlador = new MetodoPagoControlador();

        System.out.println("=== METODOS DE PAGO - SUSCRIPCION ===");
        System.out.println("1.Visa");
        System.out.println("2.Efectivo");
        System.out.println("Seleccione una opcion: ");
        int opcion = lector.nextInt();

        controlador.procesarPago(opcion);
    }
}