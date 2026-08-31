/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.util.Scanner;

//Ejercicio 1.  Multiplicación de una matriz por un escalar
//Dada una matriz de 3x3 ingresada por el usuario y un número entero (escalar), generar una nueva
//matriz donde cada elemento sea el resultado de multiplicar el valor original por el escalar.

/**
 *
 * @author ltluc
 */
public class EJERCICIO_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int[][] resultado = new int[3][3];

        System.out.println("Ingrese los 9 elementos de la matriz:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.print("Ingrese el escalar: ");
        int escalar = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }

        System.out.println("Matriz resultante:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}


