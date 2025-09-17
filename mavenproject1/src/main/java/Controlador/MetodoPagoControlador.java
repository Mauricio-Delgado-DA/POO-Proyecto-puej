/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author MARCOS NOTEBOOK
 */

import Clases.MetodoPago;
import java.util.Scanner;

public class MetodoPagoControlador {
    Scanner lector = new Scanner(System.in);

    public void procesarPago(int opcion) {
        MetodoPago metodo = new MetodoPago();

        switch (opcion) {
            case 1 -> {
                // Pago con VISA
                System.out.print("Ingrese el nombre del titular: ");
                metodo.setNombreTitular(lector.nextLine());

                System.out.print("Ingrese el numero de cuenta (10 digitos): ");
                metodo.setNumeroCuenta(lector.nextLine());

                if (validarNombre(metodo.getNombreTitular()) && validarCuenta(metodo.getNumeroCuenta())) {
                    System.out.println("Pago con VISA aprobado. ¡Bienvenido " + metodo.getNombreTitular() + "!");
                } else {
                    System.out.println("Datos inválidos. Pago rechazado.");
                }
            }

            case 2 -> // Pago en EFECTIVO
                System.out.println("Pago en EFECTIVO seleccionado. Dirigete a un punto autorizado para completar la suscripcion.");

            default -> System.out.println("Opcion invalida.");
        }
    }

    private boolean validarNombre(String nombre) {
        return nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    private boolean validarCuenta(String cuenta) {
        return cuenta != null && cuenta.matches("\\d{10}");
    }
}
