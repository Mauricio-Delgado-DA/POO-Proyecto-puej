/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author MARCOS NOTEBOOK
 */
import Clases.*;
import java.util.Scanner;

public class MetodoPagoControlador {
    Scanner lector = new Scanner(System.in);

    public void procesarPago(int opcion) {
        MetodoPago metodo = null;

        switch (opcion) {
            case 1 -> { // TARJETA
                PagoTarjeta tarjeta = new PagoTarjeta();
                System.out.print("Ingrese el nombre del titular: ");
                tarjeta.setNombreTitular(lector.nextLine());

                System.out.print("Ingrese el número de tarjeta (16 dígitos): ");
                tarjeta.setNumeroTarjeta(lector.nextLine());

                System.out.print("Ingrese la fecha de vencimiento (MM/AA): ");
                tarjeta.setFechaVencimiento(lector.nextLine());

                metodo = tarjeta;
            }

            case 2 -> { // YAPE
                PagoYape yape = new PagoYape();
                System.out.print("Ingrese el nombre del titular: ");
                yape.setNombreTitular(lector.nextLine());

                System.out.print("Ingrese el número de teléfono (9 dígitos): ");
                yape.setNumeroTelefono(lector.nextLine());

                metodo = yape;
            }

            case 3 -> { // EFECTIVO
                PagoEfectivo efectivo = new PagoEfectivo();
                System.out.print("Ingrese el nombre del titular: ");
                efectivo.setNombreTitular(lector.nextLine());

                System.out.print("Ingrese el código de transacción: ");
                efectivo.setCodigoTransaccion(lector.nextLine());

                metodo = efectivo;
            }

            default -> System.out.println("Opción inválida.");
        }

        if (metodo != null) {
            metodo.procesarPago();
        }
    }
}

