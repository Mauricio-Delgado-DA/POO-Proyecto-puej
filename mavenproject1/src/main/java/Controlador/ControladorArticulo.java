/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Articulo;

/**
 *
 * @author ASUS TUF GAMING
 */
public class ControladorArticulo {
    
    private Articulo[][] matrizArticulos;
    private int filas;
    private int columnas;

    public ControladorArticulo(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matrizArticulos = new Articulo[filas][columnas];
    }

    public boolean agregarArticulo(int fila, int columna, Articulo articulo) {
        if (fila < filas && columna < columnas) {
            if (matrizArticulos[fila][columna] == null) {
                matrizArticulos[fila][columna] = articulo;
                System.out.println("Artículo agregado en posición [" + fila + "][" + columna + "]");
                return true;
            } else {
                System.out.println("Ya existe un artículo en esa posición.");
            }
        }
        return false;
    }

    public void listarArticulos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizArticulos[i][j] != null) {
                    System.out.println("[" + i + "][" + j + "] " + matrizArticulos[i][j].getResumen());
                }
            }
        }
    }

    public Articulo buscarPorId(int id) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizArticulos[i][j] != null && matrizArticulos[i][j].getId() == id) {
                    return matrizArticulos[i][j];
                }
            }
        }
        return null;
    }


    public boolean eliminarArticulo(int id) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizArticulos[i][j] != null && matrizArticulos[i][j].getId() == id) {
                    System.out.println(" Eliminado: " + matrizArticulos[i][j].getTitulo());
                    matrizArticulos[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }
}

    
    
    
    
   
