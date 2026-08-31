/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.Scanner;

//Ejercicio 2.  Búsqueda del valor mínimo y cuántas veces se repite
//Dada una matriz de nxm(n y m son ingresados por el usuario, encontrar el valor mínimo y contar
//cuántas veces aparece dentro de la matriz (puede repetirse en más de una posición).

/**
 *
 * @author ltluc
 */
public class EJERCICIO_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de filas: ");
        int n = sc.nextInt();
        System.out.print("Ingrese el numero de columnas : ");
        int m = sc.nextInt();

        int[][] matriz = new int[n][m];

        System.out.println("Ingrese los " + (n * m) + " elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
           }

        int minimo = matriz[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
             }
            }
           }

        int contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == minimo) {
                    contador++;
                 }
          }
      }

        System.out.println("\nEl valor minimo es: " + minimo);
        System.out.println("Aparece " + contador + " veces en la matriz.");
    }
}

